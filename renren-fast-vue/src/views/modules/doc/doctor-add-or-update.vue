<template>
  <el-dialog
    :title="!dataForm.docId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="医生姓名" prop="docName">
      <el-input v-model="dataForm.docName" placeholder=""></el-input>
    </el-form-item>
    <!-- <el-form-item label="医生性别" prop="docSex">
      <el-input v-model="dataForm.docSex" placeholder=""></el-input>
    </el-form-item> -->
    <el-form-item label="医生性别">
      <el-radio-group v-model="dataForm.docSex">
        <el-radio label="男" />
        <el-radio label="女" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="医生年龄" prop="docAge">
      <el-input v-model="dataForm.docAge" 
      type="number"
      min=18
      placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="医生科室" prop="docField">
      <el-input v-model="dataForm.docField" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          docId: 0,
          docName: '',
          docSex: '',
          docAge: '',
          docField: ''
        },
        dataRule: {
          docName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          docSex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          docAge: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          docField: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.docId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.docId) {
            this.$http({
              url: this.$http.adornUrl(`/doc/doctor/info/${this.dataForm.docId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.docName = data.doctor.docName
                this.dataForm.docSex = data.doctor.docSex
                this.dataForm.docAge = data.doctor.docAge
                this.dataForm.docField = data.doctor.docField
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/doc/doctor/${!this.dataForm.docId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'docId': this.dataForm.docId || undefined,
                'docName': this.dataForm.docName,
                'docSex': this.dataForm.docSex,
                'docAge': this.dataForm.docAge,
                'docField': this.dataForm.docField
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>

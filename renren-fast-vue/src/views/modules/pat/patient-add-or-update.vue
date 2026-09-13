<template>
  <el-dialog
    :title="!dataForm.patId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="患者姓名" prop="patName">
      <el-input v-model="dataForm.patName" placeholder=""></el-input>
    </el-form-item>
    <!-- <el-form-item label="患者性别" prop="patSex">
      <el-input v-model="dataForm.patSex" placeholder=""></el-input>
    </el-form-item> -->
    <el-form-item label="患者性别">
      <el-radio-group v-model="dataForm.patSex">
        <el-radio label="男" />
        <el-radio label="女" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="患者年龄" prop="patAge">
      <el-input v-model="dataForm.patAge" 
      type="number"
      min=18
      placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="疾病" prop="patIllness">
      <el-input v-model="dataForm.patIllness" placeholder=""></el-input>
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
          patId: 0,
          patName: '',
          patSex: '',
          patAge: '',
          patIllness: ''
        },
        dataRule: {
          patName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          patSex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          patAge: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          patIllness: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.patId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.patId) {
            this.$http({
              url: this.$http.adornUrl(`/pat/patient/info/${this.dataForm.patId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.patName = data.patient.patName
                this.dataForm.patSex = data.patient.patSex
                this.dataForm.patAge = data.patient.patAge
                this.dataForm.patIllness = data.patient.patIllness
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
              url: this.$http.adornUrl(`/pat/patient/${!this.dataForm.patId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'patId': this.dataForm.patId || undefined,
                'patName': this.dataForm.patName,
                'patSex': this.dataForm.patSex,
                'patAge': this.dataForm.patAge,
                'patIllness': this.dataForm.patIllness
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

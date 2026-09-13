<template>
  <el-dialog
    :title="!dataForm.expId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="专家姓名" prop="expName">
      <el-input v-model="dataForm.expName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="专家年龄" prop="expAge">
      <el-input v-model="dataForm.expAge" 
      type="number"
      min=18
      placeholder=""></el-input>
    </el-form-item>
    <!-- <el-form-item label="专家性别" prop="expSex">
      <el-input v-model="dataForm.expSex" placeholder=""></el-input>
    </el-form-item> --> 
    <el-form-item label="专家性别">
      <el-radio-group v-model="dataForm.expSex">
        <el-radio label="男" />
        <el-radio label="女" />
      </el-radio-group>
    </el-form-item>
    <el-form-item label="专家领域" prop="expField">
      <el-input v-model="dataForm.expField" placeholder=""></el-input>
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
          expId: 0,
          expName: '',
          expAge: '',
          expSex: '',
          expField: ''
        },
        dataRule: {
          expName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          expAge: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          expSex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          expField: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.expId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.expId) {
            this.$http({
              url: this.$http.adornUrl(`/exp/expert/info/${this.dataForm.expId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.expName = data.expert.expName
                this.dataForm.expAge = data.expert.expAge
                this.dataForm.expSex = data.expert.expSex
                this.dataForm.expField = data.expert.expField
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
              url: this.$http.adornUrl(`/exp/expert/${!this.dataForm.expId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'expId': this.dataForm.expId || undefined,
                'expName': this.dataForm.expName,
                'expAge': this.dataForm.expAge,
                'expSex': this.dataForm.expSex,
                'expField': this.dataForm.expField
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

<template>
  <el-dialog
    :title="!dataForm.applId ? '新建' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="申请时间" prop="applTime">
      <el-input v-model="dataForm.applTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="患者编号" prop="pat1Id">
      <el-input v-model="dataForm.pat1Id" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="医生编号" prop="doc1Id">
      <el-input v-model="dataForm.doc1Id" placeholder=""></el-input>
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
          applId: 0,
          applTime: '',
          pat1Id: '',
          doc1Id: ''
        },
        dataRule: {
          applTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pat1Id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          doc1Id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.applId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.applId) {
            this.$http({
              url: this.$http.adornUrl(`/appl/application/info/${this.dataForm.applId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.applTime = data.application.applTime
                this.dataForm.pat1Id = data.application.pat1Id
                this.dataForm.doc1Id = data.application.doc1Id
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
              url: this.$http.adornUrl(`/appl/application/${!this.dataForm.applId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'applId': this.dataForm.applId || undefined,
                'applTime': this.dataForm.applTime,
                'pat1Id': this.dataForm.pat1Id,
                'doc1Id': this.dataForm.doc1Id
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

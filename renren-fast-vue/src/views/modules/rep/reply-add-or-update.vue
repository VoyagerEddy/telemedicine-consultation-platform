<template>
  <el-dialog
    :title="!dataForm.repId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="会诊编号" prop="cons1Id">
      <el-input v-model="dataForm.cons1Id" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="专家编号" prop="exp1Id">
      <el-input v-model="dataForm.exp1Id" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="回复内容" prop="repCont">
      <el-input v-model="dataForm.repCont" placeholder=""></el-input>
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
          repId: 0,
          cons1Id: '',
          exp1Id: '',
          repCont: ''
        },
        dataRule: {
          cons1Id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          exp1Id: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          repCont: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.repId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.repId) {
            this.$http({
              url: this.$http.adornUrl(`/rep/reply/info/${this.dataForm.repId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cons1Id = data.reply.cons1Id
                this.dataForm.exp1Id = data.reply.exp1Id
                this.dataForm.repCont = data.reply.repCont
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
              url: this.$http.adornUrl(`/rep/reply/${!this.dataForm.repId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'repId': this.dataForm.repId || undefined,
                'cons1Id': this.dataForm.cons1Id,
                'exp1Id': this.dataForm.exp1Id,
                'repCont': this.dataForm.repCont
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

<template>
  <el-dialog
    :title="!dataForm.consId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="药物" prop="medicine">
      <el-input v-model="dataForm.medicine"
      
       placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" 
      type="number"
      min=0
      placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="时间" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
   <!-- <el-form-item label="会诊时间">
      <el-col :span="11">
        <el-date-picker
          v-model="dataForm.time"
          type="date"
          placeholder="Pick a date"
          
        />
      </el-col>
      <el-col :span="2" class="text-center">
        <span class="text-gray-500">-</span>
       </el-col>
      <el-col :span="11">
        <el-time-picker
          v-model="dataForm.time"
          placeholder="Pick a time"
          
        />
      </el-col>
    </el-form-item> --> 
    <el-form-item label="患者编号" prop="patId">
      <el-input v-model="dataForm.patId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="医生编号" prop="docId">
      <el-input v-model="dataForm.docId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="专家编号" prop="expId">
      <el-input v-model="dataForm.expId" placeholder=""></el-input>
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
          consId: 0,
          medicine: '',
          price: '',
          time: '',
          patId: '',
          docId: '',
          expId: ''
        },
        dataRule: {
          medicine: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          patId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          docId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          expId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.consId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.consId) {
            this.$http({
              url: this.$http.adornUrl(`/cons/consultation/info/${this.dataForm.consId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.medicine = data.consultation.medicine
                this.dataForm.price = data.consultation.price
                this.dataForm.time = data.consultation.time
                this.dataForm.patId = data.consultation.patId
                this.dataForm.docId = data.consultation.docId
                this.dataForm.expId = data.consultation.expId
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
              url: this.$http.adornUrl(`/cons/consultation/${!this.dataForm.consId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'consId': this.dataForm.consId || undefined,
                'medicine': this.dataForm.medicine,
                'price': this.dataForm.price,
                'time': this.dataForm.time,
                'patId': this.dataForm.patId,
                'docId': this.dataForm.docId,
                'expId': this.dataForm.expId
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

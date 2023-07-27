<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/patient' }"
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>个人中心</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片部分 -->
    <el-card class="box-card">
      <!-- 头像 可上传头像-->
      <el-row class="demo-avatar demo-basic">
  <el-col :span="20">
    <div class="demo-basic--circle">
      <div class="block">
        <el-avatar :size="100" :src="avatarUrl">
          <i class="el-icon-user-solid"></i>
        </el-avatar>
      </div>
    </div>
  </el-col>
  <el-col :span="4" style="margin-top: 30px;">
    <div class="block">
      <input type="file" ref="fileInput" style="display: none" @change="handleFileChange">
      <el-button type="primary" @click="uploadAvatar">上传头像</el-button>
    </div>
  </el-col>
</el-row>



      <!-- 个人信息须填写内容 -->
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-row>
      <el-col :span="12">
        <el-form-item label="真实姓名:" prop="name">
          <el-input v-model="ruleForm.name" :disabled="isDisabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="性别:" prop="sex">
          <el-radio v-model="ruleForm.sex" label="男" :disabled="isDisabled">男</el-radio>
          <el-radio v-model="ruleForm.sex" label="女" :disabled="isDisabled">女</el-radio>
        </el-form-item>
      </el-col>
    </el-row>
    <el-form-item label="手机号:" prop="phonenumber">
      <el-input v-model="ruleForm.phonenumber" :disabled="isDisabled"></el-input>
    </el-form-item>
    <el-form-item label="邮箱:" prop="email">
      <el-input v-model="ruleForm.email" :disabled="isDisabled"></el-input>
    </el-form-item>
    <el-form-item label="身份证号:" prop="identityinfo">
      <el-input v-model="ruleForm.identityinfo" :disabled="isDisabled"></el-input>
    </el-form-item>
    <el-form-item label="地址:" prop="address">
      <el-input type="textarea" :rows="2" v-model="ruleForm.address" :disabled="isDisabled"></el-input>
    </el-form-item>

    <!-- 提交和重置按钮 -->
    <el-form-item v-if="isSubmit">
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>

    <!-- 更改信息按钮 -->
    <el-form-item v-else>
      <el-button type="primary" @click="changeInfo">更改信息</el-button>
    </el-form-item>
  </el-form>

    </el-card>

  </div>
</template>

<script>
import axios from "axios"
export default {
  data() {
      return {
        patientId: 1,
        ruleForm: {
          name: '',
          phonenumber:'',
          email:'',
          identityinfo:'',
          address:'',
          sex:'男',
          avatarUrl: '', // 头像URL或Base64数据
        },
        rules: {
          name: [
            { required: true, message: '请输入真实姓名', trigger: 'blur' },
            { min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur' }
          ],
          phonenumber: [
             { required: true, message: '请输入电话号码', trigger: 'blur' },
             { pattern: /^\d{11}$/, message: '请填入正确的手机号', trigger: 'blur' }
          ],
          email: [
             { required: true, message: '请输入邮箱', trigger: 'blur' },
             { pattern: /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/, message: '邮箱格式不正确', trigger: 'blur' }
          ],
          identityinfo: [
             { required: true, message: '请输入身份证号', trigger: 'blur' },
             { pattern: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, message: '身份证号码格式不正确', trigger: 'blur' }
          ],
          address: [
             { required: true, message: '请输入地址', trigger: 'blur' },
          ],
        },
        isDisabled: false, // 控制表单项禁用状态
      isSubmit: true // 控制是否显示提交和重置按钮
      };
    },
    methods: {
      // 个人信息按钮
      submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.isDisabled = true; // 提交后禁用表单项
          this.isSubmit = false; // 隐藏提交和重置按钮，显示更改信息按钮
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    changeInfo() {
      this.isDisabled = false; // 允许修改信息
      this.isSubmit = true; // 隐藏更改信息按钮，显示提交和重置按钮
    },
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios({
              url: 'http://localhost:8001/user/infoApp',
              method: 'post',
              params:{
                idNo: this.ruleForm.identityinfo,
                name: this.ruleForm.name
              }
            }).then(resp => {
              //console.log(resp.data.data)
              if((JSON.parse(resp.data.data)).respMessage==="身份证信息匹配"){
                this.$message({
                  message: '身份证信息匹配!',
                  type: 'success'
                });
                setTimeout(() => this.saveInfo(), 2000)
              }else{
                this.$message.error((JSON.parse(resp.data.data)).respMessage);
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },


    // 上传图片并实时更新
    uploadAvatar() {
      this.$refs.fileInput.click();
    },
    handleFileChange(event) {
      const file = event.target.files[0];
      const reader = new FileReader();

      reader.onload = (e) => {
        this.avatarUrl = e.target.result;
        localStorage.setItem('avatar', e.target.result);
        // 删除之前图片的内存
        const prevAvatar = localStorage.getItem('prevAvatar');
        if (prevAvatar !== null && prevAvatar !== this.avatarUrl) {
          URL.revokeObjectURL(prevAvatar); // 释放内存
        }
        localStorage.setItem('prevAvatar', this.avatarUrl);// 存储当前图片 URL，用于下次比对
        window.location.reload(); // 刷新页面
      };

      // 将文件读取为 Data URL
      reader.readAsDataURL(file);
    },
      saveInfo(){
          axios({
            url: 'http://localhost:8001/user/saveinfo',
            method: 'post',
            params:{
              realname:this.ruleForm.name,
              phonenumber:this.ruleForm.phonenumber,
              sex:this.ruleForm.sex,
              email:this.ruleForm.email,
              identityinfo:this.ruleForm.identityinfo,
              age:19,
              address:this.ruleForm.address,
              id: this.patientId
            }
          }).then(resp => {
            if(resp.data.code === 200){
              this.$message({
                message: '信息录入成功!',
                type: 'success'
              });
            }else{
              this.$message.error('发生错误!请稍后再试');
            }
            setTimeout(() => location.reload(), 3000)
          })
      }
  },
  created() {
    const savedAvatar = localStorage.getItem('avatar');
    if (savedAvatar) {
      this.avatarUrl = savedAvatar;
    }
    
    },

}
</script>

<style scoped>

</style>
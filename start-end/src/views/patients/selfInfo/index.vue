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
        <div class="avatar-container">
  <el-avatar :size="100" :src="avatarUrl">
    <i class="el-icon-user-solid"></i>
  </el-avatar>
  <div v-if="showGreetingInfo" class="greeting-info">
    <p>{{ greetingMessage }}</p>
  </div>
</div>
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
          <el-input v-model="ruleForm.realname" :disabled="isDisabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="性别:" prop="sex">
          <el-radio v-model="ruleForm.sex" label="男" :disabled="isDisabled">男</el-radio>
          <el-radio v-model="ruleForm.sex" label="女" :disabled="isDisabled">女</el-radio>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="手机号:" prop="phonenumber">
          <el-input v-model="ruleForm.phonenumber" :disabled="isDisabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="年龄" prop="age">
      <el-input v-model="ruleForm.age" :disabled="isDisabled"></el-input>
    </el-form-item>
      </el-col>
    </el-row>
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
          realname: '',
          phonenumber:'',
          email:'',
          identityinfo:'',
          address:'',
          sex:'男',
          age:'',
          avatarUrl: '', // 头像URL或Base64数据
        },
        rules: {
          realname: [
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
          age: [
             { required: true, message: '请输入年龄', trigger: 'blur' },
             { pattern: /^\d{1,3}$/, message: '年龄为一到三位数字', trigger: 'blur'},

          ],
        },
        isDisabled: false, // 控制表单项禁用状态
      isSubmit: true, // 控制是否显示提交和重置按钮
      showGreetingInfo: false, // 控制是否显示问候信息
      greetingMessage: '', // 存储问候信息
      };
    },
    methods: {
      // 个人信息按钮
      submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

       // 问候语句获取当前时间
      const currentTime = new Date();
      const currentHour = currentTime.getHours();

      let greeting;
      if (currentHour < 12) {
        greeting = '早上好';
      } else if (currentHour < 13) {
        greeting = '中午好';
      } else if (currentHour < 18) {
        greeting = '下午好';
      }else {
        greeting = '晚上好';
      } 
           // 问候信息
          this.showGreetingInfo = true; // 显示问候信息区域
          this.greetingMessage = `${greeting}，${this.ruleForm.realname}!`; // 设置问候信息
          this.isDisabled = true; // 提交后禁用表单项
          this.isSubmit = false; // 隐藏提交和重置按钮，显示更改信息按钮
          axios({
            url: 'http://localhost:8001/user/infoApp',
            method: 'post',
            params:{
              idNo: this.ruleForm.identityinfo,
              name: this.ruleForm.realname
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
              this.isDisabled = false;
              this.isSubmit = true;
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    changeInfo() {
      this.isDisabled = false; // 允许修改信息
      this.isSubmit = true; // 隐藏更改信息按钮，显示提交和重置按钮
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.submitForm('ruleForm')
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
      // axios({
      //   url: 'http://localhost:8001/user/transAvatar',
      //   method: 'post',
      //   params:{
      //     id:JSON.parse(sessionStorage.getItem("user")).id,
      //     url:this.avatarUrl
      //   }
      // }).then(resp => {
      //   if(resp.data.code === 200){
      //     this.$message({
      //       message: '头像上传成功!',
      //       type: 'success'
      //     });
      //   }else{
      //     this.$message.error('发生错误!请稍后再试');
      //   }
      // })
    },
      saveInfo(){
          axios({
            url: 'http://localhost:8001/user/saveinfo',
            method: 'post',
            params:{
              realname:this.ruleForm.realname,
              phonenumber:this.ruleForm.phonenumber,
              sex:this.ruleForm.sex,
              email:this.ruleForm.email,
              identityinfo:this.ruleForm.identityinfo,
              age:this.ruleForm.age,
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
            //setTimeout(() => location.reload(), 3000)
          })
      },
      
      // 进入页面的判断
      getData() {
        const username = JSON.parse(sessionStorage.getItem("user")).username
    // 发送ajax请求获取数据
        axios({
          url: 'http://localhost:8001/user/getinfo',
          method: 'GET',
          params:{
            username: username
          }
        }).then(resp => {
      //console.log(resp.data.data.identityinfo)
      if (resp.data.data.identityinfo !== '' && resp.data.data.identityinfo !== null && resp.data.data.identityinfo!== undefined) {
        // 如果获取到了数据
        this.ruleForm = { ...resp.data.data };
        // 问候语句获取当前时间
        const currentTime = new Date();
        const currentHour = currentTime.getHours();

        let greeting;
        if (currentHour < 12) {
          greeting = '早上好';
        } else if (currentHour < 13) {
          greeting = '中午好';
        } else if (currentHour < 18) {
          greeting = '下午好';
        }else {
          greeting = '晚上好';
        }
        // 问候信息
        this.showGreetingInfo = true; // 显示问候信息区域
        this.greetingMessage = `${greeting}，${this.ruleForm.realname}!`; // 设置问候信息
        this.isDisabled = true; // 禁用表单
        this.isSubmit = false; // 隐藏提交和重置按钮，显示修改按钮
      } else {
        // 如果获取的数据为空
        this.isDisabled = false; // 允许修改表单
        this.isSubmit = true; // 显示提交和重置按钮
      }
    }).catch(error => {
      console.log(error);
    });
  },
  },
  created() {
    const savedAvatar = localStorage.getItem('avatar');
    if (savedAvatar) {
      this.avatarUrl = savedAvatar;
    }
    
    // 在页面加载时调用获取数据的方法
    this.getData(); 
    },

    

}
</script>

<style scoped>
.avatar-container {
  display: flex;
  align-items: center;
}

.greeting-info {
  margin-top: 10px;
  margin-left: 20px;
}

</style>
<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/patient' }"
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>个人中心</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 个人信息内容 -->
    <el-card class="box-card">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="真实姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="phonenumber">
            <el-input v-model="ruleForm.phonenumber"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
          </el-form-item>
          <el-form-item label="身份证号" prop="identityinfo">
            <el-input v-model="ruleForm.identityinfo"></el-input>
          </el-form-item>

          <!-- 提交按钮 -->
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
    </el-card>

  </div>
</template>

<script>
export default {
  data() {
      return {
        ruleForm: {
          name: '',
          phonenumber:'',
          email:'',
          identityinfo:'',
        },
        rules: {
          name: [
            { required: true, message: '请输入活动名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          phonenumber: [
             { required: true, message: '请输入电话号码', trigger: 'blur' },
          ],
          email: [
             { required: true, message: '请输入邮箱', trigger: 'blur' },
          ],
          identityinfo: [
             { required: true, message: '请输入身份证号', trigger: 'blur' },
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
}
</script>

<style>

</style>
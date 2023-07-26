<template>
  <div class="bg-primary">
    <div id="layoutAuthentication">
      <div id="layoutAuthentication_content">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-5">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">登录</h3>
                </div>
                <div class="card-body">
                  <form>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="inputEmail"
                        type="email"
                        placeholder="name@example.com"
                        v-model="inputUserName"
                      />
                      <label for="inputEmail">请输入你的用户名...</label>
                    </div>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="inputPassword"
                        type="password"
                        placeholder="Password"
                        v-model="inputPassword"
                      />
                      <label for="inputPassword">请输入密码...</label>
                    </div>
                    <div class="form-check mb-3">
                      <input
                        class="form-check-input"
                        id="inputRememberPassword"
                        type="checkbox"
                        :value="isRememberPwd"
                      />
                      <label
                        class="form-check-label"
                        for="inputRememberPassword"
                        >记住密码</label
                      >
                    </div>
                    <div
                      class="d-flex align-items-center justify-content-between mt-4 mb-0"
                    >
                      <router-link class="small" to="/password"
                        >忘记密码?</router-link
                      >
                      <el-button class="btn btn-primary" @click="loginPatient"
                      >登录</el-button>
                      >
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center py-3">
                  <div class="small">
                    <router-link to="/register"
                      >新用户? 注册一个账号!</router-link
                    >
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
 
<script>

import axios from "axios";

export default {
  data(){
    return {
      inputUserName: "",
      inputPassword: "",
      isRememberPwd: false
    };
  },
  methods:{
    loginPatient(){
        if(this.inputUserName.trim() === ""){
          this.$message({
            message: '用户名不能为空!',
            type: 'warning'
          });
          return;
        }
        if(this.inputPassword.trim() === ""){
          this.$message({
            message: '密码不能为空!',
            type: 'warning'
          });
          return;
        }
        axios({
          url:'http://localhost:8001/login',
          method:'post',
          params:{
            username:this.inputUserName,
            password:this.inputPassword
          }
        }).then(resp => {
          if(resp.data.code == 200){
              // 将用户信息存储在sessionStorage中
              sessionStorage.setItem("user", JSON.stringify(resp.data.data));
            this.$router.push({
              path: '/patient',
              query: resp.data.data
            })
            //console.log(resp.data.data.patientInfoVo);
          }else{
            this.$message.error("登录失败!请检查用户名或密码是否正确")
          }
        })
    }
  }
};
</script>
 
<style scoped>
</style>

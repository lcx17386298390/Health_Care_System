<template>
  <div class="bg-primary">
    <div id="layoutAuthentication">
      <div id="layoutAuthentication_content">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-7">
              <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header">
                  <h3 class="text-center font-weight-light my-4">
                    创建一个账号
                  </h3>
                </div>
                <div class="card-body">
                  <form>
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputFirstName"
                            type="text"
                            placeholder="Enter your first name"
                            v-model="inputUserName"
                          />
                          <label for="inputFirstName">请输入您的账号...</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating">
                          <input
                            class="form-control"
                            id="inputLastName"
                            type="text"
                            placeholder="Enter your last name"
                            v-model="inputRealName"
                          />
                          <label for="inputLastName">请输入您的姓名...</label>
                        </div>
                      </div>
                    </div>
                    <div class="form-floating mb-3">
                      <input
                        class="form-control"
                        id="inputEmail"
                        type="email"
                        placeholder="name@example.com"
                        v-model="inputEmail"
                      />
                      <label for="inputEmail">请输入您的邮箱进行验证...</label>
                    </div>
                    <div class="row mb-3">
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputPassword"
                            type="password"
                            placeholder="Create a password"
                            v-model="inputPassword"
                          />
                          <label for="inputPassword">请输入您的密码...</label>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-floating mb-3 mb-md-0">
                          <input
                            class="form-control"
                            id="inputPasswordConfirm"
                            type="password"
                            placeholder="Confirm password"
                            v-model="repeatPassword"
                          />
                          <label for="inputPasswordConfirm"
                            >再次确认密码...</label
                          >
                        </div>
                      </div>
                    </div>
                    <div class="mt-4 mb-0">
                      <div class="d-grid">
                        <el-button
                          class="btn btn-primary btn-block"
                          @click="registerForPatient"
                          >注册账号</el-button
                        >
                                <!-- /login-->
                      </div>
                    </div>
                  </form>
                </div>
                <div class="card-footer text-center py-3">
                  <div class="small">
                    <router-link to="/login"
                      >已经有一个账号了? 去登陆</router-link
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
      repeatPassword: "",
      inputPassword: "",
      inputEmail: "",
      inputRealName: "",
      inputUserName: ""
    }
  },
  methods:{
    registerForPatient(){
          if(this.inputUserName === ""){
            this.$message({
              message: '用户名不能为空!',
              type: 'warning'
            });
            return;
          }
          if(this.inputRealName === ""){
            this.$message({
              message: '姓名不能为空!',
              type: 'warning'
            });
            return;
          }
          if(this.inputEmail === ""){
            this.$message({
              message: '邮箱不能为空!',
              type: 'warning'
            });
            return;
          }
          if(this.inputPassword === ""){
            this.$message({
              message: '密码不能为空!',
              type: 'warning'
            });
            return;
          }
          if(this.repeatPassword === ""){
            this.$message({
              message: '请重复输入密码!',
              type: 'warning'
            });
            return;
          }
          if(this.repeatPassword !== this.inputPassword){
            this.$message({
              message: '第二次输入密码与第一次不相同!',
              type: 'warning'
            });
            return;
          }
          axios({
            url: 'http://localhost:8001/user/register',
            method: 'post',
            params:{
              email: this.inputEmail,
              username: this.inputUserName,
              realname:this.inputRealName,
              password:this.inputPassword
            }
          }).then(resp => {
            if(resp.data.code == 200){
              this.$router.push({
                path: '/login',
                query: resp.data.data
              })
            }else{
              this.$message.error("注册失败!用户名已经存在")
            }
          })
    }
  }
};
</script>

<style scoped>
</style>
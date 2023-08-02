<template>
  <div class="container-fluid px-4">
    <h1 class="mt-2">个人中心</h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <router-link to="/doc/docSelf">个人信息</router-link>
      </li>
      <li class="breadcrumb-item active">信息修改</li>
    </ol>
    <div class="personal-info-container mt-4">
      <div class="card">
        <div class="card-header">个人信息</div>
        <div class="card-body">
          <div class="mb-3">
            <label for="username" class="form-label">用户名</label>
            <input
              type="text"
              class="form-control"
              id="username"
              :value="userData.username"
              disabled
            />
          </div>
          <div class="mb-3">
            <label for="realname" class="form-label">真实姓名</label>
            <input
              type="text"
              class="form-control"
              id="realname"
              :value="userData.realname"
              disabled
            />
          </div>
          <div class="mb-3">
            <label for="gender" class="form-label">性别</label>
            <input
              type="text"
              class="form-control"
              id="gender"
              :value="userData.gender"
              disabled
            />
          </div>
          <div class="mb-3">
            <label for="department" class="form-label">所属科室</label>
            <input
              type="text"
              class="form-control"
              id="department"
              :value="userData.department"
              disabled
            />
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">邮箱</label>
            <input
              type="email"
              class="form-control"
              id="email"
              :value="userData.email"
              disabled
            />
          </div>
            <div class="mb-3">
                <label for="phonenumber" class="form-label">电话号码</label>
                <input
                        type="phonenumber"
                        class="form-control"
                        id="phonenumber"
                        :value="userData.phonenumber"
                        disabled
                />
          </div>
        </div>
      </div>

      <!-- Password modification form -->
      <div class="card mt-4">
        <div class="card-header">密码修改</div>
        <div class="card-body">
          <form @submit.prevent="submitPasswordForm">
            <div class="mb-3">
              <label for="currentPassword" class="form-label">当前密码</label>
              <div class="input-group">
                <input
                  :type="showCurrentPassword ? 'text' : 'password'"
                  v-model="currentPassword"
                  class="form-control"
                  id="currentPassword"
                  required
                />
                <button
                  @click="showCurrentPassword = !showCurrentPassword"
                  class="btn btn-outline-secondary"
                  type="button"
                >
                  <i
                    :class="
                      showCurrentPassword ? 'fa fa-eye-slash' : 'fa fa-eye'
                    "
                  ></i>
                </button>
              </div>
            </div>
            <div class="mb-3">
              <label for="newPassword" class="form-label">新密码</label>
              <div class="input-group">
                <input
                  :type="showNewPassword ? 'text' : 'password'"
                  v-model="newPassword"
                  class="form-control"
                  id="newPassword"
                  required
                />
                <button
                  @click="showNewPassword = !showNewPassword"
                  class="btn btn-outline-secondary"
                  type="button"
                >
                  <i
                    :class="showNewPassword ? 'fa fa-eye-slash' : 'fa fa-eye'"
                  ></i>
                </button>
              </div>
            </div>
            <div class="mb-3">
              <label for="confirmPassword" class="form-label">确认新密码</label>
              <div class="input-group">
                <input
                  :type="showConfirmPassword ? 'text' : 'password'"
                  v-model="confirmPassword"
                  class="form-control"
                  id="confirmPassword"
                  required
                  @input="validatePassword"
                />
                <button
                  @click="showConfirmPassword = !showConfirmPassword"
                  class="btn btn-outline-secondary"
                  type="button"
                >
                  <i
                    :class="
                      showConfirmPassword ? 'fa fa-eye-slash' : 'fa fa-eye'
                    "
                  ></i>
                </button>
              </div>
              <div v-if="passwordMismatch" class="text-danger">
                新密码和确认密码不一致
              </div>
              <label for="confirmPassword" class="form-label">输入验证码</label>
              <el-input v-model="inputText"></el-input><img :src="httpimage" @click="getImage"></img>
            </div>
            <button type="submit" class="btn btn-primary">确认修改</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import axios from "axios"
export default {
  data() {
    return {
      userData: {
        username: "",
        realname: "",
        gender: "",
        department: "",
        email: "",
          phonenumber:"",
      },
      inputText:"",
      currentPassword: "",
      newPassword: "",
      confirmPassword: "",
      passwordMismatch: false,
      showCurrentPassword: false,
      showNewPassword: false,
      showConfirmPassword: false,
      doctorId:"1",
      httpimage:"",
      httptext:""
    };
  },
   created() {
     this.docInfo()
    this.setrealname("dname1");
     this.getImage()
  },
  methods: {
    ...mapMutations(["setrealname"]),
    async submitPasswordForm() {
      if (this.newPassword !== this.confirmPassword) {
        this.passwordMismatch = true;
        return;
      } else {
        this.passwordMismatch = false;
      }
      if(this.inputText !== this.httptext){
        this.$notify({
          title: "错误",
          message: "输入验证码错误",
          type: "error",
        });
        return;
      }

      const request = {
        currentPassword: this.currentPassword,
        newPassword: this.newPassword,
        doctorId:this.doctorId
      };

      try {
        //  API
        //console.log(request.currentPassword)
        const response = await axios({
          url:'http://localhost:8003/doctor/changepassword',
          method:'post',
          params:{
            currentPassword: request.currentPassword,
            newPassword: request.newPassword,
            doctorId:request.doctorId
          }
        })
        //console.log(response.data.code)
        if (response.data.code === 200) {
          this.$notify({
            title: "成功",
            message: "密码修改成功",
            type: "success",
          });
          window.location.reload();
        } else {
          // Password change failed
          this.$notify({
            title: "错误",
            message: "输入的原密码错误",
            type: "error",
          });
        }
      } catch (error) {
        this.$notify({
          title: "错误",
          message: "输入的原密码错误",
          type: "error",
        });
      }
    },
    validatePassword() {
      this.passwordMismatch = this.newPassword !== this.confirmPassword;
    },
    docInfo(){
      axios({
        url:'http://localhost:8003/doctor/getDoctorId',
        method: 'post',
        params:{
          doctorId:this.doctorId
        }
      }).then(resp => {
        if(resp){
          this.userData = resp.data.data
        }
      })
    },
    getImage(){
      axios({
        url: 'https://www.mxnzp.com/api/verifycode/code',
        method:'get',
        params:{
          app_id:"cpnlmkgjticxfzop",
          app_secret: "QbRMPR4d5zr4Rzv0Tr5r1zkNVD8b3eoi"
      }
      }).then(resp => {

        this.httpimage = resp.data.data.verifyCodeImgUrl
        this.httptext=resp.data.data.verifyCode
        //console.log(this.httptext)
      })
    }
  },
};
</script>

<style>
.personal-info-container {
  max-height: 666px;
  overflow-y: auto;
}
</style>

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
export default {
  data() {
    return {
      userData: {
        username: "isdusername",
        realname: "dname1",
        gender: "女",
        department: "神经科",
        email: "1441307999@qq.com",
          phonenumber:"11111122222",
      },
      currentPassword: "",
      newPassword: "",
      confirmPassword: "",
      passwordMismatch: false,
      showCurrentPassword: false,
      showNewPassword: false,
      showConfirmPassword: false,
    };
  },
   created() {
    this.setrealname("dname1"); 
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

      const request = {
        currentPassword: this.currentPassword,
        newPassword: this.newPassword,
      };

      try {
        //  API
        const response = await axios.post("/api/change-password", request);

        if (response.status === 200) {
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
            message: "密码修改失败，请稍后重试",
            type: "error",
          });
        }
      } catch (error) {
        this.$notify({
          title: "错误",
          message: "发生了一个错误，请稍后重试",
          type: "error",
        });
      }
    },
    validatePassword() {
      this.passwordMismatch = this.newPassword !== this.confirmPassword;
    },
  },
};
</script>

<style>
.personal-info-container {
  max-height: 666px;
  overflow-y: auto;
}
</style>

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
            <label for="identityinfo" class="form-label">身份证号</label>
            <input
              type="text"
              class="form-control"
              id="identityinfo"
              :value="userData.identityinfo"
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
        </div>
      </div>

      <!-- Password modification form -->
      <div class="card mt-4">
        <div class="card-header">密码修改</div>
        <div class="card-body">
          <div class="mb-3">
            <label for="currentPassword" class="form-label">当前密码</label>
            <input
              type="password"
              class="form-control"
              id="currentPassword"
              v-model="currentPassword"
            />
          </div>
          <div class="mb-3">
            <label for="newPassword" class="form-label">新密码</label>
            <input
              type="password"
              class="form-control"
              id="newPassword"
              v-model="newPassword"
            />
          </div>
          <div class="mb-3">
            <label for="confirmPassword" class="form-label">确认新密码</label>
            <input
              type="password"
              class="form-control"
              id="confirmPassword"
              v-model="confirmPassword"
            />
          </div>
          <button type="button" class="btn btn-primary" @click="submitPassword">
            提交
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userData: {
        username: "doctor_username",
        realname: "Doctor Realname",
        gender: "Male",
        identityinfo: "1234567890",
        email: "doctor@example.com",
      },
      currentPassword: "",
      newPassword: "",
      confirmPassword: "",
    };
  },
  methods: {
    submitPassword() {
      // You can add password validation logic here
      // For example, checking if the current password is correct
      // and if the new password matches the confirm password
      // Then, you can make an API call to update the password
      // using the this.newPassword value
    },
  },
};
</script>

<style>
.personal-info-container {
  max-height: 666px; /* Set the maximum height for the container */
  overflow-y: auto; /* Enable vertical scrolling if content exceeds the height */
}
</style>

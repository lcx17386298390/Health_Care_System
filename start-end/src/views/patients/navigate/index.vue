<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item
        >手续导航</el-breadcrumb-item
      >
      <el-breadcrumb-item>主页</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="nav-container">
      <div class="card-container">
        <el-card>
          <div slot="header" class="clearfix">
            <span class="large-text">ACM医护中心欢迎您</span>
          </div>
          <div class="text item">
            <p class="large-text2">
              请在侧边栏依次执行挂号、等待处方单并结算药品的操作。
            </p>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  created() {
    // Check if the modal has been shown before
    const modalShown = localStorage.getItem("modalShown");
    if (!modalShown) {
      setTimeout(() => {
        this.$confirm("Are you sure you want to proceed?", "Confirmation", {
          confirmButtonText: "OK",
          showCancelButton: false,
          showClose: false,
          type: "warning",
          beforeClose: (action, instance, done) => {
            if (action === "confirm") {
              this.$router.push("/patient/self");
            }
            done();
          },
        });
        localStorage.setItem("modalShown", "true");
      }, 1000);
    }
  },
};
</script>

<style>
.nav-container {
  margin-top: 3%;
  background-image: url("../../../assets/img.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  height: 75vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.card-container {
  max-width: 666px;
}

.image {
  display: none;
}

el-card {
  background-color: rgba(195, 187, 187, 0.9);
  border-radius: 12px;
}

.large-text {
  font-size: 32px;
}
.large-text2 {
  font-size: 29px;
}
</style>


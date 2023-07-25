<template>
  <div>
    <header class="p-3 text-bg-dark fixed-top">
      <div class="home_container">
        <div class="d-flex align-items-center justify-content-between">
          <router-link class="navbar-brand fs-4" to="/"
            >HGNUACM医疗健康系统</router-link
          >
          <ul
            class="nav col-12 col-lg-auto mb-2 justify-content-center mb-md-0"
          >
            <li>
              <router-link to="/home" class="nav-link px-2 mx-4 text-secondary"
                >首页</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
          </ul>
          <div class="text-end">
            <router-link to="/#" class="btn btn-outline-light me-4"
              >联系我们</router-link
            >
            <router-link to="/login" class="btn btn-warning">登录</router-link>
          </div>
        </div>
      </div>
    </header>
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="item in 4" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {
  },
};
</script>

<style scoped>
/* .el-carousel{
  padding-top: 20%;
  height: 500px;
} */
body{
  padding-right: 0;
}
.el-carousel__item h3 {
  color: #727f90;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #484d53;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #666b70;
}
@media (min-width: 992px) {
  .navbar-expand-lg {
    flex-wrap: nowrap;
    justify-content: flex-start;
  }
  .navbar-expand-lg .navbar-nav {
    flex-direction: row;
  }
  .navbar-expand-lg .navbar-nav .dropdown-menu {
    position: absolute;
  }
  .navbar-expand-lg .navbar-nav .nav-link {
    padding-right: var(--bs-navbar-nav-link-padding-x);
    padding-left: var(--bs-navbar-nav-link-padding-x);
  }
  .navbar-expand-lg .navbar-nav-scroll {
    overflow: visible;
  }
  .navbar-expand-lg .navbar-collapse {
    display: flex !important;
    flex-basis: auto;
  }
}
</style>
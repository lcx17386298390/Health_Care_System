<template>
  <div
    class="sidebar d-flex flex-column flex-shrink-0 p-3 text-bg-dark aaa">
    <router-link
      to="/patient"
      class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"
    >
      <svg class="bi pe-none me-2" width="40" height="32">
        <use xlink:to="/patient"></use>
      </svg>
      <span class="fs-4">Sidebar</span>
    </router-link>
    <hr />
    <!-- 侧边导航由此开始 -->
    <ul class="nav nav-pills flex-column mb-auto flex-column" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <li class="nav-item">
        <router-link to="/regisProcess" class="nav-link active" aria-current="page" id="v-pills-home-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-home" aria-selected="true">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="/regisProcess"></use>
          </svg>
          Home
        </router-link>
      </li>
      <li>
        <router-link to="/#" class="nav-link text-white"  id="v-pills-Dashboard-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-profile" aria-selected="false">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#speedometer2"></use>
          </svg>
          Dashboard
        </router-link>
      </li>
      <li>
        <router-link to="/#" class="nav-link text-white"  id="v-pills-Orders-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="/#table"></use>
          </svg>
          Orders
        </router-link>
      </li>
      <li>
        <router-link to="/#" class="nav-link text-white"  id="v-pills-Products-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#grid"></use>
          </svg>
          Products
        </router-link>
      </li>
      <li>
        <router-link to="/#" class="nav-link text-white"  id="v-pills-Customers-tab" data-toggle="pill" role="tab" aria-controls="v-pills-messages" aria-selected="false">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          Customers
        </router-link>
      </li>
      <li>
        <router-link to="/patient/buydrug" class="nav-link text-white"  id="v-pills-maiyao-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          买药
        </router-link>
      </li>
    </ul>
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active blue" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">...</div>
      <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-Dashboard-tab">...</div>
      <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-Orders-tab">...</div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-Products-tab">...</div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-Customers-tab">...</div>
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-maiyao-tab">...</div>
    </div>

    <hr />
    <div class="dropdown">
      <router-link
        to="/#"
        class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        <img
          src="https://github.com/mdo.png"
          alt=""
          width="32"
          height="32"
          class="rounded-circle me-2"
        />
        <strong>mdo</strong>
      </router-link>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li><router-link class="dropdown-item" to="/theam">切换主题</router-link></li>
        <li><router-link class="dropdown-item" to="/settings">设置</router-link></li>
        <li><router-link class="dropdown-item" to="/self">个人中心</router-link></li>
        <li><hr class="dropdown-divider" /></li>
        <li><router-link class="dropdown-item" to="/login">退出登录</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
   .aaa{
  height: 100vh;
  width: 16.15vw;
}
</style>
<template>
  <div class="sidebar d-flex flex-column flex-shrink-0 p-3 text-bg-dark aaa">
    <router-link
      to="/doc"
      class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"
    >
      <svg class="bi pe-none me-2" width="40" height="32">
        <use xlink:to="#doc"></use>
      </svg>
      <span class="fs-4">导航</span>
    </router-link>
    <hr />
    <!-- 侧边导航由此开始 -->
    <ul
      class="nav nav-pills flex-column mb-auto flex-column"
      id="v-pills-tab"
      role="tablist"
      aria-orientation="vertical"
    >
      <li>
        <router-link
          to="/doc"
          class="nav-link text-white"
          id="v-pills-Orders-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/history' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="/#table"></use>
          </svg>
          预约订单查询
        </router-link>
      </li>

      <li>
        <router-link
          to="/doc"
          class="nav-link text-white"
          id="v-pills-Orders-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/history' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="/#table"></use>
          </svg>
          诊断开方
        </router-link>
      </li>
      
      <li>
        <router-link
          to="/doc"
          class="nav-link text-white"
          id="v-pills-Customers-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/self' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          个人中心
        </router-link>
      </li>
    </ul>

    <div class="tab-content" id="v-pills-tabContent">
      <!-- 历史病例 -->
      <div
        class="tab-pane fade"
        id="v-pills-messages"
        role="tabpanel"
        aria-labelledby="v-pills-Orders-tab"
        :class="{ active: $route.path === '/doc' }"
      >
        ...
      </div>
  
      <!-- self -->
      <div
        class="tab-pane fade"
        id="v-pills-settings"
        role="tabpanel"
        aria-labelledby="v-pills-Customers-tab"
        :class="{ active: $route.path === '/doc' }"
      >
        ...
      </div>
    </div>

    <hr />
    <div class="dropdown">
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li>
          <router-link class="dropdown-item" to="/theam">切换主题</router-link>
        </li>
        <li><hr class="dropdown-divider" /></li>
        <li>
          <router-link class="dropdown-item" to="/login">退出登录</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.aaa {
  height: 100vh;
  width: 16.15vw;
}
</style>
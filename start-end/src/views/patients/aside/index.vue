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
      <span class="fs-4">手续导航</span>
    </router-link>
    <hr />
    <!-- 侧边导航由此开始 -->
    <ul class="nav nav-pills flex-column mb-auto flex-column" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <li class="nav-item">
        <router-link to="/patient/regis" class="nav-link text-white" aria-current="page" id="v-pills-home-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-home" aria-selected="true" :class="{ active: $route.path === '/patient/regis' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#regisProcess"></use>
          </svg>
          排队挂号
        </router-link>
      </li>
      <li>
        <router-link to="/patient/prescription" class="nav-link text-white"  id="v-pills-Dashboard-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-profile" aria-selected="false" :class="{ active: $route.path === '/patient/prescription' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#speedometer2"></use>
          </svg>
          处方单
        </router-link>
      </li>
      <li>
        <router-link to="/patient/history" class="nav-link text-white"  id="v-pills-Orders-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false" :class="{ active: $route.path === '/patient/history' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="/#table"></use>
          </svg>
          历史病例
        </router-link>
      </li>
      <li>
        <router-link to="/patient/booking" class="nav-link text-white"  id="v-pills-Products-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false" :class="{ active: $route.path === '/patient/booking' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#grid"></use>
          </svg>
          预约挂号
        </router-link>
      </li>
      <li>
        <router-link to="/patient/buydrug" class="nav-link text-white"  id="v-pills-maiyao-tab" data-toggle="pill"  role="tab" aria-controls="v-pills-messages" aria-selected="false" :class="{ active: $route.path === '/patient/buydrug' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          买药
        </router-link>
      </li>
      <li>
        <router-link to="/patient" class="nav-link text-white"  id="v-pills-Customers-tab" data-toggle="pill" role="tab" aria-controls="v-pills-messages" aria-selected="false"  :class="{ active: $route.path === '/patient' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          Customers
        </router-link>
      </li>
    </ul>
    <!-- 排队挂号 -->
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"  :class="{ 'show active': $route.path === '/patient/regis' }">...</div>
      <!-- 处方单 -->
      <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-Dashboard-tab" :class="{ 'show active': $route.path === '/patient/prescription' }">...</div>
      <!-- 历史病例 -->
      <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-Orders-tab" :class="{ active: $route.path === '/patient/history' }">...</div>
      <!-- 预约挂号 -->
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-Products-tab" :class="{ active: $route.path === '/patient/booking' }">...</div>
      <!-- 买药 -->
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-Customers-tab" :class="{ active: $route.path === '/patient/buydrug' }">...</div>
      <!-- 顾客 -->
      <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-Customers-tab"  :class="{ active: $route.path === '/patient' }">...</div>
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
<template>
  <div
    class="sidebar d-flex flex-column flex-shrink-0 p-3 aaa"
    :class="{
      'dark-theme': isDarkTheme,
      'light-theme': !isDarkTheme,
      'a-white': isDarkTheme,
      'a-black': !isDarkTheme,
    }"
  >
    <router-link
      to="/patient/nav"
      class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-decoration-none"
    >
      <svg class="bi pe-none me-2" width="40" height="32">
        <use xlink:to="#patient"></use>
      </svg>
      <span class="fs-4">手续导航</span>
    </router-link>
    <hr />
    <!-- 侧边导航由此开始 -->
    <ul
      class="nav nav-pills flex-column mb-auto flex-column"
      id="v-pills-tab"
      role="tablist"
      aria-orientation="vertical"
    >
      <li class="nav-item">
        <router-link
          to="/patient/regis"
          class="nav-link text"
          aria-current="page"
          id="v-pills-regis-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="true"
          :class="{ active: $route.path === '/patient/regis' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#regisProcess"></use>
          </svg>
          预约挂号
        </router-link>
      </li>
      <li class="nav-item">
        <router-link
          to="/patient/consultation"
          class="nav-link text"
          aria-current="page"
          id="v-pills-regis-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="true"
          :class="{ active: $route.path === '/patient/consultation' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#consultation"></use>
          </svg>
          在线咨询
        </router-link>
      </li>
      <li>
        <router-link
          to="/patient/prescription"
          class="nav-link text"
          id="v-pills-prescrition-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/prescription' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#speedometer2"></use>
          </svg>
          处方单
        </router-link>
      </li>
      <li>
        <router-link
          to="/patient/history"
          class="nav-link text"
          id="v-pills-history-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/history' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#table"></use>
          </svg>
          历史病例
        </router-link>
      </li>

      <li>
        <router-link
          to="/patient/buydrug"
          class="nav-link text"
          id="v-pills-maiyao-tab"
          data-toggle="pill"
          role="tab"
          aria-controls="v-pills-messages"
          aria-selected="false"
          :class="{ active: $route.path === '/patient/buydrug' }"
        >
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#people-circle"></use>
          </svg>
          买药
        </router-link>
      </li>
      <li>
        <router-link
          to="/patient/self"
          class="nav-link text"
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
    <hr />
    <div class="dropdown">
      <router-link
        to="/#"
        class="d-flex align-items-center text text-decoration-none dropdown-toggle"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        <strong>设置</strong>
      </router-link>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
        <li>
          <button class="dropdown-item" @click="toggleTheme">切换主题</button>
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
  data() {
    return {
      isDarkTheme: false,
    };
  },
  methods: {
    toggleTheme() {
      this.isDarkTheme = !this.isDarkTheme;
    },
  },
};
</script>

<style scoped>
.aaa {
  height: 100vh;
  width: 16.15vw;
}
.nav-link:not(.active):hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.nav-link.active:hover {
  background-color: var(--bs-nav-pills-link-active-bg);
}

.light-theme {
  background-color: #eff0f0;
}
.dark-theme {
  background-color: #262525;
}

.dark-theme .sidebar .a-white {
  color: #ffffff; /* White text for dark theme links */
}

/* Set link text color for light theme */
.light-theme .sidebar .a-black {
  color: #000000; /* Black text for light theme links */
}
</style>
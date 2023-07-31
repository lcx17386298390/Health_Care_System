<template>
  <div class="sidebar d-flex flex-column flex-shrink-0 p-3 aaa" :class="{
    'dark-theme': isDarkTheme,
    'light-theme': !isDarkTheme,
    'a-white': isDarkTheme,
    'a-black': !isDarkTheme,
  }">
    <router-link to="/doc/order" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-decoration-none">
      <svg class="bi pe-none me-2" width="40" height="32">
        <use xlink:to="#doc"></use>
      </svg>
      <span class="fs-4">预约订单</span>
    </router-link>
    <hr />
    <!-- 侧边导航由此开始 -->
    <ul class="nav nav-pills flex-column mb-auto flex-column" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <li class="nav-item">
        <router-link to="/doc/drug0" class="nav-link text" aria-current="page" id="v-pills-drug-tab" data-toggle="pill"
          role="tab" aria-controls="v-pills-messages" aria-selected="true"
          :class="{ active: $route.path === '/doc/drug0' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#drug"></use>
          </svg>
          开处方
        </router-link>
      </li>
      <li>
        <router-link to="/doc/his" class="nav-link text" id="v-pills-history-tab" data-toggle="pill" role="tab"
          aria-controls="v-pills-messages" aria-selected="false" :class="{ active: $route.path === '/doc/his' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#table"></use>
          </svg>
          诊断记录
        </router-link>
      </li>
      <li>
        <router-link to="/doc/docSelf" class="nav-link text" id="v-pills-docSelf-tab" data-toggle="pill" role="tab"
          aria-controls="v-pills-messages" aria-selected="false" :class="{ active: $route.path === '/doc/docSelf' }">
          <svg class="bi pe-none me-2" width="16" height="16">
            <use xlink:to="#table"></use>
          </svg>
          个人信息
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data () {
    return {
      isDarkTheme: false,
    }
  },
  methods: {
    toggleTheme () {
      this.isDarkTheme = !this.isDarkTheme
    },
  },
}
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
  color: #ffffff;
  /* White text for dark theme links */
}

/* Set link text color for light theme */
.light-theme .sidebar .a-black {
  color: #000000;
  /* Black text for light theme links */
}
</style>
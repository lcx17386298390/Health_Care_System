<template>
  <nav class="navbar navbar-dark fixd-top bg-dark">
    <div class="container">
      <router-link class="navbar-brand fs-3 me-4" to="/patient"
        >ACM医护中心</router-link
      >
      <div class="d-flex align-items-center flex-grow-1 justify-content-center">
        <form class="d-flex mt-6 me-5" role="search">
          <!-- 自定义搜索框样式 -->
          <div class="input-group">
            <input
              class="form-control"
              type="search"
              placeholder="输入搜索事项..."
              aria-label="Search"
            />
            <button class="btn btn-success" type="submit">Search</button>
          </div>
        </form>
      </div>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="offcanvas"
        data-bs-target="#offcanvasDarkNavbar"
        aria-controls="offcanvasDarkNavbar"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div
        class="offcanvas offcanvas-end text-bg-dark"
        tabindex="-1"
        id="offcanvasDarkNavbar"
        aria-labelledby="offcanvasDarkNavbarLabel"
      >
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">导航</h5>
          <button
            type="button"
            class="btn-close btn-close-white"
            data-bs-dismiss="offcanvas"
            aria-label="Close"
          ></button>
        </div>
        <div class="offcanvas-body">
          <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item">
              <router-link class="nav-link active" aria-current="page" to="/#"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/#">Link</router-link>
            </li>
            <li class="nav-item dropdown">
              <router-link
                class="nav-link dropdown-toggle"
                to="/#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown
              </router-link>
              <ul class="dropdown-menu dropdown-menu-dark">
                <li>
                  <router-link class="dropdown-item" to="/#"
                    >Action</router-link
                  >
                </li>
                <li>
                  <router-link class="dropdown-item" to="/#"
                    >Another action</router-link
                  >
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="/#"
                    >Something else here</router-link
                  >
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {};
</script>

<style scoped>
.input-group{
  width: 690px;
}
</style>
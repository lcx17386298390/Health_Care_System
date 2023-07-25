<template>
  <nav class="navbar navbar-dark fixed-top bg-dark">
    <div class="container">
      <!-- Logo and Brand -->
      <router-link class="navbar-brand fs-3 me-4" to="/patient"
        >ACM医护中心</router-link
      >

      <!-- Search Form -->
      <form class="d-flex mt-6 me-5 flex-grow-1">
        <input
          class="form-control me-4 flex-grow-2 w-100"
          type="search"
          placeholder="输入搜索事项..."
          aria-label="Search"
        />
        <button class="btn btn-success" type="submit">Search</button>
      </form>

      <!-- Navbar Toggler for Offcanvas -->
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

      <!-- Offcanvas -->
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
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link class="nav-link active" aria-current="page" to="/"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="#">Link</router-link>
            </li>
            <li class="nav-item dropdown">
              <router-link
                class="nav-link dropdown-toggle"
                to="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown
              </router-link>
              <ul class="dropdown-menu dropdown-menu-dark">
                <li>
                  <router-link class="dropdown-item" to="#">Action</router-link>
                </li>
                <li>
                  <router-link class="dropdown-item" to="#"
                    >Another action</router-link
                  >
                </li>
                <li>
                  <hr class="dropdown-divider" />
                </li>
                <li>
                  <router-link class="dropdown-item" to="#"
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
</style>
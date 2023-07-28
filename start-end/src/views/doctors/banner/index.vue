<template>
  <nav class="navbar navbar-dark fixd-top bg-dark">
    <div class="container">
      <span class="navbar-brand fs-3 me-4">ACM医生平台</span>
      <div class="d-flex align-items-center flex-grow-1 justify-content-center">
        <search></search>
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
          <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">设置</h5>
          <button
            type="button"
            class="btn-close btn-close-white"
            data-bs-dismiss="offcanvas"
            aria-label="Close"
          ></button>
        </div>
        <div class="offcanvas-body"></div>
      </div>
    </div>
  </nav>
</template>

<script>
import search from '../../../components/search/index.vue'
export default {
name: "ban",
  components: {
    search,
  },

};
</script>

<style scoped>
.input-group {
  width: 690px;
}
</style>
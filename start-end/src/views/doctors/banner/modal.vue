<template>
  <div>
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
      <div class="offcanvas-body">
        <div class="d-flex flex-column align-items-center">
          <i class="fas fa-user-circle fa-5x mb-2"></i>
          <ul class="list-group text-start">
            <li class="list-group-item">用户名：{{ userData.username }}</li>
            <li class="list-group-item">姓名：{{ userData.realname }}</li>
            <li class="list-group-item">科室：{{ userData.department }}</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userData: null,
    };
  },
  computed: {
    username() {   
      return "username";
    },
  },
  methods: {
    fetchUserData() {                            //apiapiapi   
      const apiEndpoint = `http://example.com/api/xxxx/${this.username}`;
      axios
        .get(apiEndpoint)
        .then((response) => {
          this.userData = response.data;
        })
        .catch((error) => {
          console.error("Failed to fetch user data:", error);
        });
    },
  },
  mounted() {
    this.fetchUserData();
  },
};
</script>

<style>
</style>

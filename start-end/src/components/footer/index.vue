<template>
  <div class="foot_container">
    <footer class="mt-auto py-3 my-4">
      <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item">
          <router-link to="#" class="nav-link px-2 text-body-secondary"
            >Home</router-link
          >
        </li>
        <li class="nav-item">
          <router-link to="#" class="nav-link px-2 text-body-secondary"
            >Features</router-link
          >
        </li>
        <li class="nav-item">
          <router-link to="#" class="nav-link px-2 text-body-secondary"
            >Pricing</router-link
          >
        </li>
        <li class="nav-item">
          <router-link to="#" class="nav-link px-2 text-body-secondary"
            >FAQs</router-link
          >
        </li>
        <li class="nav-item">
          <router-link to="#" class="nav-link px-2 text-body-secondary"
            >About</router-link
          >
        </li>
      </ul>
      <p class="text-center text-body-secondary">© 2023 Company, Inc</p>
    </footer>
  </div>
</template>

<script>
export default {};
</script>

<style>
.foot_container {
  min-height: calc(100vh-20vh);
  height: 20vh; /* You can adjust this value between 80vh and 100vh */
}
</style>
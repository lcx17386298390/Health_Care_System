<template>
  <nav class="navbar navbar-dark fixd-top bg-dark">
    <div class="container">
      <span class="navbar-brand fs-3 me-4">ACM医生平台</span>
      <div class="d-flex align-items-center flex-grow-1 justify-content-center">
        <search></search>
      </div>
      <modal></modal>
    </div>
  </nav>
</template>

<script>
import search from "../../../components/search/index.vue";
import modal from "../banner/modal.vue";
export default {
  name: "ban",
  components: {
    search,
    modal,
  },
};
</script>

<style scoped>
.input-group {
  width: 690px;
}
</style>
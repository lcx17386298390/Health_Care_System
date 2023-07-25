<template>
  <div>
    <banner />
    <div class="d-flex">
      <sider />
      <!-- content -->
      <div class="flex-grow-1">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import banner from "./banner/index.vue";
import sider from "./aside/index.vue";
import buyDrug from "./buyDrug/index.vue";
export default {
  name: "patient",
  components: {
    sider,
    banner,
    buyDrug,
  },
};
</script>

<style>
</style>
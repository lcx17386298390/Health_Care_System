<template>
  <div id="app">
    <banner></banner>
    <sider></sider>
  </div>
</template>

<script>
import banner from './banner/index.vue'
import sider from "./aside/index.vue";
export default {
  name: "patient",
  components: {
    sider,
    banner,
  },
};
</script>

<style>
</style>
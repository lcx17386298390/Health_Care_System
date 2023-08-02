<template>
  <div id="app container-fluid" style="height: 100vh">
    <banner></banner>
    <div class="row">
      <div class="col-md-2">
        <sider></sider>
      </div>
      <div class="main col-md-10">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import banner from "./banner/index.vue";
import sider from "./aside/index.vue";
export default {
  name: "patient",
  components: {
    sider,
    banner
  },
};
</script>

<style scoped>
.row{
  margin-right:0;
}
.main{
  background-color: #9999992c
}
</style>
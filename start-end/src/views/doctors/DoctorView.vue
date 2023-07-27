<template>
  <div id="app container-fluid" style="height: 100vh">
    <banner></banner>
    <div class="row">
      <div class="col-md-2">
        <side></side>
      </div>
      <div class="main col-md-10">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import banner from "../doctors/banner/index.vue";
import side from "../doctors/side/index.vue";
export default {
  name: "patient",
  components: {
    side,
    banner
  },
};
</script>

<style scpoed>
.row{
  margin-right:0;
}
.main{
  background-color: #9999992c
}
</style>
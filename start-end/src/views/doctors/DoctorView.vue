<template>
  <div id="app container-fluid" style="height: 100vh">
    <ban></ban>
    <div class="row">
      <div class="col-md-2">
        <side></side>
      </div>
       <div class="col-md-10 d-flex">
        <router-view></router-view> <!-- order组件将会在这里展示 -->
      </div>
    </div>
  </div>
</template>

<script>
import ban from "../doctors/banner/index.vue";
import side from "../doctors/side/index.vue";
export default {
  name: "patient",
  components: {
    side,
    ban
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
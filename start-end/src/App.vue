<template>
  <div id="app">
    <router-view />
    <foot></foot>
  </div>
</template>

<script>
import foot from "@/components/footer/index.vue";

export default {
  name: "app",
  components: {
    foot,
  },
};
</script>
<style >
#app{
  height: 100vh;
}
.bg-primary{
  height: 80%;
}
.foot_container {
  min-height: calc(100vh-20vh);
  height: 20vh; /* You can adjust this value between 80vh and 100vh */
}
</style>

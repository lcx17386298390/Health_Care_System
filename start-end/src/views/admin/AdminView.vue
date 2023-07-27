<template>
    <div>
    <el-container>
      <el-aside width="auto">
        <Aside/>
      </el-aside>
      <el-container>
        <el-header>
          <Header/>
        </el-header>
        <el-main>
            <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from './CommonComponents/Aside.vue'
import Header from './CommonComponents/Header.vue'
export default {
    name:'admin',
    components:{
        Aside,Header
    }
}
</script>

<style lang="less" scoped>
.el-header{
  padding: 0;
}
</style>
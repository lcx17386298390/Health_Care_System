<template>
  <div>
    <el-card shadow="hover" flex>
      <!-- 此处因为没有图片为不影响先行注释 -->
      <img src="@/../public/img/cabo.jpg" alt="cabo" class="img">
      <span class="title">Admin</span>
      <div class="aaa">
        <span class="bbb">HGNUACM医疗健康系统</span>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped lang="less">
.title {
  margin-left: 20px;
  font-size: 30px;
}

.aaa {
  display: flex;
  justify-content: column;

  .bbb {
    align-content: center;
    padding-top: 10px;
    padding-left: 20px;
  }
}

.img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
}
</style>

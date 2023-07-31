<template>
  <div>
    <div class="container-fluid px-4">
      <h1 class="mt-2">开处方</h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <router-link to="/doc/drug0">处方</router-link>
        </li>
        <li class="breadcrumb-item active">诊断</li>
      </ol>
    </div>

    <!-- 卡片 -->
    <el-card class="box-card">
      <h3 class="t">处方单</h3>
      <!-- 诊断内容部分 -->
      <div>
        <!-- 病人信息部分 -->
        <div>

        </div>
      </div>
    </el-card>


  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.t {
  text-align: center;
  font-size: 30px;
  font-weight: 540;
}

/* 卡片部分 */
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 1100px;
}
</style>
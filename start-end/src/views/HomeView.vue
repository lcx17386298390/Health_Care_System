<template>
  <div>
    <header class="p-3 text-bg-dark fixed-top">
      <div class="home_container">
        <div class="d-flex align-items-center justify-content-between">
          <router-link class="navbar-brand fs-4" to="/"
            >HGNUACM医疗健康系统</router-link
          >
          <ul
            class="nav col-12 col-lg-auto mb-2 justify-content-center mb-md-0"
          >
            <li>
              <router-link to="/home" class="nav-link px-2 mx-4 text-secondary"
                >首页</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
            <li>
              <router-link to="/#" class="nav-link px-2 mx-4 text-white"
                >XXX</router-link
              >
            </li>
          </ul>
          <div class="text-end">
            <router-link to="/#" class="btn btn-outline-light me-4"
              >联系我们</router-link
            >
            <router-link to="/login" class="btn btn-warning">登录</router-link>
          </div>
        </div>
      </div>
    </header>
    <!-- 轮播图部分 -->
    <el-carousel indicator-position="inside">
      <el-carousel-item v-for="item in 4" :key="item">
        
        <div>
        <img src="./phono/1.jpg" />
       
        </div>
      </el-carousel-item>
    </el-carousel>
    <!-- <h3>{{ item }}</h3> -->
     <!-- 这里有个bug 轮播图只展示第一张图片 -->

     <!-- 信息部分 -->
  
     <div class="container" style="margin-top: 40px;">
    <div class="row justify-content-center">
      <div class="col-sm-4">
        <div class="card" style="width: 25rem;">
          <img src="./phono/1.jpg" class="card-img-top" />
          <div class="card-body">
            <h5 class="card-title">系统公告</h5>
            <p class="card-text">提供全面的健康管理服务，帮助您实现身心健康，享受高质量的生活。</p>
          </div>
          <div id="myContainer">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">【系统维护通知】关于医疗健康系统维护的公告</li>
              <li class="list-group-item">【重要安全提示】请及时更新医疗健康系统登录密码</li>
              <li class="list-group-item">【健康防护提醒】关于新型传染病疫情的注意事项</li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col-sm-4">
        <div class="card" style="width: 25rem;">
          <img src="./phono/1.jpg" class="card-img-top" />
          <div class="card-body">
            <h5 class="card-title">重大新闻</h5>
            <p class="card-text">新研发出高效的智能诊断技术，将为患者提供更准确、快速的医疗服务。</p>
          </div>
          <div id="myContainer">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">"医疗界突破！智能机器人手术助手成功完成首例无创手术"</li>
              <li class="list-group-item">"健康科技创新! AI算法精准预测肺癌发生风险"</li>
              <li class="list-group-item">"数字化健康管理平台上线，个性化健康方案诞生"</li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col-sm-4">
        <div class="card" style="width: 25rem;">
          <img src="./phono/1.jpg" class="card-img-top" />
          <div class="card-body">
            <h5 class="card-title">医疗医生说</h5>
            <p class="card-text">致力于为患者提供专业的医疗护理和关怀，帮助患者恢复健康和提高生活质量。</p>
          </div>
          <div id="myContainer">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">"医疗医生亲授秘籍:和计算机相处要像清理缓存一样,别让脱发困扰你!"</li>
              <li class="list-group-item">"医生开启计算机修炼:教你用Ctrl+C解决头痛问题!"</li>
              <li class="list-group-item">"医疗界新趋势：医生们拿起键盘,学医修不了BUG"</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 诊室导航 -->
 <div style="margin-top: 40px;margin-left: 100px;">
  <h2>诊室介绍</h2>
  <el-tabs :tab-position="tabPosition" style="height: 200px; margin-top: 20px;">
  <el-tab-pane  label="非手术科室">
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="8" v-for="(data, index) in ['内科', '外科', '妇产科', '儿科', '眼科', '皮肤科']"  :key="index">
          <div class="text item">
            {{ data }}
          </div>
        </el-col>
      </el-row>
    </el-card>
  </el-tab-pane>

  <el-tab-pane label="手术科室">
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="8" v-for="(data, index) in ['心脏科', '神经科', '呼吸科', '皮肤科', '消化科', '骨科']" :key="index">
          <div class="text item">
            {{ data }}
          </div>
        </el-col>
      </el-row>
    </el-card>
  </el-tab-pane>

  <el-tab-pane label="诊断相关科室">
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="8" v-for="(data, index) in ['肾脏科', '血液科', '内分泌科', '耳鼻喉科', '眼科', '口腔科']" :key="index">
          <div class="text item">
            {{ data }}
          </div>
        </el-col>
      </el-row>
    </el-card>
  </el-tab-pane>

  <el-tab-pane label="特色中医科室">
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="8" v-for="(data, index) in ['针灸科', '中药科', '推拿科', '经络科', '康复科', '气功科']" :key="index">
          <div class="text item">
            {{ data }}
          </div>
        </el-col>
      </el-row>
    </el-card>
  </el-tab-pane>
</el-tabs>

 </div>

  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {
  },
  data(){
    return{
      tabPosition: 'left',
    };
  },
};
</script>

<style scoped>
.box-card {
  width: 80%;
  margin-top: 3px;
  height: 180px;
}

.text.item {
  padding: 10px;
  border: 1px solid #ccc;
  margin-top: 15px;
}

.el-row {
  display: flex;
  flex-wrap: wrap;
}
.el-col {
  flex-basis: 33.33%;
}
body{
  padding-right: 0;
}

/* .el-carousel {
  height: 500px;
} */
/* 这里有个问题，该轮播图在页面占比始终没有办法更改 */

.el-carousel__item img {
  width: 100%;
  height: 100%;
}

@media (min-width: 992px) {
  .navbar-expand-lg {
    flex-wrap: nowrap;
    justify-content: flex-start;
  }
  .navbar-expand-lg .navbar-nav {
    flex-direction: row;
  }
  .navbar-expand-lg .navbar-nav .dropdown-menu {
    position: absolute;
  }
  .navbar-expand-lg .navbar-nav .nav-link {
    padding-right: var(--bs-navbar-nav-link-padding-x);
    padding-left: var(--bs-navbar-nav-link-padding-x);
  }
  .navbar-expand-lg .navbar-nav-scroll {
    overflow: visible;
  }
  .navbar-expand-lg .navbar-collapse {
    display: flex !important;
    flex-basis: auto;
  }
}
</style>
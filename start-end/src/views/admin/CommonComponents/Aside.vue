<template>
  <div>
    <el-menu
      default-active="1-4-1"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      :collapse="isCollapse()"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
    <h3>{{ isCollapse() ? '后台' :'医疗后台管理系统'}}</h3>
      <el-menu-item @click="clickMenu(item)" v-for="item in noChildren" :key="item.name" :index="item.name">
        <i :class="`el-icon-${item.icon}`"></i>
        <span slot="title">{{item.label}}</span>
      </el-menu-item>
      <el-submenu v-for="item in hasChildren" :key="item.label" index="item.label">
        <template slot="title">
          <i :class="`el-icon-${item.icon}`"></i>
          <span slot="title">{{item.label}}</span>
        </template>
        <el-menu-item-group v-for="subItem in item.children" :key="subItem.path">
          <el-menu-item  @click="clickMenu(subItem)" :index="subItem.path">{{subItem.label}}</el-menu-item>
        </el-menu-item-group>
       
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {
      menuData: [
        {
          path: "/admin/admin-home",
          name: "adminHome",
          label: "首页",
          icon: "s-home",
          url: "AdminHome/AdminHome",
        },
        {
          path: "/admin/appointment",
          name: "appointment",
          label: "预约信息",
          icon: "date",
          url: "Appointment/Appointment",
        },

        {
          path: "/admin/department",
          name: "department",
          label: "科室信息",
          icon: "monitor",
          url: "Department/Department",
        },
        {
          path: "/admin/disease",
          name: "disease",
          label: "病历信息",
          icon: "notebook-1",
          url: "Disease/Disease",
        },
        {
          path: "/admin/prescription",
          name: "prescription",
          label: "处方信息",
          icon: "notebook-2",
          url: "Prescription/Prescription",
        },
        {
          path: "/admin/drug",
          name: "drug",
          label: "药品管理",
          icon: "suitcase-1",
          url: "Drug/Drug",
        },
        {
          label: "用户管理",
          icon: "user",
          children: [
            {
              path: "/admin/doctor",
              name: "doctor",
              label: "医生管理",
              icon: "setting",
              url: "UserManage/doctor",
            },
            {
              path: "/admin/patient",
              name: "patient",
              label: "病人管理",
              icon: "setting",
              url: "UserManage/patient",
            }
          ],
        },
      ],
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    clickMenu(item){
      if(this.$route.path !== item.path &&!(this.$route.path ==='/admin' &&(item.path === '/'))){
        this.$router.push(item.path)
      }
    //   this.$store.commit('selectMenu',item)
    },
    isCollapse(){
     return this.$store.state.isCollapse
    }
  },
  computed:{
    noChildren(){
      return this.menuData.filter(item => !item.children)
    },
    hasChildren(){
      return this.menuData.filter(item => item.children)
    }
  }
};
</script>
<style lang="less" scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.el-menu {
  margin: 0;
  padding: 0;
  height: 100vh;
  border-right: none;
  h3{
    color: #fff;
    text-align: center;
    line-height: 48px;
    font-size: 16px;
    font-weight: 400;
  }
}
</style>
<template>
  <div class="header-container">
    <div class="l-container">
      <el-button @click="handMenu()" icon="el-icon-menu" size="mini" style="margin-right:20px"></el-button>
      <!-- 面包屑 -->
      <!-- <el-breadcrumb separator="/">
        <el-breadcrumb-item v-for="item in tags" :key="item.path" :to="{ path: item.path }">{{item.label}}</el-breadcrumb-item>
      </el-breadcrumb> -->
    </div>
    <div class="r-container">
      <el-dropdown>
        <span class="el-dropdown-link">
          <!-- 此处因为没有图片为不影响先行注释 -->
          <!-- <img class="user" src="@/../public/img/cabo.jpg" alt="头像" /> -->
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>个人中心</el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data () {
    return {}
  },
  methods: {
    handMenu () {
      this.$store.commit("collapseMenu")
    },
  },
  computed: {
    ...mapState({
      tags: state => state.tab.tabsList
    })
  }
}
</script>

<style lang="less" scoped>
.header-container {
  padding: 0 20px;
  background-color: #333;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .r-container {
    .user {
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
  }

  .l-container {
    display: flex;
    align-items: center;

    /deep/.el-breadcrumb__item {
      .el-breadcrumb__inner {
        font-weight: normal;

        &.is-link {
          color: #666;
        }
      }

      &:last-child {
        .el-breadcrumb__inner {
          color: #fff;
        }
      }

      &:hover {
        .el-breadcrumb__inner {
          color: #888;
        }
      }
    }
  }
}
</style>
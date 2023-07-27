<template>
  <div class="pop-layer">
    <div class="user-avatar" @mouseenter="showPopup" @mouseleave="hidePopup">
      <div class="user-info">
        <!-- 传入姓名 {{user.name}}-->
        <span class="user-name">aa</span>
      </div>
      <el-avatar icon="el-icon-user-solid" :style="avatarStyle"></el-avatar>
      <div v-if="showPopupContent" class="popup-content text-small">
        <router-link class="popup-link" to="/patient/self">个人信息</router-link>
        <router-link class="popup-link" to="/home">退出登录</router-link>
        <router-link class="popup-link" to="/home">退出登</router-link>
        <router-link class="popup-link" to="/home">退出</router-link>
        <router-link class="popup-link" to="/home">退</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    // 传参数组
//   props: {
//     user: {
//       type: Object,
//       required: true,
//     },
//   },
  data() {
    return {
      showPopupContent: false,
    };
  },
  computed: {
    avatarStyle() {
      return this.showPopupContent ? { transform: "scale(1.1)" } : {};
    },
  },
  methods: {
    showPopup() {
      this.showPopupContent = true;
    },
    hidePopup() {
      this.showPopupContent = false;
    },
  },
};
</script>

<style>
.pop-layer {
  position: relative;
  z-index: 9999;
}
.user-avatar {
  display: flex;
  align-items: center;
  cursor: pointer;
  position: relative;
}

.user-info {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 8px;
  color: #fff;
}

.user-name {
  font-size: 21px;
  color: #fff;
  font-weight: bold;
}

.popup-content {
  position: absolute;
  top: 100%;
  left: 50%;
  transform: translateX(-50%);
  background-color: rgb(238, 238, 238);
  border: 1px solid #ddd;
  padding: 9px 12px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  min-width: 120px;
  min-height: 140px;
}

.popup-link {
  display: block;
  padding: 8px;
  color: #333;
  text-decoration: none;
  font-size: 16px;
  border-radius: 4px;
  transition: background-color 0.3s ease;
}

.popup-link:last-child {
  margin-right: 0; 
}
.popup-link:hover {
  color: #fff;
  background-color: #409eff; /* Background color on hover */
}

.popup-link:active {
  background-color: #0050a1; /* Background color when link is active/selected */
}

.popup-link:focus {
  outline: none; /* Remove the default focus outline */
}

</style>

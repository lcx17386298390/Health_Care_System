import Vue from 'vue'
import Vuex from "vuex"
import App from './App.vue'
import router from './router'
import store from './store'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap-icons/font/bootstrap-icons.css';
import directive from './directive' // directive
import plugins from './plugins' // plugins
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import axiosConfig from './http/axios-config.js';
import axios from "axios";
import Cookies from 'js-cookie'
// import http from "./http";
// Vue.prototype.$http = http;
import './assets/styles/element-variables.scss'
import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import { download } from '@/utils/request'
import './assets/icons' // icon
import { getDicts } from "@/api/system/dict/data";
import { getConfigKey } from "@/api/system/config";
import { parseTime, resetForm, addDateRange, selectDictLabel, selectDictLabels, handleTree } from "@/utils/ruoyi";




// 分页组件
import Pagination from "@/components/Pagination";
// 自定义表格工具组件
import RightToolbar from "@/components/RightToolbar"
// 富文本组件
import Editor from "@/components/Editor"
// 文件上传组件
import FileUpload from "@/components/FileUpload"
// 图片上传组件
import ImageUpload from "@/components/ImageUpload"
// 图片预览组件
import ImagePreview from "@/components/ImagePreview"
// 字典标签组件
import DictTag from '@/components/DictTag'
// 头部标签组件
import VueMeta from 'vue-meta'
// 字典数据组件
import DictData from '@/components/DictData'
// 全局方法挂载
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree
Vue.config.productionTip = false
Vue.prototype.resetForm = resetForm
Vue.use(Vuex);


// 全局组件挂载
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)
Vue.component('Editor', Editor)
Vue.component('FileUpload', FileUpload)
Vue.component('ImageUpload', ImageUpload)
Vue.component('ImagePreview', ImagePreview)
Vue.use(ElementUI);
Vue.use(directive)
Vue.use(plugins)
Vue.use(VueMeta)
DictData.install()

new Vue({
  state: {
    realname: "",
  },
  mutations: {
    setrealname(state, doctorName) {
      state.realname = doctorName;
    },
  },
  router,
  store,
  render: h => h(App)
}).$mount('#app')

Vue.prototype.$http = axios; 
Vue.prototype.$axiosConfig= axiosConfig;
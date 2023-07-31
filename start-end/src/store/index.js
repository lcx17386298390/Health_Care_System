import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import dict from './modules/dict'
import user from './modules/user'
import tagsView from './modules/tagsView'
import permission from './modules/permission'
import settings from './modules/settings'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isCollapse:false,
  },
  getters: {
  },
  mutations: {
    collapseMenu(state){
      state.isCollapse= !state.isCollapse
  },
  },
  actions: {
  },
  modules: {
    app,
    dict,
    user,
    tagsView,
    permission,
    settings
  },
})

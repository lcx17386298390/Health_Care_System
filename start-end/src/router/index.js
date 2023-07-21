import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '../views/HomeView.vue'
import Login from '../components/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home',
    name: 'Homeview',
    component: HomeView
  },
  {
    path: '/home',
    name: 'Homeview',
    component: HomeView
  },



  {
    path: '/home/login',
    name: 'Login',
    component: Login
  },
  // {
  //   path: '/home',
  //   name: '',
  //   component: 
  // },
  // {
  //   path: '/home',
  //   name: '',
  //   component: 
  // },



]

const router = new VueRouter({
  routes
})

export default router

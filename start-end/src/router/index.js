import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '../views/HomeView.vue'
import Login from '../components/Login.vue'
import Password from '../components/Password.vue'
import Register from '../components/Register.vue'
import PatientView from '../views/patients/PatientView.vue'
import Example from '../views/patients/Example.vue'

import buyDrug from '../views/patients/buyDrug/index.vue'
import regisProcess from '../views/patients/regisProcess/index.vue'
import prescription from '../views/patients/prescription/index.vue'
import history from '../views/patients/history/index.vue'
import selfInfo from '../views/patients/selfInfo/index.vue'
import nav from '../views/patients/navigate/index.vue'

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
    path: '/patient',
    name: 'Patientview',
    component: PatientView,
    children:[
      {path:'regis',name:'regisProcess',component:regisProcess},
      {path:'prescription',name:'prescription',component:prescription},
      {path:'history',name:'history',component:history},
      {path:'buydrug',name:'buydrug',component:buyDrug},
      {path:'self',name:'selfInfo',component:selfInfo},
      {path:'nav',name:'nav',component:nav},
    ]
  },
  
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/password',
    name: 'Password',
    component: Password
  },
  {
    path: '/example',
    name: 'Example',
    component: Example
  }



]

const router = new VueRouter({
  routes
})

export default router

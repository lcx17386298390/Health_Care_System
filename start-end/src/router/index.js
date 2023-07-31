import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '../views/HomeView.vue'
import Login from '../components/Login.vue'
import Password from '../components/Password.vue'
import Register from '../components/Register.vue'
import PatientView from '../views/patients/PatientView.vue'
import docView from '../views/doctors/DoctorView.vue'
import AdminView from '../views/admin/AdminView.vue'
import Example from '../views/patients/Example.vue'

// 病人
import buyDrug from '../views/patients/buyDrug/index.vue'
import regisProcess from '../views/patients/regisProcess/index.vue'
import prescription0 from '../views/patients/prescription0/index.vue'
import history from '../views/patients/history/index.vue'
import selfInfo from '../views/patients/selfInfo/index.vue'
import nav from '../views/patients/navigate/index.vue'


import consultation from '../views/patients/prescription0/consultation.vue'


// 医生
import order from '../views/doctors/order/index.vue'
import drug0 from '../views/doctors/drug0/index.vue'
import his from '../views/doctors/history/index.vue'
import docSelf from '../views/doctors/docSelf/index.vue'
import adminLogin from "@/views/admin/adminLogin.vue"



//测试
import appointment from "@/views/admin/appointment/index.vue"
import department from "@/views/admin/department/index.vue"
import disease from "@/views/admin/disease/index.vue"
import doctor from "@/views/admin/doctor/index.vue"
import drug from "@/views/admin/drug/index.vue"
import patient from "@/views/admin/patient/index.vue"
import prescription from "@/views/admin/prescription/index.vue"
import adminHome from "@/views/admin/Pages/AdminHome/index.vue"

Vue.use(VueRouter)

const routes = [
  //   ceshi
  {
    path: '/admin-login',
    name: 'adminLogin',
    component: adminLogin
  },

  //
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
    path: '/consultation',
    name: 'consultation',
    component: consultation
  },
  {
    path: '/patient',
    redirect: '/patient/nav',
    name: 'Patientview',
    component: PatientView,
    children: [
      { path: 'regis', name: 'regisProcess', component: regisProcess },
      { path: 'prescription0', name: 'prescription0', component: prescription0 },
      { path: 'history', name: 'history', component: history },
      { path: 'buydrug', name: 'buydrug', component: buyDrug },
      { path: 'self', name: 'selfInfo', component: selfInfo },
      { path: 'nav', name: 'nav', component: nav },
      { path: 'consultation', name: 'consultation', component: consultation },
    ]
  },
  {
    path: '/doc',
    redirect: '/doc/order',
    name: 'docView',
    component: docView,
    children: [
      { path: 'order', name: 'order', component: order },
      { path: 'drug0', name: 'drug0', component: drug0 },
      { path: 'his', name: 'his', component: his },
      { path: 'docSelf', name: 'docSelf', component: docSelf },

    ]
  },
  {
    path: '/admin',
    redirect: '/admin-login',
    name: 'AdminView',
    component: AdminView,
    children: [
      { path: 'admin-home', name: 'admin-home', component: adminHome },
      { path: 'appointment', name: 'appointment', component: appointment },
      { path: 'drug', name: 'drug', component: drug },
      { path: 'doctor', name: 'doctor', component: doctor },
      { path: 'patient', name: 'patient', component: patient },
      {
        path: 'department',
        name: 'department',
        component: department
      },
      {
        path: 'disease',
        name: 'disease',
        component: disease
      },
      {
        path: 'prescription',
        name: 'prescription',
        component: prescription
      },
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

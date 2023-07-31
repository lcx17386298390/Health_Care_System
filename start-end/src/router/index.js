import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '../views/HomeView.vue'
import Login from '../components/Login.vue'
import Password from '../components/Password.vue'
import Register from '../components/Register.vue'
import PatientView from '../views/patients/patientView.vue'
import docView from '../views/doctors/DoctorView.vue'
import AdminView from '../views/admin/AdminView.vue'
import Example from '../views/patients/Example.vue'

import buyDrug from '../views/patients/buyDrug/index.vue'
import regisProcess from '../views/patients/regisProcess/index.vue'
import prescription from '../views/patients/prescription/index.vue'
import history from '../views/patients/history/index.vue'
import selfInfo from '../views/patients/selfInfo/index.vue'
import nav from '../views/patients/navigate/index.vue'

import order from '../views/doctors/order/index.vue'
import drug from '../views/doctors/drug/index.vue'
import his from '../views/doctors/history/index.vue'
import docSelf from '../views/doctors/docSelf/index.vue'

import AdminHome from '../views/admin/Pages/AdminHome/index.vue'
import DataAnalysis from '../views/admin/Pages/DataAnalysis/index.vue'
import DrugManage from '../views/admin/Pages/DrugManage/index.vue'
import DoctorManage from '../views/admin/Pages/UserMagage/DoctorManage/index.vue'
import PatientManage from '../views/admin/Pages/UserMagage/PatientManage/index.vue'

import consultation from '../views/patients/prescription/consultation.vue'
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
      { path: 'prescription', name: 'prescription', component: prescription },
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
      { path: 'drug', name: 'drug', component: drug },
      { path: 'his', name: 'his', component: his },
      { path: 'docSelf' , name: 'docSelf' ,component: docSelf},

    ]
  },
  {
    path: '/admin',
    redirect: '/admin/admin-home',
    name: 'AdminView',
    component: AdminView,
    children: [
      { path: 'admin-home', name: 'adminHome', component: AdminHome },
      { path: 'data-analysis', name: 'dataAnalysis', component: DataAnalysis },
      { path: 'drug-manage', name: 'drugManage', component: DrugManage },
      { path: 'doctor-manage', name: 'doctorManage', component: DoctorManage },
      { path: 'patient-manage', name: 'patientManage', component: PatientManage }
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

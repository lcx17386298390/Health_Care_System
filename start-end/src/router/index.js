import Vue from 'vue'
import VueRouter from 'vue-router'

import HomeView from '../views/HomeView.vue'
import Login from '../components/Login.vue'
import Password from '../components/Password.vue'
import Register from '../components/Register.vue'
import PatientView from '../views/patients/PatientView.vue'
import Example from '../views/patients/Example.vue'
import buyDrug from '../views/patients/buyDrug/index.vue'

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
    component: PatientView
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
  },
  {
    path: '/patient/buy',
    name: 'buyDrug',
    component: buyDrug
  },



]

const router = new VueRouter({
  routes
})

export default router

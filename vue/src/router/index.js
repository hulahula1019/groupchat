import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import Login from "@/views/Login.vue";
import Layout from "@/views/Layout.vue";
import Register from "@/views/Register";
import ImGroup from "@/views/ImGroup.vue";
import Person from "@/views/Person";
import Password from "@/views/Password";

Vue.use(VueRouter)

const routes = [
  { path: '/login', component: Login },
  { path: '/register', component: Register },
  { path: '/', component: Layout,
    children: [
      { path: '', component: Home },
      { path: 'imGroup', component: ImGroup },
      { path: 'person', component: Person },
      { path: 'password', component: Password },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

// 路由守卫
router.beforeEach((to ,from, next) => {
  const user = localStorage.getItem("user");
  if (!user && to.path !== '/login' && to.path !== '/register') {
    return next("/login");
  }
  next();
})

export default router

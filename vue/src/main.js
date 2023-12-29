import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/global.css'
import '@/assets/fonts/font-awesome.css'

Vue.config.productionTip = false
Vue.use(ElementUI, { size: "small"});
Vue.prototype.$bus = new Vue();

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

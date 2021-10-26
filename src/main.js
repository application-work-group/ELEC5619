import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from "vue-router";
import router from "./router"
import store from './store/index'
import vuetify from './plugins/vuetify'
import './plugins/element.js'
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter);

new Vue({
  render: h => h(App),
  router,
  vuetify,
  store
}).$mount('#app')

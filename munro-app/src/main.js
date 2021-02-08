import Vue from "vue";
import Vuex from 'vuex'
import App from "./App.vue";
import storeConfig from "./store/store-config";



Vue.config.productionTip = false;

Vue.use(Vuex)


const store = new Vuex.Store(storeConfig)

new Vue({
  store,
  render: h => h(App)
}).$mount("#app");

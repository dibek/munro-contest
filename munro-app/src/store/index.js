import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    rowData: []
  },
  mutations: {
    loadRowDataMutation(state, payload) {
      state.rowData = payload.rowData;
    }
  },
  actions: {
    loadRowDataAction(context, payload) {
      context.commit("loadRowDataMutation", payload);
    }
  },
  modules: {},
  getter: {}
});

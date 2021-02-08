import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default {
  state: {
    rowData: [],
    searchData: {
      sort: 'name',
      direction: 'ASC',
      page: 1,
      size: 10,
      category: '',
      minHeight: 0,
      maxHeight:2000
    },
    pending: false
  },
  mutations: {
    loadRowDataMutation(state, payload) {
      state.rowData = payload.rowData;
    },
    setSearchDataMutation(state, payload) {
      state.searchData = payload.searchData;
    }
  },
  actions: {
    loadRowDataAction(context, payload) {
      context.commit("loadRowDataMutation", payload);
    },
    setSearchDataAction(context,payload){
      context.commit("setSearchDataMutation",payload)
    }
  },
  modules: {},
  getter: {}
};

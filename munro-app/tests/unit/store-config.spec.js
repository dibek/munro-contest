import storeConfig from "../../src/store/store-config.js";
import { createLocalVue } from '@vue/test-utils'
import Vuex from 'vuex'
import { cloneDeep } from "lodash";

describe('store', () => {
  describe('mutations', () => {
    it("loadRowDataMutation", () => {
      const localVue = createLocalVue();
      localVue.use(Vuex);
      const store = new Vuex.Store(cloneDeep(storeConfig));
      expect(store.state.rowData).toHaveLength(0);
      store.commit('loadRowDataMutation',{rowData: [{category:'TOP'}]})
      expect(store.state.rowData).toHaveLength(1);
    });
    it("setSearchDataMutation", () => {
      const localVue = createLocalVue();
      localVue.use(Vuex);
      const store = new Vuex.Store(cloneDeep(storeConfig));
      expect(store.state.searchData.sort).toBe('name');
      store.commit('setSearchDataMutation',{searchData: {sort:'category'}})
      expect(store.state.searchData.sort).toBe('category');
    });
  });

  describe('actions', () => {
    it("loadRowDataMutation", () => {
      const localVue = createLocalVue();
      localVue.use(Vuex);
      const store = new Vuex.Store(cloneDeep(storeConfig));
      expect(store.state.rowData).toHaveLength(0);
      store.dispatch('loadRowDataAction',{rowData: [{category:'TOP'}]})
      expect(store.state.rowData).toHaveLength(1);
    });
    it("setSearchDataAction", () => {
      const localVue = createLocalVue();
      localVue.use(Vuex);
      const store = new Vuex.Store(cloneDeep(storeConfig));
      expect(store.state.searchData.sort).toBe('name');
      store.dispatch('setSearchDataAction',{searchData: {sort:'category'}})
      expect(store.state.searchData.sort).toBe('category');
    });
  });
})


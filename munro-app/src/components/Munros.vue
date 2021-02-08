<template>
  <ag-grid-vue
    style="width: 1000px; height: 1000px;"
    class="ag-theme-alpine"
    :columnDefs="columnDefs"
    :rowData="getRowData"
  >
  </ag-grid-vue>
</template>

<script>
import { AgGridVue } from "ag-grid-vue";
export default {
  name: "App",
  data() {
    return {
      columnDefs: null,
      category: null,
      minHeight: null,
      maxHeight: null,
      rowData: null
    };
  },
  components: {
    AgGridVue
  },
  beforeMount() {
    this.columnDefs = [
      { field: "name", sortable: true },
      { field: "heightMeter", sortable: true },
      { field: "gridRef", sortable: true },
      { field: "category", sortable: true, filter: true }
    ];
    this.rowData = this.$store.state.rowData;
  },
  mounted() {
    this.rowData = this.$store.state.rowData;
  },
  computed: {
    getRowData()
    {
      return this.$store.state.rowData;
    }
  },

};
</script>

<style lang="scss">
@import "../../node_modules/ag-grid-community/dist/styles/ag-grid.css";
@import "../../node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css";
</style>

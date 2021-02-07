<template>
  <form id="search">
    Category <input name="category" v-model="category" /> Min Height (m)
    <input name="minHeight" v-model="minHeight" /> Max Height (m)
    <input name="maxHeight" v-model="maxHeight" />
    <input type="button" value="Search" @click="searchMunro" />
    <Munros  :rowData="rowData"/>
  </form>
</template>

<script>
import Munros from "./components/Munros.vue";
import axios from "axios";

export default {
  name: "App",
  components: {
    Munros
  },
  data() {
    return {
      category: null,
      minHeight: null,
      maxHeight: null,
      rowData: null
    };
  },
  mounted() {
    axios.get("http://localhost:8080/v1/api/munros")
      .then(response => {
        this.$store.dispatch("loadRowDataAction", {
         rowData: response.data
        });
  });
  },
  methods: {
    searchMunro: function() {
      axios
        .get(
          "http://localhost:8080/v1/api/munros?" +
            "minHeight=" +
            (this.minHeight ?  this.minHeight:0) +
            "&maxHeight=" +
            (this.maxHeight ? this.maxHeight: 2000) +
            "&category=" +
            (this.category ? this.category: "TOP")
        )
        .then(response => {
          console.log(response.data);
          this.$store.dispatch("loadRowDataAction", {
            rowData: response.data
          });
        })
    }
  }
};
</script>

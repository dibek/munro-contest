<template>
  <form id="search">
    Category <input name="category" v-model="category" />
    Min Height (m)<input name="minHeight" v-model="minHeight" />
    Max Height (m)<input name="maxHeight" v-model="maxHeight" />
    <br/>
    Page<input name="page" v-model="page" />
    Element for page<input name="size" v-model="size" />
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
      rowData: null,
      page: 1,
      size: 10
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
            (this.category ? this.category: "TOP") +
            "&page=" +
            (this.page ? this.page: 1) +
            "&size=" +
            (this.size ? this.size: 10),

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

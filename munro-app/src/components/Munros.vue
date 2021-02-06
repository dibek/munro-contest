<template>
  List Munros
  <h1>{{ msg }}</h1>
  <section v-if="errored">
    <p>We're sorry, we're not able to retrieve the list of munros  at the moment, please try back later</p>
  </section>
  <section v-else>
    <div v-if="loading">Loading...</div>
  </section>
</template>


<script>
import axios from "axios";

export default {
  name: 'Munros',
  props: {
    msg: String
  },
  data () {
    return {
      data: null,
      loading: true,
      errored: false
    }
  },
  filters: {
    filterMunros (value) {
      return value
    }
  },
  mounted () {
    axios
        .get('http://localhost:8080/v1/api/munros')
        .then(response => {
          this.data = response
        })
        .catch(error => {
          console.log(error)
          this.errored = true
        })
        .finally(() => this.loading = false)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
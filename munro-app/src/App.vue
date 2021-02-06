<template>
  <Munros msg="Welcome to Your Munros App"/>
</template>

<script>
import Munros from "./components/Munros";

export default {
  name: 'App',
  components: {
    Munros
  },
  data () {
    return {
      username: ''
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

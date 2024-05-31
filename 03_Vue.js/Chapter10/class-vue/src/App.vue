<template>
  <div class="container-fluid">
    <Header />
    <router-view></router-view>
  </div>
</template>

<script>
import Header from './components/Header.vue';

export default {
  name: 'App',
  components: { Header },
};
</script>

<style>
.container-fluid {
  text-align: center;
  margin-top: 10px;
}

* {
  margin: 0;
  padding: 0;
}

</style>

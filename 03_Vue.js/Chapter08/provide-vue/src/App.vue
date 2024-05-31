<script setup>
import Child from './components/Child.vue';
</script>

<template>
  <div>
    <Child :drilling="drilling" />
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      drilling: '어디까지 내려가는거에요',
    };
  },
  provide() {
    return {
      fly: 'provide',
    };
  },
};
</script>

<style></style>

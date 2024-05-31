<script setup>
import ColorEmit from './components/ColorEmit.vue';
</script>

<template>
  <div :style="{ backgroundColor: color }">
    <h1>저의 색상을 정해주세요</h1>
    <ColorEmit @colorChanged="colorHandler" /> 
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      color: '',
    };
  },
  methods: {
    colorHandler(e) {
      this.color = e.color;
    },
  },
};
</script>

<style></style>

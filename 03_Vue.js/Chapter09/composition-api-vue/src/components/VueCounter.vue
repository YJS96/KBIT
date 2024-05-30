<template>
  <h1>Vue3 Counter</h1>
  <div>Count : {{ count }}</div>
  <div>두배로! {{ double }}</div>
  <div>지금까지 계산한 횟수 : {{ countClicked }}</div>
  <button @click="increment">Increment</button>
  <button @click="decrement">Decrement</button>
</template>

<script setup>
import { computed, ref } from 'vue';

const count = ref(0);

const countClicked = ref(0);

const double = computed(() => {
  return count.value * 2;
});

const increment = () => {
  count.value++;
  countClicked.value++;
};

const decrement = () => {
  count.value--;
  countClicked.value++;
};
</script>

<style></style>

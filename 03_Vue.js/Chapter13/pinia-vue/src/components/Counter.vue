<template>
  <div>
    <h1>Counter</h1>
    <h1>count : {{ count }}</h1>
    <h1>count*2 : {{ doubleCount }}</h1>
    <button @click="increment">+1</button>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useCounterStore } from '@/stores/counter';

const counterStore = useCounterStore();
const { increment } = counterStore;
const count = computed(() => counterStore.count);
const doubleCount = computed(() => counterStore.doubleCount);
</script>

<style></style>

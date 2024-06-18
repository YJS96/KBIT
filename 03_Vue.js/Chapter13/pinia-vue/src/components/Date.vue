<template>
  <div>
    <h1>Date</h1>
    <h1>{{ dateMsg }}</h1>
    <button @click="getYear">년도 출력</button>&nbsp;
    <button @click="getMonth">월 출력</button>&nbsp;
    <button @click="getDay">일자 출력</button>
  </div>
</template>

<script setup>
import { useDateStore } from '@/stores/date';
import { computed } from 'vue';

const dateStore = useDateStore();

const { getYear, getMonth, getDay } = dateStore;
const dateMsg = computed(() => dateStore.dateMsg);
</script>

<style></style>

import { ref } from 'vue';
import { defineStore } from 'pinia';

export const useDateStore = defineStore('date', () => {
  const date = new Date();
  const dateMsg = ref('');

  const getYear = () => {
    dateMsg.value = `오늘은 ${date.getFullYear()}년 입니다`;
  };

  const getMonth = () => {
    dateMsg.value = `오늘은 ${date.getMonth() + 1}월 입니다`;
  };

  const getDay = () => {
    dateMsg.value = `오늘은 ${date.getDate()}일 입니다`;
  };

  return { dateMsg, getYear, getMonth, getDay };
});

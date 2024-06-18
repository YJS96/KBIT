<template>
  <h1>ㅇㅇ</h1>
  <input type="text" v-model.trim="todoInput" />
  <button>추가</button>
  <div v-for="todo in states.todoList">
    <TodoList :todoObj="todo" />
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import axios from 'axios';


const todoInput = ref('');
const states = reactive({
  todoList: [],
});

const getTodo = async () => {
  try {
    const getTodoRes = await axios.get('http://localhost:3000/todos');
    states.todoList = getTodoRes.data;
    // console.log(getTodoRes.data);
  } catch (err) {
    console.log(err);
  }
};

getTodo();
</script>

<style scoped></style>

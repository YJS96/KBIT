<template>
  <div>
    <h1>TodoList 테스트(Composition API)</h1>
    <hr />
    <div>
      <span>할 일 추가 : </span>
      <input type="text" v-model="todoInput" />
      <button @click="addTodoHandler">추가</button>
    </div>
    <hr />
    <ul>
      <li v-for="todoItem in todoList" :key="todoItem.id">
        <span @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
import { computed, ref } from 'vue';
import { useTodoListStore } from '@/stores/todoList';

const todoInput = ref('');

const todoListStore = useTodoListStore();
const doneCount = computed(() => todoListStore.doneCount);
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

// 할일 추가 후 input 내용 리셋
const addTodoHandler = () => {
  addTodo(todoInput.value);
  todoInput.value = '';
};
</script>

<style scoped></style>

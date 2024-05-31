<script setup>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
</script>

<template>
  <div style="display: flex; flex-direction: column; align-items: center">
    <h1>TodoList</h1>
    <InputTodo @addTodo="addTodo" />
    <TodoList :todoList="todoList" @toggleCompleted="toggleCompleted" @deleteTodo="deleteTodo" />
  </div>
</template>

<script>
export default {
  components: {
    InputTodo,
    TodoList,
  },
  data() {
    return {
      todoList: [
        {
          id: 1,
          todo: 'TodoList 만들기',
          completed: false,
        },
        {
          id: 2,
          todo: '퇴근하기',
          completed: false,
        },
        {
          id: 3,
          todo: '집가기',
          completed: false,
        },
        {
          id: 4,
          todo: '잠자기',
          completed: false,
        },
      ],
    };
  },
  methods: {
    addTodo(todo) {
      this.todoList.push({
        id: this.todoList.length + 1,
        todo: todo.todo,
        completed: false,
      });
    },
    toggleCompleted(id) {
      const index = this.todoList.findIndex((item, index) => {
        return id === item.id;
      });
      this.todoList[index].completed = !this.todoList[index].completed;
    },
    deleteTodo(id) {
      const index = this.todoList.findIndex((item) => id === item.id);
      this.todoList.splice(index, 1);
    },
  },
};
</script>

<style></style>

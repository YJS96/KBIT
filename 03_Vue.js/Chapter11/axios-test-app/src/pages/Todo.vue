<template>
  <main>
    <div>
      <h1>Todo List</h1>
      <div>
        <input type="text" v-model.trim="todo" />
        <button @click="addTodo">추가</button>
      </div>
      <br />
      <ol>
        <li>
          <span>투두 리스트 만들기</span>
          <span v-if="true">
            <button>수정</button>/
            <button>삭제</button>
          </span>
        </li>
      </ol>
      <ol>
        <li v-for="todoItem in states.todoList" :key="todoItem.id">
          <span
            :style="todoItem.done ? { textDecoration: 'line-through' } : { textDecoration: 'none' }"
            @click.stop="toggleTodo(todoItem.id)"
            >{{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}</span
          >
          <span>
            <button>수정</button>
            <button @click.stop="deleteTodo(todoItem.id)">삭제</button>
          </span>
        </li>
      </ol>
    </div>
  </main>
</template>

<script setup>
import axios from 'axios';
import { reactive, ref } from 'vue';

const BASEURL = '/api/todos';
const states = reactive({
  todoList: [],
});
const todo = ref('');

const fetchTodoList = async () => {
  try {
    const getTodoRes = await axios.get(BASEURL);
    states.todoList = getTodoRes.data;
    console.log(states.todoList);
  } catch (err) {
    alert('Err 발생');
    console.log(e);
  }
};
fetchTodoList();

const addTodo = async () => {
  if (todo.value === '') return alert('할 일을 입력해 주세요');

  try {
    const addTodoRes = await axios.post(BASEURL, {
      todo: todo.value,
      done: false,
    });

    if (addTodoRes.status !== 201) return alert('Todo 추가 실패');

    todo.value = '';
    fetchTodoList();
  } catch (err) {
    alert('추가 ERR발생');
    console.log(err);
  }
};

const deleteTodo = async (id) => {
  console.log(id);
  try {
    await axios.delete(`${BASEURL}/${id}`);
    fetchTodoList();
  } catch (err) {
    console.log(err);
  }
};

const toggleTodo = async (id) => {
  try {
    const targetTodo = states.todoList.find((todo) => todo.id === id);
    const payload = { ...targetTodo, done: !targetTodo.done };
    const toggleTodoRes = await axios.put(`${BASEURL}/${id}`, payload);

    if (toggleTodoRes.status !== 200) return alert('Todo 변경 실패');
    fetchTodoList();
  } catch (err) {
    alert('수정 ERR');
    console.log(err);
  }
};
</script>

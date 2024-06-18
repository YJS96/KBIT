// import { defineStore } from 'pinia';
// import { computed, reactive } from 'vue';

// export const useTodoListStore = defineStore('todoList', () => {
//   const state = reactive({
//     todoList: [
//       {
//         id: 1,
//         todo: 'ES6학습',
//         done: false,
//       },
//       {
//         id: 2,
//         todo: 'React학습',
//         done: false,
//       },
//       {
//         id: 3,
//         todo: 'ContextAPI학습',
//         done: false,
//       },
//       {
//         id: 4,
//         todo: '야구경기 관람',
//         done: false,
//       },
//     ],
//   });

//   // action
//   const addTodo = (todo) => {
//     state.todoList.push({
//       id: new Date().getTime(),
//       todo,
//       done: false,
//     });
//   };

//   const deleteTodo = (id) => {
//     let index = state.todoList.findIndex((todo) => todo.id === id);
//     state.todoList.splice(index, 1);
//   };

//   const toggleDone = (id) => {
//     let index = state.todoList.findIndex((todo) => todo.id === id);
//     state.todoList[index].done = !state.todoList[index].done;
//   };

//   // 계산된 속성
//   const doneCount = computed(() => {
//     return state.todoList.filter((todoItem) => todoItem.done === true).length;
//   });

//   const todoList = computed(() => state.todoList);
//   return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
// });

import { defineStore } from 'pinia';
import { reactive, computed } from 'vue';
import axios from 'axios';

export const useTodoListStore = defineStore('todoList', () => {
  const BASEURI = '/api/todos';
  const state = reactive({ todoList: [] });

  const fetchTodoList = async () => {
    try {
      const response = await axios.get(BASEURI);
      if (response.status === 200) {
        state.todoList = response.data;
      } else {
        alert('데이터 조회 실패');
      }
    } catch (err) {
      console.log(err);
    }
  };

  const addTodo = async ({ todo, desc }, successCallback) => {
    try {
      const payload = { todo, desc };
      const response = await axios.post(BASEURI, payload);
      if (response.status === 201) {
        state.todoList.push({ ...response.data, done: false });
        successCallback();
      } else {
        alert('Todo 추가 실패');
      }
    } catch (err) {
      console.log(err);
    }
  };

  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    try {
      const payload = { id, todo, desc, done };
      const response = await axios.put(`${BASEURI}/${id}`, payload);
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList[index] = payload;
        successCallback();
      } else {
        alert('Todo 변경 실패');
      }
    } catch (err) {
      console.log(err);
    }
  };

  const deleteTodo = async (id) => {
    try {
      const response = await axios.delete(`${BASEURI}/${id}`);

      if (response.state === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList.splice(index, 1);
      } else {
        alert('Todo 삭제 실패');
      }
    } catch (err) {
      console.log(err);
    }
  };

  const toggleDone = async (id) => {
    try {
      let todo = state.todoList.find((todo) => todo.id === id);
      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(`${BASEURI}/${id}`, payload);

      if (response.status === 200) {
        todo.done = payload.done;
      } else {
        alert('Todo 완료 변경 실패');
      }
    } catch (err) {
      console.log(err);
    }
  };

  const todoList = computed(() => state.todoList);
  const isLoading = computed(() => state.isLoading);
  const doneCount = computed(() => {
    const filtered = state.todoList.filter((todoItem) => todoItem.done === true);
    return filtered.length;
  });

  return {
    todoList,
    isLoading,
    doneCount,
    fetchTodoList,
    addTodo,
    deleteTodo,
    updateTodo,
    toggleDone,
  };
});

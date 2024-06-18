import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';

export const useTodoListStore = defineStore('todoList', () => {
  const state = reactive({
    todoList: [
      {
        id: 1,
        todo: 'ES6학습',
        done: false,
      },
      {
        id: 2,
        todo: 'React학습',
        done: false,
      },
      {
        id: 3,
        todo: 'ContextAPI학습',
        done: false,
      },
      {
        id: 4,
        todo: '야구경기 관람',
        done: false,
      },
    ],
  });

  // 할일 추가
  const addTodo = (todo) => {
    state.todoList.push({
      id: new Date().getTime(),
      todo,
      done: false,
    });
  };

  // 할일 삭제
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };

  // 할일 완료 처리
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };

  // 완료된 할일 수
  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });

  // 리스트
  const todoList = computed(() => state.todoList);

  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});

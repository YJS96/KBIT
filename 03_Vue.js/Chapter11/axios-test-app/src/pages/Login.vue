<template>
  <main>
    <h1>Login</h1>
    아이디 : <input type="text" v-model.trim="userId" /><br />
    패스워드 : <input type="password" v-model.trim="userPassword" /><br />
    <button @click="login">로그인</button>&nbsp;
    <button @click="logOut">로그아웃</button>
  </main>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();

const userId = ref('');
const userPassword = ref('');

const login = async () => {
  try {
    const url = 'http://localhost:3000/users';
    const loginRes = await axios.get(url);
    const userArr = loginRes.data;

    const findedUser = userArr.find((item, index) => {
      return item.id === userId.value;
    });

    if (findedUser === undefined) {
      return alert('ID가진 사용자 없음');
    }

    if (findedUser.password !== userPassword.value) {
      return alert('비밀번호 틀림');
    }

    localStorage.setItem('auth', 'true');

    alert('로그인 성공');
    return router.push({ name: 'todo' });
  } catch (err) {
    alert('ERR');
    console.log(err);
  }
};

// router.beforeEach((to, from, next) => {
//   if (to.matched.some((record) => record.meta.requiresAuth)) {
//     if (localStorage.getItem('auth') !== 'true') {
//       alert('로그인이 필요합니다');
//       next({ name: 'Login' });
//     } else {
//       next();
//     }
//   } else {
//     next();
//   }
// });

const logOut = () => {
  localStorage.removeItem('auth');
};
</script>

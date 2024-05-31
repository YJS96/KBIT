<template>
  <div>
    <nav>
      <router-link to="/">홈페이지</router-link>
      &nbsp;
      <router-link to="/about">라우터란?</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<style scoped></style>

<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <RouterLink to="/">Home</RouterLink>&nbsp; <RouterLink to="/login">Login</RouterLink>&nbsp;
  <RouterLink to="/todo">Todo</RouterLink>

  <RouterView />
</template>

<style scoped></style>

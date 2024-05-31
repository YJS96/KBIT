<template>
  <div>{{ drilling }}</div>
  <div>{{ fly }}</div>
</template>

<script>
export default {
  name: 'GrandChild',
  props: ['drilling'],
  inject: ['fly'],
};
</script>

<style></style>

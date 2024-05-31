<template>
  <div>
    <h2>{{ todo }}</h2>
  </div>
</template>

<script>
export default {
  name: 'TodoProps',
  props: ['todo'],
};
</script>
<style scoped></style>

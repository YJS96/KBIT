<template>
  <div>
    <input type="text" v-model.trim="color" />
    <button @click="$emit('colorChanged', { color })">색상 전달</button>
    <div></div>
  </div>
</template>

<script>
export default {
  name: 'ColorEmit',
  data() {
    return {
      color: '',
    };
  },
};
</script>

<style></style>

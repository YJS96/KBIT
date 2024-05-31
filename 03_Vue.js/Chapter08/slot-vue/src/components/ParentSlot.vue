<template>
  <div>
    <ChildSlot>
      <h1>테스트</h1>
      <img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" alt="">
    </ChildSlot>
  </div>
</template>

<script>
import ChildSlot from './ChildSlot.vue';

export default {
  name: 'ParentSlot',
  components: {
    ChildSlot,
  },
};
</script>

<style></style>

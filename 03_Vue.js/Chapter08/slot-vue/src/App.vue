<template>
  <div>
    <!-- <ParentFancyPhotoBoxVue /> -->
    <ParentScopedSlotVue />
  </div>
</template>

<script>
// import ParentFancyPhotoBoxVue from './components/ParentFancyPhotoBox.vue';
import ParentScopedSlotVue from './components/ParentScopedSlot.vue';

export default {
  components: {
    // ParentFancyPhotoBoxVue,
    ParentScopedSlotVue,
  },
};
</script>

<style></style>

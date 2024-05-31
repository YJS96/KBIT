<template>
  <div>
    <ChildScopedSlotVue v-slot:default="fromChild">
      <div>{{ fromChild.msg }}</div>
    </ChildScopedSlotVue>
  </div>
</template>

<script>
import ChildScopedSlotVue from './ChildScopedSlot.vue';

export default {
  name: 'ParentScopedSlot',
  components: {
    ChildScopedSlotVue,
  },
};
</script>

<style></style>

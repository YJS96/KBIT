<template>
  <div class="card card-body">
    <h2>Members</h2>
    <p>{{ currentRoute.fullPath }}</p>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';

export default {
  name: 'Members',
  setup() {
    const currentRoute = useRoute();
    return { currentRoute };
  },
};
</script>

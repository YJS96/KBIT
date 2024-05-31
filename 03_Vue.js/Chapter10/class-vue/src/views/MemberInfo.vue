<template>
  <div class="card card-body">
    <h2>MemberInfo</h2>
    <div>경로 패턴: /members/:id</div>
    <!-- <div>요청 경로: {{ currentRoute.path }}</div> -->
    <div>id값: {{ member }}</div>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';

import membersJSON from '@/assets/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();

    const id = parseInt(currentRoute.params.id, 10);
    const member = membersJSON.find((m) => m.id === id);

    return { member };
  },
};
</script>

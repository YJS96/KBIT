import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import About from '@/views/About.vue';
import Members from '@/views/Members.vue';
import MemberInfo from '@/views/MemberInfo.vue';
import Videos from '@/views/Videos.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/about',
      name: 'About',
      component: About,
    },
    {
      path: '/members',
      name: 'Members',
      component: Members,
    },
    {
      path: '/members/:id',
      name: 'MemberInfo',
      component: MemberInfo,
    },
    {
      path: '/videos',
      name: 'Videos',
      component: Videos,
    },
  ],
});

export default router;

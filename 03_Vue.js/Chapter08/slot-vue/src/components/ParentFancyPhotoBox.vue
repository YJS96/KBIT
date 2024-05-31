<template>
  <FancyPhotoBoxVue>
    <template #photo>
      <img
        src="https://blog.kakaocdn.net/dn/uc7tM/btsuGm6Pkwv/JvkOr8SmeZCp6vS58Zu0NK/img.jpg"
        alt="마멋"
      />
    </template>
    <template #title>
      <div>지겨운 장동민 마멋</div>
    </template>
  </FancyPhotoBoxVue>
</template>

<script>
import FancyPhotoBoxVue from './FancyPhotoBox.vue';

export default {
  components: {
    FancyPhotoBoxVue,
  },
};
</script>

<style></style>

<template>
  <div class="main">
    <button @click="showModal">모달 열기</button>
    <ModalComponent :visible="isModalVisible" @close-modal="hideModal">
      <h1>잘 내려가니</h1>
    </ModalComponent>
    <!-- <VueCounter />
    <PropsChild :msg="msg" />
    <EmitChild @send-msg="emitHandler" /> -->
    <!-- <h1>{{ resultMsg }}</h1>
    <PropsEmitChildComponent :parentNum="parentNum" @send-result="resultHandler" /> -->
  </div>
</template>

<script setup>
import { ref } from 'vue';

import ModalComponent from './components/ModalComponent.vue';

const isModalVisible = ref(false);

const showModal = () => {
  isModalVisible.value = true;
};

const hideModal = () => {
  isModalVisible.value = false;
};

// import VueCounter from './components/VueCounter.vue';
// import PropsChild from './components/PropsChild.vue';
// import EmitChild from './components/EmitChild.vue';
// import PropsEmitChildComponent from './components/PropsEmitChildComponent.vue';

// const msg = ref('자식이 바꿀 메시지');

// const emitHandler = (value) => {
//   msg.value = value;
// };

// const resultMsg = ref('랜덤 숫자를 맞춰 주세요');
// const parentNum = ref(parseInt(Math.random() * 20));

// const resultHandler = (value) => {
//   resultMsg.value = value;
// };
</script>

<style scoped>
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>

<template>
  <header>
    <nav>
      <button
        @click="$emit('change-component', 'todo')"
        :class="{ active: currentComponent === 'todo' }"
      >
        Todo
      </button>
      <button
        @click="$emit('change-component', 'weather')"
        :class="{ active: currentComponent === 'weather' }"
      >
        Weather
      </button>
      <button
        @click="$emit('change-component', 'forecast')"
        :class="{ active: currentComponent === 'forecast' }"
      >
        Forecast
      </button>
    </nav>
  </header>
</template>

<script setup>
defineProps({
  currentComponent: {
    type: String,
    required: true,
  },
});
</script>

<style scoped>
header {
  background-color: #4a4a4a;
  padding: 1rem;
}

nav {
  display: flex;
  justify-content: center;
}

button {
  background: none;
  border: none;
  color: white;
  cursor: pointer;
  font-size: 1.2rem;
  margin: 0 1rem;
  padding: 0.5rem 1rem;
  transition: all 0.3s ease;
  position: relative;
  overflow: hidden;
}

button::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 0;
  background-color: rgba(255, 255, 255, 0.1);
  transition: height 0.3s ease;
}

button:hover::after,
button.active::after {
  height: 100%;
}

button.active {
  font-weight: bold;
}

button.active::before {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: white;
}

button span {
  position: relative;
  z-index: 1;
}
</style>

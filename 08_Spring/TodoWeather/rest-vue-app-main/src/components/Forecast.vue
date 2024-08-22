<template>
  <div class="forecast-container">
    <h2 class="forecast-title">도시 별 5일 예보</h2>
    <div class="city-select-container">
      <select
        v-model="selectedCity"
        @change="fetchWeatherData"
        class="city-select"
      >
        <optgroup label="한국">
          <option value="seoul" selected>서울</option>
          <option value="busan">부산</option>
          <option value="incheon">인천</option>
          <option value="daegu">대구</option>
          <option value="daejeon">대전</option>
          <option value="gwangju">광주</option>
        </optgroup>
        <optgroup label="아시아">
          <option value="tokyo">도쿄</option>
          <option value="beijing">베이징</option>
          <option value="bangkok">방콕</option>
          <option value="singapore">싱가포르</option>
        </optgroup>
        <optgroup label="유럽">
          <option value="london">런던</option>
          <option value="paris">파리</option>
          <option value="rome">로마</option>
          <option value="berlin">베를린</option>
        </optgroup>
        <optgroup label="북미">
          <option value="New York">뉴욕</option>
          <option value="Los Angeles">로스앤젤레스</option>
          <option value="chicago">시카고</option>
          <option value="toronto">토론토</option>
        </optgroup>
        <optgroup label="남미">
          <option value="Sao Paulo">상파울루</option>
          <option value="Buenos Aires">부에노스아이레스</option>
        </optgroup>
        <optgroup label="오세아니아">
          <option value="sydney">시드니</option>
          <option value="auckland">오클랜드</option>
        </optgroup>
      </select>
    </div>

    <div v-if="loading" class="loading">Loading...</div>
    <div v-else-if="error" class="error">{{ error }}</div>
    <div v-else-if="dailyForecasts.length" class="forecast-list">
      <div
        v-for="forecast in dailyForecasts"
        :key="forecast.dt"
        class="forecast-item"
      >
        <p class="forecast-day">{{ getDayOfWeek(forecast.dt) }}</p>
        <img
          :src="`http://openweathermap.org/img/wn/${forecast.weather[0].icon}@2x.png`"
          :alt="forecast.weather[0].description"
          class="forecast-icon"
        />
        <p class="forecast-description">
          {{ forecast.weather[0].description }}
        </p>
        <p class="forecast-temp">{{ Math.round(forecast.main.temp) }}°C</p>
      </div>
    </div>
    <div v-else class="no-data">데이터 받기 실패</div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import axios from 'axios';

const forecastData = ref(null);
const loading = ref(true);
const error = ref(null);
const cityName = ref('');
const selectedCity = ref('seoul');
const baseUri = 'http://localhost:8080/weather/forecast/';

const getDayOfWeek = (timestamp) => {
  const days = ['일', '월', '화', '수', '목', '금', '토'];
  const date = new Date(timestamp * 1000);
  return days[date.getDay()];
};

const dailyForecasts = computed(() => {
  if (!forecastData.value || !forecastData.value.list) return [];
  const forecasts = {};
  forecastData.value.list.forEach((forecast) => {
    const date = new Date(forecast.dt * 1000).toDateString();
    if (!forecasts[date]) {
      forecasts[date] = forecast;
    }
  });
  return Object.values(forecasts);
});

const fetchWeatherData = async () => {
  try {
    loading.value = true;
    error.value = null;
    const encodedCity = encodeURIComponent(selectedCity.value);
    console.log('encodedCity', encodedCity);
    const response = await axios.get(baseUri + encodedCity);
    forecastData.value = response.data;
    cityName.value = response.data.city.name;
  } catch (e) {
    console.error('데이터 로딩 실패:', e);
    error.value = '날씨 데이터를 가져오는데 실패했습니다. 다시 시도해 주세요.';
  } finally {
    loading.value = false;
  }
};

onMounted(fetchWeatherData);
</script>

<style scoped>
.forecast-container {
  font-family: Arial, sans-serif;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.forecast-title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center;
  color: white;
}

.city-select {
  display: block;
  width: 200px;
  margin: 0 auto 20px;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.forecast-list {
  display: flex;
  justify-content: flex-start;
  flex-wrap: wrap;
  gap: 10px;
}

.forecast-item {
  flex-basis: calc(20% - 10px);
  background-color: #f0f0f0;
  border-radius: 10px;
  padding: 15px;
  margin-bottom: 10px;
  text-align: center;
}

.forecast-day {
  font-weight: bold;
  margin-bottom: 10px;
}

.forecast-icon {
  width: 50px;
  height: 50px;
  margin: 0 auto;
}

.forecast-description {
  margin: 10px 0;
}

.forecast-temp {
  font-size: 18px;
  font-weight: bold;
}

.loading,
.error,
.no-data {
  text-align: center;
  margin-top: 20px;
}

.error {
  color: red;
}
</style>

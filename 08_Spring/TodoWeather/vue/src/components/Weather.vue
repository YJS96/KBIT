<template>
  <div class="weather-display">
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

    <div v-if="weatherData" class="weather-content">
      <h2>{{ weatherData.name }} 날씨</h2>
      <div class="weather-main">
        <img
          :src="`http://openweathermap.org/img/wn/${weatherData.weather[0].icon}@2x.png`"
          :alt="weatherData.weather[0].description"
        />
        <p class="temperature">{{ weatherData.main.temp }}°C</p>
        <p class="description">{{ weatherData.weather[0].description }}</p>
      </div>
      <div class="weather-details">
        <div class="detail-item">
          <span class="detail-label">체감 온도:</span>
          <span class="detail-value">{{ weatherData.main.feelsLike }}°C</span>
        </div>
        <div class="detail-item">
          <span class="detail-label">습도:</span>
          <span class="detail-value">{{ weatherData.main.humidity }}%</span>
        </div>
        <div class="detail-item">
          <span class="detail-label">기압:</span>
          <span class="detail-value">{{ weatherData.main.pressure }} hPa</span>
        </div>
        <div class="detail-item">
          <span class="detail-label">가시거리:</span>
          <span class="detail-value"
            >{{ weatherData.visibility / 1000 }} km</span
          >
        </div>
        <div class="detail-item">
          <span class="detail-label">풍속:</span>
          <span class="detail-value">{{ weatherData.wind.speed }} m/s</span>
        </div>
        <div class="detail-item">
          <span class="detail-label">풍향:</span>
          <span class="detail-value">{{ weatherData.wind.deg }}°</span>
        </div>
        <div class="detail-item">
          <span class="detail-label">구름:</span>
          <span class="detail-value">{{ weatherData.clouds.all }}%</span>
        </div>
      </div>
      <div class="sun-times">
        <div class="sun-item">
          <span class="sun-label">일출:</span>
          <span class="sun-value">{{
            formatTime(weatherData.sys.sunrise)
          }}</span>
        </div>
        <div class="sun-item">
          <span class="sun-label">일몰:</span>
          <span class="sun-value">{{
            formatTime(weatherData.sys.sunset)
          }}</span>
        </div>
      </div>
      <p class="update-time">
        마지막 업데이트: {{ formatTime(weatherData.dt) }}
      </p>
    </div>
    <div v-else-if="error" class="error-message">
      {{ error }}
    </div>
    <div v-else class="loading">날씨 정보를 불러오는 중...</div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue';
import axios from 'axios';

const baseUri = 'http://localhost:8080/weather/';
const weatherData = ref(null);
const error = ref(null);
const selectedCity = ref('seoul');

const fetchWeatherData = async () => {
  weatherData.value = null;
  error.value = null;
  try {
    const encodedCity = encodeURIComponent(selectedCity.value);
    const response = await axios.get(baseUri + encodedCity);
    weatherData.value = response.data;
  } catch (err) {
    error.value =
      '날씨 정보를 불러오는 데 실패했습니다. 잠시 후 다시 시도해 주세요.';
    console.error('Error fetching weather data:', err);
  }
};

const formatTime = (timestamp) => {
  const date = new Date(timestamp * 1000);
  return date.toLocaleTimeString('ko-KR');
};

onMounted(fetchWeatherData);

watch(selectedCity, fetchWeatherData);
</script>

<style scoped>
.weather-display {
  font-family: 'Arial', sans-serif;
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 12px;
  background-color: #66b2f5;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.city-select-container {
  margin-bottom: 20px;
}

.city-select {
  width: 100%;
  padding: 10px;
  border: 1px solid #b0e0e6;
  border-radius: 6px;
  font-size: 16px;
  background-color: #ffffff;
  color: #000;
}

h2 {
  color: #4682b4;
  margin-bottom: 20px;
}

.weather-main {
  background-color: #ffffff;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.weather-content > h2 {
  color: #000;
}

.weather-content > h2 {
  color: #000;
}

.temperature {
  font-size: 3em;
  font-weight: bold;
  color: #000;
  margin: 10px 0;
}

.description {
  font-style: italic;
  color: #000;
}

.weather-details,
.sun-times {
  background-color: #ffffff;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.detail-item,
.sun-item {
  display: flex;
  justify-content: space-between;
  margin: 10px 0;
}

.detail-label,
.sun-label {
  color: #000;
}

.detail-value,
.sun-value {
  font-weight: bold;
  color: #000;
}

.update-time {
  font-size: 0.9em;
  color: #000;
}

.error-message {
  color: #dc143c;
  background-color: #ffe4e1;
  border-radius: 6px;
  padding: 10px;
}

.loading {
  color: #4682b4;
  font-style: italic;
}

@media (max-width: 480px) {
  .weather-display {
    max-width: 100%;
    border-radius: 0;
  }
}
</style>

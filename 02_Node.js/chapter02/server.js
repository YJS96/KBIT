const express = require('express');
const cors = require('cors');

const PORT = 4000;
const app = express();
app.use(cors());

app.get('/request', (req, res) => {
  res.status(200).json('안녕하세요. 여기는 백엔드입니다!');
});

app.get('/error', (req, res) => {
  res.status(500).json('에러');
});

app.listen(PORT, () => {
  console.log(`데이터 통신 서버가 ${PORT}번에서 작동 중`);
});

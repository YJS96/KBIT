<template>
  <div class="card-frame">
    <div class="image-frame">
      <slot name="photo"></slot>
    </div>
    <div class="title">
      <slot name="title"></slot>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@font-face {
  font-family: 'Pretendard';
  src: url('https://fastly.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
    format('woff');
  font-weight: 400;
  font-style: normal;
}

.card-frame {
  position: relative;
  margin: 0 auto;
  width: 36%;
  padding: 24px;
  border-radius: 16px;
  box-shadow: 2px 2px 10px 0px rgba(44, 85, 124, 0.04), 2px 2px 30px 0px rgba(0, 0, 0, 0.16);
}

.image-frame {
  position: relative;
  width: 100%;
  aspect-ratio: 1/ 1;
  object-fit: contain;
  object-position: center;
  overflow: hidden;
}

.image {
  position: relative;
  width: 100%;
}

.title {
  margin-top: 20px;
  font-size: 24px;
  font-weight: 600;
  font-family: Pretendard !important;
}
</style>

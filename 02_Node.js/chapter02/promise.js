const promise = new Promise((resolve, reject) => {
  console.log('프로미스 시작!');
  setTimeout(() => {
    console.log('setTimeout 끝!');
    resolve('프로미스 비동기 구현 성공!');
  }, 2000);
});

// console.log(promise);

const asyncFunc = async () => {
  const data = await promise;
  console.log(data);
};
asyncFunc();

// promise.then((data) => {
//   console.log(data);
// });

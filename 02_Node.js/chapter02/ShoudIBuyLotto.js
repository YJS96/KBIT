// const shoudIBuyLotto = new Promise((res, err) => {
//   console.log('나 로또 사도 될까!?');
//   setTimeout(() => {
//     const rand = parseInt(Math.random() * 10);
//     console.log(`나온 숫자는 ${rand}`);

//     if (rand >= 5) {
//       res('아싸! 로또 사자!');
//     } else {
//       err('아... 망했어요');
//     }
//   }, 3000);
// })
//   .then((res) => {
//     showResult(res);
//   })
//   .catch((err) => {
//     showResult(err);
//   });

// const showResult = (msg) => {
//   console.log(msg);
// };

const shoudIBuyLotto = new Promise((res, err) => {
  console.log('나 로또 사도 될까!?');
  setTimeout(() => {
    const rand = parseInt(Math.random() * 10);
    console.log(`나온 숫자는 ${rand}`);

    if (rand >= 5) {
      res('아싸! 로또 사자!');
    } else {
      err('아... 망했어요');
    }
  }, 3000);
});

const lottoAsnycAwait = async () => {
  try {
    const res = await shoudIBuyLotto;
    console.log(res);
  } catch (err) {
    console.log(err);
  }
};

const showResult = (msg) => {
  console.log(msg);
};

lottoAsnycAwait();

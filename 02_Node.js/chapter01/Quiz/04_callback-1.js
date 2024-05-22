const order = (coffee, callback) => {
  console.log(coffee + ' 주문 접수');
  setTimeout(() => {
    callback(coffee);
  }, 1000 * 3);
};

const display = (coffee) => {
  console.log(coffee + ' 완료!');
};

order('아메리카노', display);

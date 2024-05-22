let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  inner();
};

obj.add(3, 4);

// { result: 0, add: [Function (anonymous)] }
console.log(obj);

// 7
console.log(result);

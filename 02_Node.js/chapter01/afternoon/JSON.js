const yjsObj = {
  name: '임준수',
  hobbies: ['a', 'b', 'c'],
};

console.log(yjsObj);
const strYjsObj = JSON.stringify(yjsObj);
console.log(strYjsObj);
console.log(typeof yjsObj, typeof strYjsObj);
console.log(yjsObj.name);
console.log(strYjsObj.name);

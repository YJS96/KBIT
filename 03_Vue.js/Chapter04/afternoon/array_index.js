const aClassArr = [
  { id: 1, name: '이효석' },
  { id: 2, name: '임준수' },
];

// const findIndex = (arr, name) => {
//   let result = -1;
//   for (let i = 0; i < arr.length; i++) {
//     if (arr[i].name == name) {
//       result = i;
//       break;
//     }
//   }
//   return result;
// };

// console.log(findIndex(aClassArr, '홍길동'));
// console.log(findIndex(aClassArr, '이효석'));
// console.log(findIndex(aClassArr, '임준수'));

let a = -1;

a = aClassArr.findIndex((item) => {
  return item.name === '홍길동';
});

a = aClassArr.findIndex((item) => item.name === '임준수');

console.log(a);

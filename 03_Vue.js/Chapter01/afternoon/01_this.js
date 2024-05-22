// const jsObj = {
//   name: '임준수',
//   sayHello: () => {
//     console.log(this.name);
//   },
//   nestedObj: {
//     name2: '임준수2',
//     sayHello: () => {
//       console.log(jsObj.nestedObj.name2);
//       console.log(this.name2);
//     },
//   },
// };

// const jsObj = {
//   name: '임준수',
//   isOld: true,
// };

// const getKeyValue = (obj, key) => {
//   console.log(obj[key]);
// };

// getKeyValue(jsObj, 'name');

// const jsObj = {
//   name: '임준수',
//   isOld: true,
//   condition: 'good',
// };

// for (let key in jsObj) {
//   console.log(key);
//   console.log(jsObj[key]);
// }

let student = {};
student.이름 = '홍길동';
student.취미 = '악기';

// student.toString = () => {
//   for (let key in this) {
//     if (key != 'toString') {
//       console.log(key + '\t' + this[key]);
//     }
//   }
// };

for (let key in student) {
  if (key != 'toString') {
    console.log(key + '\t' + student[key]);
  }
}

console.log(student.toString);

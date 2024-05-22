function displayA() {
  console.log('A');
}

function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 1000 * 2);

}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);

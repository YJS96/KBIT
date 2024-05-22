let msg = 'GLOBAL';
const outer = () => {
  let msg = 'OUTER';
  console.log(msg);
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
};

outer();

// OUTPUT
// OUTER
// BLOCK

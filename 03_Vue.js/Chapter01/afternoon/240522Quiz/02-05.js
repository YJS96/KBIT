const addContact = (name, mobile, home, address, email) => {
  this.name = name;
  this.mobile = mobile;
  this.home = home;
  this.address = address;
  this.email = email;

  let str = '';

  for (val in this) {
    if (!this[val]) {
      this[val] = '없음';
    }
    str += `${val}=${this[val]}, `;
  }

  console.log(str);
};

addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');

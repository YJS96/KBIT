const animals = ['dog', 'cat'];

const showAnimals = () => {
  animals.map((animal) => {
    console.log(animal);
  });
};

module.exports = { animals, showAnimals };

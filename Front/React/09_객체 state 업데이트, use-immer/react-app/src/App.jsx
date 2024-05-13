import { useState } from 'react';
import { useImmer } from 'use-immer';
import './App.css';

export default function Form() {
  const [person, setPerson] = useImmer({
    name: 'Niki de Saint Phalle',
    artwork: {
      title: 'Blue Nana',
      city: 'Hamburg',
      image: 'https://i.imgur.com/Sd1AgUOm.jpg',
    },
  });

  function handleNameChange(event) {
    setPerson((draft) => {
      draft.name = event.target.value;
    });
  }

  function handleTitleChange(event) {
    setPerson((draft) => {
      draft.artwork.title = event.target.value;
    });
  }

  function handleCityChange(event) {
    setPerson((draft) => {
      draft.artwork.city = event.target.value;
    });
  }

  function handleImageChange(event) {
    setPerson((draft) => {
      draft.artwork.image = event.target.value;
    });
  }

  return (
    <>
      <div>
        <label htmlFor="input1">
          Name
          <input type="text" value={person.name} onChange={handleNameChange} />
        </label>
      </div>
      <div>
        <label htmlFor="input2">
          Title
          <input
            type="text"
            value={person.artwork.title}
            onChange={handleTitleChange}
          />
        </label>
      </div>
      <div>
        <label htmlFor="input3">
          City
          <input
            type="text"
            value={person.artwork.city}
            onChange={handleCityChange}
          />
        </label>
      </div>
      <div>
        <label htmlFor="input4">
          Image
          <input
            type="text"
            value={person.artwork.image}
            onChange={handleImageChange}
          />
        </label>
      </div>
      <p>
        <i>{person.artwork.title}</i>
        {' by '}
        {person.name}
        <br />
        (located in {person.artwork.city})
      </p>
      <img src={person.artwork.image} alt={person.artwork.title} />
    </>
  );
}

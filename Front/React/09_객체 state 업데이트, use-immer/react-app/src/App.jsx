import { useState } from 'react';
import './App.css';

export default function Form() {
  const [person, setPerson] = useState({
    firstName: 'Minchan',
    lastName: 'Hepworth',
    email: 'bhepworth@sculpture.com',
  });

  function handleChange(event) {
    setPerson({
      ...person,
      [event.target.id]: event.target.value,
    });
  }

  return (
    <>
      <div>
        <label htmlFor="first">First name:</label>
        <input
          type="text"
          value={person.firstName}
          onChange={handleChange}
          id="firstName"
        />
      </div>
      <div>
        <label htmlFor="last">last name:</label>
        <input
          type="text"
          value={person.lastName}
          onChange={handleChange}
          id="lastName"
        />
      </div>
      <div>
        <label htmlFor="email">Email:</label>
        <input
          type="text"
          value={person.email}
          onChange={handleChange}
          id="email"
        />
      </div>
      <p>{person.firstName}</p>
      <p>{person.lastName}</p>
      <p>{person.email}</p>
    </>
  );
}

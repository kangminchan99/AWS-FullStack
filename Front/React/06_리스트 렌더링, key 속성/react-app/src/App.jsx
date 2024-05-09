import './App.css';
import { people } from './data';
// import { getImageUrl } from './utils';
import { Fragment } from 'react';

export default function List() {
  // const listItems = people.map((person) => <li key={person}>{person}</li>);

  // const cheme = people.filter((person) => person.profession == '화학자');

  return (
    <div className="list">
      {people.map((person) => (
        <Fragment key={person.id}>
          <h2>{person.name}</h2>
          <p>{person.profession}</p>
        </Fragment>
      ))}
    </div>
  );
}

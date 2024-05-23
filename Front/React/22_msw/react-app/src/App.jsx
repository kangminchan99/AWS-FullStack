import { useEffect, useState, useRef } from 'react';

export default function App() {
  const [peopleData, setPeopleData] = useState([]);
  const idRef = useRef(3);

  idRef.current++;

  let ignore = false;

  useEffect(() => {
    // async function fetchData() {
    //   try {
    //     const response = await fetch('/people');
    //     const data = await response.json();
    //     setPeopleData(data);
    //   } catch (error) {
    //     console.error(error);
    //   }
    // }
    // fetchData();

    async function createData() {
      try {
        if (!ignore) {
          const response = await fetch('/people', {
            method: 'POST',
            body: JSON.stringify({
              id: idRef.current,
              name: 'son',
              country: 'asia',
              lang: 'php',
            }),
          });
          const data = await response.json();
          setPeopleData(data);
        }
      } catch (error) {
        console.error(error);
      }
    }
    createData();

    return () => {
      ignore = true;
    };
  }, []);

  return (
    <div>
      {peopleData?.length > 0 ? (
        peopleData.map((item) => (
          <div key={item.id}>
            <p>이름 : {item.name}</p>
            <p>나라 : {item.country}</p>
            <p>언어 : {item.lang}</p>
          </div>
        ))
      ) : (
        <p>...로딩중</p>
      )}
    </div>
  );
}

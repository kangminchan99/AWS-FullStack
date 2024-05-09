import './App.css';

function Item({ name, isPacked }) {
  // 조건부 렌더링
  // if (isPacked) {
  //   return '';
  // }
  // return <li className="item">{name}</li>;
  return (
    <li className={`item ${isPacked ? 'checked' : ''} `}>
      {name} {isPacked ? '(완료)' : 'X'}
    </li>
  );
}

export default function PackingList() {
  return (
    <section className="packing_list">
      <h1>준비물</h1>
      <ul>
        <Item isPacked={true} name="우주복" />
        <Item isPacked={true} name="헬멧" />
        <Item isPacked={false} name="가족사진" />
      </ul>
    </section>
  );
}

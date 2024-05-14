import { useState } from 'react';

const menus = ['클래식', '프레쉬&라이트', '프리미엄', '아침메뉴'];

export default function TabMenu() {
  const [activeIndex, setActiveIndex] = useState(0);

  return (
    <ul className="tab_menu">
      {menus.map((menu, index) => (
        <li
          key={menu}
          className={index === activeIndex ? 'active' : ''}
          onClick={() => setActiveIndex(index)}
        >
          <a href="#">{menu}</a>
        </li>
      ))}
    </ul>
  );
}

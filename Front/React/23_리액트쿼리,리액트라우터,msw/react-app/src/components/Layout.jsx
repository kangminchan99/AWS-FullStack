// 자식 라우트
import { Outlet } from 'react-router-dom';
import Header from './Header';

export default function Layout() {
  return (
    <div className="wrap">
      <Header />
      <main className="container">
        <Outlet />
      </main>
    </div>
  );
}

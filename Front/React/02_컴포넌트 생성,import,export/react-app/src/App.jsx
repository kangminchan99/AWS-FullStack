import Gallery from './components/Gallery';
import Profile from './components/Profile';
import logo from './assets/react.svg';

export default function App() {
  return (
    <>
      <Gallery />
      <Profile />
      <Profile />
      <Profile />
      <img src={logo} alt="logo" />
    </>
  );
}

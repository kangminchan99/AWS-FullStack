import './App.css';
import { useOnlineStatus } from './hooks/useOnlineStatus';

function OnlineStatue() {
  const isOnline = useOnlineStatus();

  return <h2>{isOnline ? 'online' : 'offline'}</h2>;
}

function SaveButton() {
  const isOnline = useOnlineStatus();

  function handleClickBtn() {
    console.log('load....');
  }

  return (
    <button type="btn" disabled={!isOnline} onClick={handleClickBtn}>
      {isOnline ? 'load...' : 're connect......'}
    </button>
  );
}

export default function App() {
  return (
    <>
      <OnlineStatue></OnlineStatue>
      <SaveButton></SaveButton>
    </>
  );
}

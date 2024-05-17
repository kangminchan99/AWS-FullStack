import { useOnlineStatus } from '../hooks/useOnlineStatus';
import Styles from './SaveButton.module.css';

export default function SaveButton() {
  const isOnline = useOnlineStatus();

  function handleClickBtn() {
    console.log('load....');
  }

  return (
    <div className={Styles.save_button}>
      <button type="button" disabled={!isOnline} onClick={handleClickBtn}>
        {isOnline ? 'load...' : 're connect......'}
      </button>
      <p className="txt">진행사항이 저장중입니다.</p>
    </div>
  );
}

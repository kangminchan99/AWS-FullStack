import { useOnlineStatus } from '../hooks/useOnlineStatus';
import styles from './StatusBar.module.css';

export default function StatusBar() {
  const isOnline = useOnlineStatus();

  return <h2 className={styles.tit}>{isOnline ? 'online' : 'offline'}</h2>;
}

import './App.css';

export default function BgSwitch() {
  function SwitchBg() {
    const bodySt = document.body.style;

    if (bodySt.backgroundColor !== 'black') {
      bodySt.backgroundColor = 'black';
    } else {
      bodySt.backgroundColor = 'red';
    }
  }
  return (
    <button type="submit" onClick={SwitchBg}>
      Switch Bg
    </button>
  );
}

import { useState, useRef } from 'react';
import './App.css';
import Checkbox from './components/Checkbox';
import Radio from './components/Radio';

export default function VideoPlayer() {
  const [isPlaying, setIsPlaying] = useState(false);
  const videoRef = useRef(null);

  function handleClick() {
    setIsPlaying(!isPlaying);
    if (!isPlaying) {
      videoRef.current.play();
    } else {
      videoRef.current.pause();
    }
  }

  return (
    <div className="app">
      <button type="button" onClick={handleClick}>
        {isPlaying ? 'Pause' : 'Play'}
      </button>
      <video
        ref={videoRef}
        width="250"
        src="https://interactive-examples.mdn.mozilla.net/media/cc0-videos/flower.mp4"
      ></video>
      <div>
        <Checkbox checked={true}>
          <span>동의합니다.</span>
        </Checkbox>
        <Checkbox>
          <span>수락합니다.</span>
        </Checkbox>
        <Radio checked={true} group={'selectGroup'}>
          <span>선택1</span>
        </Radio>
        <Radio group={'selectGroup'}>
          <span>선택2</span>
        </Radio>
        <Radio group={'selectGroup'}>
          <span>선택3</span>
        </Radio>
        <Radio checked={true} group={'subject'}>
          <span>국어</span>
        </Radio>
        <Radio group={'subject'}>
          <span>영어</span>
        </Radio>
        <Radio group={'subject'}>
          <span>수학</span>
        </Radio>
      </div>
    </div>
  );
}

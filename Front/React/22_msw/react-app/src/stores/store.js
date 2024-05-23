import { useState } from 'react';
import { create } from 'zustand';

const useStore = create((set) => ({
  // 전역상태
  bears: 0,
  increasePopulation: function () {
    // set함수안에서 콜백함수을 사용하여 이전 상태를 받아 새로운 객체로 업데이트
    set((state) => ({ bears: state.bears + 1 }));
  },
  removeAllBears: function () {
    set({ bears: 0 });
  },
}));

export default useStore;

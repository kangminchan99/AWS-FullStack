// 외부에서 사용해야 하므로 export만 적는다.
export type Todo = {
  id: number;
  text: string;
  done: boolean;
  // [] - 객체가 있는 배열
}[];

// 숫자 배열
export type NumType = number[];

// 숫자가 있는 이중배열
export type TestType = number[][];

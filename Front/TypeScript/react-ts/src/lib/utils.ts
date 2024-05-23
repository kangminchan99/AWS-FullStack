// 제네릭 타입 매개변수<T>: 함수의 인자를 유연하게 사용 가능
// export function printArray<T>(arr: T[]): void {
//   // for - of : continue, break 사용 가능
//   for (const item of arr) {
//     console.log(item);
//   }
// }

// 배열 요소 타입을 string 또는 number만 가능하도록
export function printArray<T extends string | number>(arr: T[]): void {
  // for - of : continue, break 사용 가능
  for (const item of arr) {
    console.log(item);
  }
}

// 특정 객체의 키만 사용가능 하도록
export function getValue<T, K extends keyof T>(obj: T, key: K) {
  return obj[key];
}

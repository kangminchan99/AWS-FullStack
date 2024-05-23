import { http, HttpResponse } from 'msw';
// 배열데이터 가져오기
import people from './dummy.json';
import product from './product.json';

// 서버로 요청이 들어왔을때 실행될 http메서드(요청핸들러)
// http.get(): 서버 데이터 가져오기(Read)
// http.post(): 서버에 데이터 전송(Create)
export const handlers = [
  // '/people': 데이터 요청할 api 엔드포인트
  http.get('/people', async () => {
    await sleep(200);

    // 배열 데이터를 json으로 응답
    return HttpResponse.json(people);
  }),
  http.get('/people/:id', async ({ params }) => {
    await sleep(200);
    // url파라미터 구조분해
    const { id } = params;
    // 배열 데이터를 json으로 응답
    return HttpResponse.json(
      // id 파라미터가 문자이므로 숫자로 변환후 배열요소중 id와 동일한 요소찾기
      people.filter((person) => person.id === parseInt(id))
    );
  }),
  http.post('/people', async ({ request }) => {
    await sleep(200);
    // 요청객체중 요청 body로 넘어온 내용을 js 객체로 변환
    const item = await request.json();
    // 배열에 데이터 추가
    people.push(item);

    return HttpResponse.json(people);
  }),
  http.get('/product', async () => {
    await sleep(200);

    return HttpResponse.json(product);
  }),
];

// 데이터 전송시 시간이 걸리므로 지연시간 걸어 서버환경과 비슷하게 동작하게 하는 함수
async function sleep(timeout) {
  return new Promise((resolve) => {
    setTimeout(resolve, timeout);
  });
}

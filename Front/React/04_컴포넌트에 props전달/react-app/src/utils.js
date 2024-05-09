// 일반함수고 jsx를 리턴하는것이 아니면 default를 사용하지 않음

// export만 있는경우 - named export
export function getImageUrl(imageId, size = 's') {
  // js에서는 그냥 백틱 사용가능 jsx에선 불가
  return `https://i.imgur.com/${imageId}${size}.jpg`;
}

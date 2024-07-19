// 토큰을 sessionStorage에 저장하는 함수
function saveTokenToSessionStorage(token) {
  sessionStorage.setItem("accessToken", token);
}

// sessionStorage에서 토큰을 가져오는 함수
function getTokenFromSessionStorage() {
  return sessionStorage.getItem("accessToken");
}

// sessionStorage에서 토큰을 삭제하는 함수
function removeTokenFromSessionStorage() {
  sessionStorage.removeItem("accessToken");
}

// 페이지 로드 시 토큰이 없으면 게스트 토큰을 발급받는 함수
function initializeToken() {
  let token = getTokenFromSessionStorage();
  console.log("accessToken : " + token);
  if (!token) {
    fetch("http://localhost:10003/guest/token", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.text())
      .then((token) => {
        saveTokenToSessionStorage(token);
        setupAjaxHeaders(token);
      })
      .catch((error) => {
        console.error("Error fetching guest token:", error);
      });
  } else {
    setupAjaxHeaders(token);
  }
}

// 모든 AJAX 요청에 대해 기본 헤더 설정
function setupAjaxHeaders(token) {
  $.ajaxSetup({
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
}

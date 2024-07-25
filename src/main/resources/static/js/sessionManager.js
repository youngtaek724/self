function logout() {
  // 쿠키를 삭제하여 로그아웃
  document.cookie = "accessToken=;path=/;expires=Thu, 01 Jan 1970 00:00:00 GMT";

  // 로그인 페이지로 리다이렉트
  window.location.href = "/main/home";
}

function saveTokenToCookie(token) {
  document.cookie = `accessToken=${token};path=/;SameSite=Strict`;
}

function getTokenFromCookie() {
  const name = "accessToken=";
  const decodedCookie = decodeURIComponent(document.cookie);
  const ca = decodedCookie.split(";");
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) === " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) === 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

async function fetchData(url, callback) {
  fetch(url, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${getTokenFromCookie()}`,
    },
    credentials: "include",
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok " + response.statusText);
      }
      return response.json();
    })
    .then((data) => callback(data))
    .catch((error) => console.error("Error fetching data:", error));
}

async function initializeToken() {
  let token = getTokenFromCookie();

  if (!token) {
    try {
      const response = await fetch("http://localhost:10003/guest/token", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        credentials: "include",
      });

      const text = await response.text();
      token = text;
      saveTokenToCookie(token);
    } catch (error) {
      console.error("Error fetching guest token:", error);
    }
  }

  if (token) {
    updateUIBasedOnRole(token);
    setupAjaxHeaders(token);
  }
}

function decodeToken(token) {
  if (!token) return {};
  const parts = token.split(".");
  if (parts.length !== 3) {
    throw new Error("JWT malformed");
  }

  const payload = JSON.parse(atob(parts[1]));
  return payload;
}

function updateUIBasedOnRole(token) {
  const decodedToken = decodeToken(token);
  const roleType = decodedToken.role;

  if (roleType === "USER") {
    document.getElementById("gnb_login_button").style.display = "none";
    document.getElementById("gnb_logout_button").style.display = "block";
    document.getElementById("mypageInfoBtn").style.display = "block";
  } else if (roleType === "GUEST") {
    document.getElementById("gnb_login_button").style.display = "block";
    document.getElementById("gnb_logout_button").style.display = "none";
    document.getElementById("mypageInfoBtn").style.display = "none";
  }
}

function setupAjaxHeaders(token) {
  $.ajaxSetup({
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
}

function checkPageAccess(requiredRole) {
  const token = getTokenFromCookie();
  const role = decodeToken(token).role;
  if (role !== requiredRole) {
    window.location.href = "/unauthorized";
  }
}

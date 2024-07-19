// ********** 아이디 체크 **********
document.addEventListener("DOMContentLoaded", function () {
  //   var userIdInput = document.getElementById("userId");
  // //  var errorMessage = document.querySelector(".css-depv0x");
  //   var errorMessage = document.getElementById("userIdError");

  //   userIdInput.addEventListener("input", function () {
  //     var userId = userIdInput.value;
  //     var isValid = validateUserId(userId);

  //     if (!isValid) {
  //       errorMessage.style.display = "block";
  //       userIdInput.classList.remove("css-1sbrczv");
  //       userIdInput.classList.add("css-zf1cy7");
  //     } else {
  //       errorMessage.style.display = "none";
  //       userIdInput.classList.remove("css-zf1cy7");
  //       userIdInput.classList.add("css-1sbrczv");
  //     }
  //   });

  //   function validateUserId(userId) {
  //     var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,12}$/;
  //     return regex.test(userId);
  //   }

  var userIdInput = document.getElementById("userId");
  var userIdError = document.getElementById("userIdError");
  var duplicateCheckIdButton = document.querySelector(
    '[data-testid="Button-userId"]'
  );

  userIdInput.addEventListener("input", validateId);

  function validateId() {
    var userId = userIdInput.value;
    var isValid = validateUserId(userId);

    if (isValid) {
      userIdError.style.display = "none";
      userIdInput.classList.remove("css-zf1cy7");
      userIdInput.classList.add("css-1sbrczv");
      duplicateCheckIdButton.removeAttribute("disabled");
      duplicateCheckIdButton.style.pointerEvents = "auto";
    } else {
      userIdError.style.display = "block";
      userIdInput.classList.remove("css-1sbrczv");
      userIdInput.classList.add("css-zf1cy7");
      duplicateCheckIdButton.setAttribute("disabled", "");
      duplicateCheckIdButton.style.pointerEvents = "none";
    }
  }

  function validateUserId(userId) {
    var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,12}$/;
    return regex.test(userId);
  }

  duplicateCheckIdButton.setAttribute("disabled", "disabled");
  duplicateCheckIdButton.style.pointerEvents = "none";

  // ********** 비밀번호 체크 **********
  var passwordInput = document.getElementById("password");
  var passwordConfirmInput = document.getElementById("passwordConfirm");
  var passwordError = document.getElementById("passwordError");
  var passwordMismatchError = document.getElementById("passwordMismatchError");

  passwordInput.addEventListener("input", validatePassword);
  passwordConfirmInput.addEventListener("input", validatePassword);

  function validatePassword() {
    var password = passwordInput.value;
    var passwordConfirm = passwordConfirmInput.value;

    // 유효성 검사
    var isValid = checkPasswordStrength(password);

    // 일치 여부 확인
    var passwordsMatch = password === passwordConfirm;

    // 유효성 메시지 출력
    if (isValid) {
      passwordError.style.display = "none";
      passwordInput.classList.remove("css-zf1cy7");
      passwordInput.classList.add("css-1sbrczv");
    } else {
      passwordError.style.display = "block";
      passwordInput.classList.remove("css-1sbrczv");
      passwordInput.classList.add("css-zf1cy7");
    }

    // 일치 여부 메시지 출력
    if (passwordsMatch) {
      passwordMismatchError.style.display = "none";
      passwordConfirmInput.classList.remove("css-zf1cy7");
      passwordConfirmInput.classList.add("css-1sbrczv");
    } else {
      passwordMismatchError.style.display = "block";
      passwordConfirmInput.classList.remove("css-1sbrczv");
      passwordConfirmInput.classList.add("css-zf1cy7");
    }
  }

  // 정규식
  function checkPasswordStrength(password) {
    var regex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()\-_=+{};:,<.>]).{8,16}$/;
    return regex.test(password);
  }

  // ********** 이름 **********
  var usernameInput = document.getElementById("username");
  var usernameError = document.getElementById("usernameError");

  usernameInput.addEventListener("input", validateUsername);

  function validateUsername() {
    var username = usernameInput.value;
    var isValid = checkUsernameFormat(username);

    if (isValid) {
      usernameError.style.display = "none";
      usernameInput.classList.remove("css-zf1cy7");
      usernameInput.classList.add("css-1sbrczv");
    } else {
      usernameError.style.display = "block";
      usernameInput.classList.remove("css-1sbrczv");
      usernameInput.classList.add("css-zf1cy7");
    }
  }

  function checkUsernameFormat(username) {
    var regex = /^[가-힣]+$/;
    return regex.test(username);
  }

  // ********** 이메일 **********

  var emailInput = document.getElementById("email");
  var emailError = document.getElementById("emailError");
  var duplicateCheckButton = document.querySelector(
    '[data-testid="Button-email"]'
  );

  emailInput.addEventListener("input", validateEmail);

  function validateEmail() {
    var email = emailInput.value;
    var isValid = checkEmailFormat(email);

    if (isValid) {
      emailError.style.display = "none";
      emailInput.classList.remove("css-zf1cy7");
      emailInput.classList.add("css-1sbrczv");
      duplicateCheckButton.removeAttribute("disabled");
      duplicateCheckButton.style.pointerEvents = "auto";
    } else {
      emailError.style.display = "block";
      emailInput.classList.remove("css-1sbrczv");
      emailInput.classList.add("css-zf1cy7");
      duplicateCheckButton.setAttribute("disabled", "");
      duplicateCheckButton.style.pointerEvents = "none";
    }
  }

  function checkEmailFormat(email) {
    var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
    return regex.test(email);
  }

  duplicateCheckButton.setAttribute("disabled", "disabled");
  duplicateCheckButton.style.pointerEvents = "none";

  // ********** 핸드폰번호 **********
  var mobileInput = document.getElementById("mobile");
  var mobileError = document.getElementById("mobileError");
  var verifyButton = document.querySelector("[data-testid='Button_authNum']");
  var authCodeInput = document.querySelector("[data-testid='Input_authCode']");

  mobileInput.addEventListener("input", validateMobile);

  function validateMobile() {
    var mobile = mobileInput.value;
    var isValid = checkMobileFormat(mobile);

    if (isValid) {
      mobileError.style.display = "none";
      mobileInput.classList.remove("css-zf1cy7");
      mobileInput.classList.add("css-1sbrczv");
      verifyButton.removeAttribute("disabled");
      verifyButton.style.pointerEvents = "auto";
    } else {
      mobileError.style.display = "block";
      mobileInput.classList.remove("css-1sbrczv");
      mobileInput.classList.add("css-zf1cy7");
      verifyButton.setAttribute("disabled", "");
      verifyButton.style.pointerEvents = "none";
    }
  }

  function checkMobileFormat(mobile) {
    var regex = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
    return regex.test(mobile);
  }

  verifyButton.setAttribute("disabled", "disabled");
  verifyButton.style.pointerEvents = "none";

  // ********** 동의 선택 svg 변경 **********
  var agreeAllCheckbox = document.getElementById("is_agree_all");
  var checkboxes = document.querySelectorAll(
    '.css-sfv171 .css-5hccr8.checkbox-container input[type="checkbox"]'
  );

  agreeAllCheckbox.addEventListener("change", function () {
    checkboxes.forEach(function (checkbox) {
      checkbox.checked = agreeAllCheckbox.checked;
      updateCheckboxUI(checkbox);
    });
  });

  // 각 체크박스에 이벤트 리스너 추가
  checkboxes.forEach(function (checkbox) {
    checkbox.addEventListener("change", function () {
      if (checkbox === agreeAllCheckbox) {
        // 전체 동의 체크박스가 변경되면 모든 개별 체크박스에 반영
        checkboxes.forEach(function (cb) {
          cb.checked = checkbox.checked;
          updateCheckboxUI(cb);
        });
      } else {
        // 개별 체크박스가 변경되면 전체 동의 체크박스 상태 업데이트
        var allChecked = true;
        checkboxes.forEach(function (cb) {
          if (cb !== agreeAllCheckbox && !cb.checked) {
            allChecked = false;
          }
        });
        agreeAllCheckbox.checked = allChecked;
        updateCheckboxUI(checkbox);
      }
    });
  });

  // 체크박스 UI 업데이트
  function updateCheckboxUI(checkbox) {
    var divBeforeCheckbox = checkbox.previousElementSibling;
    if (checkbox.checked) {
      // 체크되었을 때
      divBeforeCheckbox.classList.remove("css-1axjas8");
      divBeforeCheckbox.classList.add("css-1wt6x5l");
    } else {
      // 체크 해제되었을 때
      divBeforeCheckbox.classList.remove("css-1wt6x5l");
      divBeforeCheckbox.classList.add("css-1axjas8");
    }
  }
});

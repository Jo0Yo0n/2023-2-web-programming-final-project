const sendit = () => {
	const userNickName = document.signUpForm.userNickName;
	const userEmail = document.signUpForm.userEmail;
	const userPassword = document.signUpForm.userPassword;
	const userPasswordCheck = document.signUpForm.userPasswordCheck;
	
	// 닉네임 입력 안했을 경우
	if(userNickName.value === ""){
		alert("닉네임을 입력해주세요.");
		userNickName.focus();
		return false;
	}

	// 이메일 입력 안했을 경우
	if (userEmail.value === "") {
		alert("이메일을 입력해주세요");
		userEmail.focus();
		return false;
	}

	// 이메일 형식 : 이메일 아이디 @ 도메인 형식
	const expEmailText = /^[A-Za-z0-9\.\-]+@[A-Za-z0-9\.\-]+\.[A-Za-z0-9\.\-]+$/;
	if (!expEmailText.test(userEmail.value)) {
		alert("이메일 형식을 확인해주세요.");
		userEmail.focus();
		return false;
	}

	// 비밀번호 입력 안했을 경우
	if (userPassword.value === "") {
		alert("비밀번호를 입력해주세요.");
		userPassword.focus();
		return false;
	}
	// 비밀번호 확인 입력 안했을 경우
	if (userPasswordCheck.value === "") {
		alert("비밀번호 확인을 입력해주세요.");
		userPasswordCheck.focus();
		return false;
	}
	// 비밀번호와 비밀번호 확인이 다를 경우
	if (userPassword.value !== userPasswordCheck.value) {
		alert("비밀번호가 다릅니다. 다시 입력해주세요.");
		userPasswordCheck.focus();
		return false;
	}

	return true;
};

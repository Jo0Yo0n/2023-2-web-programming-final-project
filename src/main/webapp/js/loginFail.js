// 페이지 로드 후 실행
window.onload = function () {
    // URL 파라미터에 login=false가 있으면 alert 표시
    if (window.location.search.includes('login=false')) {
        showAlert();
    }
};

// 로그인 실패 시 alert 표시 함수
function showAlert() {
    // 팝업 메시지 설정
    alert("로그인에 실패했습니다. 다시 시도해주세요.");
}
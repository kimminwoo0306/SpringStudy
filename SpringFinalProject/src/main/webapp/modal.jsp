<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style>
.modal {
  display: none; /* 모달을 숨김 */
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0,0,0,0.4);
}

.modal-content {
  background-color: white;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

.close {
  float: right;
  cursor: pointer;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
  // 모달 열기 버튼 클릭 이벤트
  $(".modal-open-btn").click(function(){
    $(".modal").css("display", "block");
  });

  // 모달 닫기 버튼 클릭 이벤트
  $(".close").click(function(){
    $(".modal").css("display", "none");
  });
});
</script>
</head>
<body>
<div>
  <button class="modal-open-btn">모달 열기</button>
</div>
<div class="modal">
  <div class="modal-content">
    <span class="close">닫기</span>
    <p>모달 내용이 들어갑니다.</p>
  </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	width: 1200px;
	margin: 0px auto;
}
</style>
</head>
<body>
<div class="text-center"><h1>명소</h1></div>
<div class="container">
  <div class="row">
    <c:forEach var="vo" items="${list }">
	  	<div class="col-md-3">
	    <div class="thumbnail">
	      <a href="../seoul/detail.do?no=${vo.no }">
	        <img src="${vo.poster }" style="width:300%; height: 220px">
	        <div class="caption">
	          <p style="font-size: 8px">${vo.title }</p>
	        </div>
	      </a>
	    </div>
	  	</div>
    </c:forEach>
  </div>
</div>
  <div style="height: 10px"></div>
  <div class="text-center">
    <ul class="pagination">
      <c:if test="${startPage>1 }">
	  <li><a href="../seoul/location.do?page=${startPage-1 }">&lt;</a></li>
	  </c:if>
	  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		  <li ${i==curpage?"class=active":"" }><a href="../seoul/location.do?page=${i }">${i }</a></li>
	  </c:forEach>
	  <c:if test="${endPage<totalpage }">
	  <li><a href="../seoul/location.do?page=${endPage+1 }">&gt;</a></li>
	  </c:if>
	</ul>
  </div>
  <div style="height: 10px"></div>
  <div class="row">
    <div class="text-center">
      <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
      ${curpage } page / ${totalpage } pages
      <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
    </div>
  </div>
</body>
</html>
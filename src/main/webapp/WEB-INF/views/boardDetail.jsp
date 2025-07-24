<%@page contentType="text/html;charset=utf-8" language="java"
   pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script>
     function goList(){
       location.href="${ctx}/boardList";
     }
     function goDel(num){
       location.href="${ctx}/boardDelete/"+num;
     }
     function goUpdate(num){

     }
  </script>
</head>
<body>

<div class="container mt-5">
  <h2>Spring MVC Framework 게시판</h2>
  <div class="card">
    <div class="card-header">글쓰기</div>
    <div class="card-body">
      <table class="table table-bordered">
         <tr>
            <td>번호</td>
            <td>${board.num}</td>
         </tr>
         <tr>
            <td>제목</td>
            <td>${board.title}</td>
         </tr>
         <tr>
            <td>작성자</td>
            <td>${board.writer}</td>
         </tr>
         <tr>
             <td>작성일</td>
             <td>${board.date}</td>
          </tr>
          <tr>
              <td>조회수</td>
              <td>${board.count}</td>
          </tr>
      </table>
      <button class="btn btn-primary btn-sm" onClick="goList()">목록</button>
      <button class="btn btn-info btn-sm" onClick="goUpdate(${board.num})">수정</button>
      <button class="btn btn-warning btn-sm" onClick="goDel(${board.num})">삭제</button>
    </div>
    <div class="card-footer">학번_이름</div>
  </div>
</div>
</body>
</html>
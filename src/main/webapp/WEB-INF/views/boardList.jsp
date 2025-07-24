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
       function goWriter(){
          //alert("버튼이 클릭됨"); // ajax()->JSON
          location.href="${ctx}/boardForm";
       }
       function goDel(num){
          location.href="${ctx}/boardDelete?num="+num;
       }
    </script>
</head>
<body>
<div class="container mt-5">
  <h2>Spring MVC Framework 게시판</h2>
  <div class="card">
    <div class="card-header">리스트보기</div>
    <div class="card-body">
      <table class="table table-hover">
          <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>삭제</th>
             </tr>
          </thead>
          <tbody>
            <c:forEach var="board" items="${bList}">
              <tr>
                  <td>${board.num}</td>
                  <td><a href="${ctx}/boardDetail/${board.num}">${board.title}</a></td>
                  <td>${board.writer}</td>
                  <td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd" /></td>
                  <td>${board.count}</td>
                  <td><button class="btn btn-info btn-sm" onClick="goDel(${board.num})">삭제</button></td>
               </tr>
              </c:forEach>
          </tbody>
        </table>
        <button onClick="goWriter()" class="btn btn-primary">글쓰기</button>
    </div>
    <div class="card-footer">학번_이름</div>
  </div>
</div>

</body>
</html>
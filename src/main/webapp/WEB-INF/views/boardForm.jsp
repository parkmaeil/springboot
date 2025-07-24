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
</head>
<body>

<div class="container mt-5">
  <h2>MVC Framework 게시판</h2>
  <div class="card">
    <div class="card-header">글쓰기</div>
    <div class="card-body">
       <form method="post" action="${ctx}/boardWrite">
         <div class="form-group">
           <label for="title">제목(title)</label>
           <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
         </div>
         <div class="form-group">
           <label for="writer">작성자(writer)</label>
           <input type="text" class="form-control" placeholder="Enter writer" id="writer" name="writer">
         </div>
         <button type="submit" class="btn btn-primary">글쓰기</button>
         <button type="reset" class="btn btn-warning">취소</button>
       </form>
    </div>
    <div class="card-footer">학번_이름</div>
  </div>
</div>

</body>
</html>
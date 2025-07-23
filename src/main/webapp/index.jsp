<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>메인 페이지</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<%-- contextPath를 JSTL 변수로 설정 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div class="container mt-5">
  <h2 class="mb-4">🌱 Spring WEB MVC 실습 메인 페이지</h2>

  <div class="card">
    <div class="card-header">
      기능 목록
    </div>
    <div class="card-body">
      <p class="card-text">아래 버튼을 클릭해 게시판으로 이동해보세요.</p>
      <a href="${ctx}/board/list" class="btn btn-primary">📋 게시판 이동</a>
    </div>
    <div class="card-footer text-muted">
      <fmt:formatDate value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd HH:mm:ss" />
    </div>
  </div>
</div>

</body>
</html>

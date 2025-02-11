<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>상품 추가</title>
</head>
<body>
    <h2>상품 추가</h2>
    <form action="${pageContext.request.contextPath}/addGoods" method="post" enctype="multipart/form-data">
        <!-- 기존 필드들 -->
        <div>
            <label for="gCode">상품 코드</label>
            <input type="text" id="gCode" name="gCode" required>
        </div>
        <div>
            <label for="gCategory">카테고리</label>
            <input type="text" id="gCategory" name="gCategory" required>
        </div>
        <div>
            <label for="gName">상품명</label>
            <input type="text" id="gName" name="gName" required>
        </div>
        <div>
            <label for="gContent">상품 설명</label>
            <input type="text" id="gContent" name="gContent" required>
        </div>
        <div>
            <label for="gPrice">가격</label>
            <input type="number" id="gPrice" name="gPrice" required>
        </div>
        <div>
            <label for="stock">재고</label>
            <input type="number" id="stock" name="stock" required>
        </div>

        <!-- 이미지 코드 (선택적 입력) -->
        <div>
            <label for="gImage">상품 이미지 코드:</label>
            <input type="text" id="gImage" name="gImage">
        </div>

        <!-- 파일 업로드 (필수 입력) -->
        <div>
            <label for="fileImage">상품 이미지 파일:</label>
            <input type="file" id="fileImage" name="fileImage" accept="image/*" required>
        </div>
        
        <button type="submit" class="btn btn-primary">상품 추가</button>
    </form>
</body>
</html>

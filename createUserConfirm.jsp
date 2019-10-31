<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="./css/button.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/title.css">
<link rel="stylesheet" href="./css/verticalList.css">
<title>ユーザー情報入力確認画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<script src="./js/createUser.js"></script>

	<h1>ユーザー情報入力確認画面</h1>
		<s:form id="createUserForm">
		<table class="vertical_list">
			<tr>
				<th><s:label value="姓"/></th><td><s:property value="familyName"/></td>
			</tr>
			<tr>
				<th><s:label value="名"/></th><td><s:property value="firstName"/></td>
			</tr>
			<tr>
				<th><s:label value="姓ふりがな"/></th><td><s:property value="familyNameKana"/></td>
			</tr>
			<tr>
				<th><s:label value="名ふりがな"/></th><td><s:property value="firstNameKana"/></td>
			</tr>
			<tr>
				<th><s:label value="性別"/></th><td><s:property value="sex"/></td>
			</tr>
			<tr>
				<th><s:label value="メールアドレス"/></th><td><s:property value="mail"/></td>
			</tr>
			<tr>
				<th><s:label value="ユーザーID"/></th><td><s:property value="userId"/></td>
			</tr>
			<tr>
				<th><s:label value="パスワード"/></th><td><s:property value="password"/></td>
			</tr>
		</table>
		<div id="btn_position">
			<s:submit value="登録" class="submit_btn" onclick="goCreateUserCompleteAction()"/>
		</div>
		<div id="btn_position">
			<s:submit value="戻る" class="submit_btn" onclick="goCreateUserAction()">
				<s:hidden id="backFlag" name = "backFlag" value="1"/>
			</s:submit>
		</div>
		</s:form>

</body>
</html>
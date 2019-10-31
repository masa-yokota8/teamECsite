<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" type="text/css" href="./css/button.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">
<link rel="stylesheet" type="text/css" href="./css/title.css">
<link rel="stylesheet" type="text/css" href="./css/verticalList.css">
<title>ユーザー情報入力画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
		<h1>ユーザー情報入力画面</h1>
		<div>
		<s:if test="familyNameEList !=null && familyNameEList.size() > 0">
			<div class="message_red">
				<s:iterator value="familyNameEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="firstNameEList !=null && firstNameEList.size() > 0">
			<div class="message_red">
				<s:iterator value="firstNameEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="familyNameKanaEList !=null && familyNameKanaEList.size() > 0">
			<div class="message_red">
				<s:iterator value="familyNameKanaEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="firstNameKanaEList !=null && firstNameKanaEList.size() > 0">
			<div class="message_red">
				<s:iterator value="firstNameKanaEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="mailEList !=null && mailEList.size() > 0">
			<div class="message_red">
				<s:iterator value="mailEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="userIdEList != null && userIdEList.size() > 0">
			<div class="message_red">
				<s:iterator value="userIdEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="passwordEList != null && passwordEList.size() > 0">
			<div class="message_red">
				<s:iterator value="passwordEList"><p><s:property /></p></s:iterator>
			</div>
		</s:if>
		</div>
		<div>
		<s:if test="!errorMessage.isEmpty()">
			<div class="message_red">
				<p><s:property value="errorMessage"/></p>
			</div>
		</s:if>
		</div>
		<s:form action="CreateUserConfirmAction">
			<table class="vertical_list">
				<tr>
					<th>姓</th><td><s:textfield id="input" name="familyName" value="%{#session.familyName}" placeholder="姓"/></td>
				</tr>
				<tr>
					<th>名</th><td><s:textfield id="input" name="firstName" value="%{#session.firstName}" placeholder="名"/></td>
				</tr>
				<tr>
					<th>姓ふりがな</th><td><s:textfield id="input" name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがな"/></td>
				</tr>
				<tr>
					<th>名ふりがな</th><td><s:textfield id="input" name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな"/></td>
				</tr>
				<tr>
					<th>性別</th><td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" placeholder="性別"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th><td><s:textfield id="input" name="mail" value="%{#session.mail}" placeholder="メールアドレス"/></td>
				</tr>
				<tr>
					<th>ユーザーID</th><td><s:textfield id="input" name="userId" value="%{#session.userIdForCreateUser}" placeholder="ユーザーID"/></td>
				</tr>
				<tr>
					<th>パスワード</th><td><s:password id="input" name="password" value="" placeholder="パスワード"/></td>
				</tr>
			</table>
			<div id="btn_position"><s:submit class="submit_btn" value="確認"/></div>
		</s:form>
	<div id="footer">
	</div>
</body>
</html>
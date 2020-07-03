<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.janken3.Janken" %>
<%
	Janken janken = (Janken)session.getAttribute("janken");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div id="showresult">
		<h1>じゃんけん結果 :</h1>
		<h2><%= janken.getResult() %></h2>
	</div>

	<div id="count">
			<h2>WIN：<%= janken.getWincount() %></h2>
			<h2>Lose：<%= janken.getLosecount() %></h2>
			<h2>Draw：<%= janken.getDrawcount() %></h2>
		<%
			if(janken.getWincount() > 0 || janken.getLosecount() > 0 || janken.getDrawcount() > 0) {
		%>
			<a href="${pageContext.request.contextPath}/reset?action=reset" id="countnum">リセットする</a>
		<%
			}
		%>
	</div>

	<div id="result">

		<div id="player">
			<h2>プレイヤー</h2>
				<img src="${pageContext.request.contextPath}/image/<%= janken.getPlayerHand() %>.png" alt="<%= janken.getPlayerHand() %>">
		</div>

		<h2 id="vs">VS</h2>


		<div id="computer">
			<h2>コンピューター</h2>
				<img src="${pageContext.request.contextPath}/image/<%= janken.getComputerHand() %>.png" alt="<%= janken.getComputerHand() %>">
		</div>

	</div>

	<form method="GET" action="${pageContext.request.contextPath}/top" id="result-form">
		<input type="submit" value="もう一回勝負する！">
	</form>

</body>
</html>
<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>Lp</td>
			<td>Nazwa</td>
			<td>Opis</td>
			<td>Cena</td>
			<td>Ilosc</td>
			<td>Kategoria</td>
			<td>Usu&#324;</td>
			<td>Zmie&#324;</td>
		</tr>
		<c:forEach var="towar" items="${magazyn}">
			<tr>
				<td><c:out value="${towar.id+1}" /></td>
				<td><c:out value="${towar.nazwa}" /></td>
				<td><c:out value="${towar.opis}" /></td>
				<td><c:out value="${towar.cena}" /></td>
				<td><c:out value="${towar.ilosc}" /></td>
				<td><c:out value="${towar.kategoria}" /></td>
				<td><a href="magazyn?id=${towar.id}&action=delete">Usu&#324;</a></td>
				<td><a href="magazyn?id=${towar.id}&action=update">Zmie&#324;</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
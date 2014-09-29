<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
   table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    background-color: #6495ED
    }
    
    table {
        width: 100%
    }
    
   
    

    
     

    
     
   
    
   
</style>
</head>
<body>
    
    
    

	<form:form modelAttribute="towar">
            
		Nazwa: <form:input path="nazwa" />
		<br>
		Opis: <form:input path="opis" />
		<br>
				Cena: <form:input path="cena" />
		<br>
				Ilosc: <form:input path="ilosc" />
		<br>
				Kategoria: <form:input path="kategoria" />
		<br>
		<input type="submit" value="Dodaj" formaction="magazyn"
			formmethod="post" />



	</form:form>

	<form action="magazyn" method="get">
		<input type="text" value=".*" name="wyrazenie" ><br> 
		<select name="kategoria">
			<option value="1" >Nazwa</option>
			<option value="2" >Opis</option>
			<option value="5" >Kategoria</option>
		</select><br>
		<input type="submit" name="filter" value="Filtruj" >
		
	</form>

                <table>
                      <tabele id="1">
                      <tr>
                        
			<td><a href="magazyn?sort=0">Id</a></td>
			<td><a href="magazyn?sort=1">Nazwa</a></td>
			<td><a href="magazyn?sort=2">Opis</a></td>
			<td><a href="magazyn?sort=3">Cena</a></td>
			<td><a href="magazyn?sort=4">Ilosc</a></td>
			<td><a href="magazyn?sort=5">Kategoria</a></td>
			<td>Usu&#324;</td>
			<td>Zmie&#324;</td>
                        
		      </tr>
                      </tabele>
                
		<c:forEach var="towar" items="${magazyn}">
                    <table id="2">
			<tr>
                                <td id="2">
				<td><c:out value="${towar.id+1}" /></td>
				<td><c:out value="${towar.nazwa}" /></td>
				<td><c:out value="${towar.opis}" /></td>
				<td><c:out value="${towar.cena}" /></td>
				<td><c:out value="${towar.ilosc}" /></td>
				<td><c:out value="${towar.kategoria}" /></td>
				<td><a href="magazyn?id=${towar.id}&action=delete">Usu&#324;</a></td>
				<td><a href="magazynzmien?id=${towar.id}&action=update">Zmie&#324;</a>
				</td>
                                </td>
			</tr>
                    </table>
		</c:forEach>
	</table>
</body>
</html>
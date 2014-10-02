<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.magazyn.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
<style>
 
</style>
</head>
<body>
    
    
    
    <div id="okienka">
	<form:form modelAttribute="towar">
            <div id="okienka-tr">
            <tr>
		<form:input path="nazwa" name="nazwa" placeholder="Nazwa" />
		<br>
		<form:input path="opis" name="opis" placeholder="Opis" />
		<br>
		<form:input path="cena" name="cena" placeholder="Cena"/>
		<br>
		<form:input path="ilosc" name="ilosc" placeholder="Ilosc" />
		<br>
		<form:input path="kategoria" name="kategoria" placeholder="Kategoria" />
		<br>
             </tr>
             
            </div>
		<input type="submit" value="Dodaj" formaction="magazyn"
			formmethod="post" />



	</form:form>
    </div>
    <div id="filtr">
	<form action="magazyn" method="get">
		<input type="text" value=".*" name="wyrazenie" ><br> 
		<select name="kategoria">
			<option value="1" >Nazwa</option>
			<option value="2" >Opis</option>
			<option value="5" >Kategoria</option>
		</select><br>
		<input type="submit" name="filter" value="Filtruj" >
		
	</form>
    </div>
    
    
    <div id="tabela">
                <table style="width: 100%">
                      
                      <tr>
                      
                        
			<th><a href="magazyn?sort=0">Id</a></th>
			<th><a href="magazyn?sort=1">Nazwa</a></th>
			<th><a href="magazyn?sort=2">Opis</a></th>
			<th><a href="magazyn?sort=3">Cena</a></th>
			<th><a href="magazyn?sort=4">Ilosc</a></th>
			<th><a href="magazyn?sort=5">Kategoria</a></th>
			<th>Usu&#324;</th>
			<th>Zmie&#324;</th>
                      </tr>
                
    </div>
                        
		      
    
    
    <div id="tabela1">
       
		<c:forEach var="towar" items="${magazyn}">
                    
			<tr>
                                
				<td><c:out value="${towar.id+1}" /></td>
				<td><c:out value="${towar.nazwa}" /></td>
				<td><c:out value="${towar.opis}" /></td>
				<td><c:out value="${towar.cena}" /></td>
				<td><c:out value="${towar.ilosc}" /></td>
				<td><c:out value="${towar.kategoria}" /></td>
				<td><a href="magazyn?id=${towar.id}&action=delete">Usu&#324;</a></td>
				<td><a href="magazynzmien?id=${towar.id}&action=update">Zmie&#324;</a>
				</td>
                                
			</tr>
                    
		</c:forEach>
	</table>
    </div>
</body>
</html>
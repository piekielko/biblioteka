<%@include file="./includes/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/style.biblioteka.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
<style>
 
</style>
</head>
<body>
    
    
    
    <div id="okienka">
	<form:form modelAttribute="ksiazka">
            <div id="okienka-tr">
            <tr>
                
		<form:input path="tytul" name="tytul" placeholder="Tytul" />
		<br>
		<form:input path="opis" name="opis" placeholder="Opis" />
		<br>
                <form:input path="imieAutora" name="imieAutora" placeholder="ImieAutora" />
                <br>
		<form:input path="nazwiskoAutora" name="nazwiskoAutora" placeholder="NazwiskoAutora"/>
		<br>
                <form:input path="pochodzenieAutora" name="pochodzenieAutora" placeholder="PochodzenieAutora" />
                <br>
		<form:input path="ilosc" name="ilosc" placeholder="Ilosc" />
		<br>
		<form:input path="kategoria" name="kategoria" placeholder="Kategoria" />
		<br>
             </tr>
             
            </div>
		<input type="submit" value="Dodaj" formaction="biblioteka"
			formmethod="post" />



	</form:form>
    </div>
    <div id="filtr">
	<form action="biblioteka" method="get">
		<input type="text" value=".*" name="wyrazenie" ><br> 
		<select name="kategoria">
			<option value="1" >Tytul</option>
			<option value="2" >Opis</option>
			<option value="7" >Kategoria</option>
		</select><br>
		<input type="submit" name="filter" value="Filtruj" >
		
	</form>
    </div>
    
    
    <div id="tabela">
               <table style="width: 100%">
                      
                      <tr>
                      
                        
			<th><a href="biblioteka?sort=0">Id</a></th>
			<th><a href="biblioteka?sort=1">Tytul</a></th>
			<th><a href="biblioteka?sort=2">Opis</a></th>
			<th><a href="biblioteka?sort=3">imieAutora</a></th>
                        <th><a href="biblioteka?sort=4">nazwiskoAutora</a></th>
                        <th><a href="biblioteka?sort=5">pochodzenieAutora</a></th>
			<th><a href="biblioteka?sort=6">Ilosc</a></th>
			<th><a href="biblioteka?sort=7">Kategoria</a></th>
			<th>Usu&#324;</th>
			<th>Zmie&#324;</th>
                      </tr>
                
    </div>
                        
		      
    
    
    <div id="tabela1">
       
		<c:forEach var="ksiazka" items="${biblioteka}">
                    
			<tr>
                                
				<td><c:out value="${ksiazka.id+1}" /></td>
				<td><c:out value="${ksiazka.tytul}" /></td>
				<td><c:out value="${ksiazka.opis}" /></td>
				<td><c:out value="${ksiazka.imieAutora}" /></td>
                                <td><c:out value="${ksiazka.nazwiskoAutora}" /></td>
                                <td><c:out value="${ksiazka.pochodzenieAutora}" /></td>
				<td><c:out value="${ksiazka.ilosc}" /></td>
				<td><c:out value="${ksiazka.kategoria}" /></td>
				<td><a href="magazyn?id=${ksiazka.id}&action=delete">Usu&#324;</a></td>
				<td><a href="magazynzmien?id=${ksiazka.id}&action=update">Zmie&#324;</a>
				</td>
                                
			</tr>
                    
		</c:forEach>
	</table>
    </div>
</body>
</html>
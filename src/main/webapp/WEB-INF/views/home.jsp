<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
        <link href="${pageContext.request.contextPath}/resources/style.home.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        
</head>
<body>
    <div id="header">
        <h1>
	Hello world!  
        </h1>
    </div>
    
    <div id="section">
        <P>  The time on the server is ${serverTime}. </P>
    </div>
    
    <div id="section1"
        <ul>
		<li>
			<a href="<c:url value="/magazyn" />" >Magazyn</a>
                        <button type="<c:url value="/magazyn" />">Magazyn</button>
		</li>
                
        </ul>
    </div>
</body>
</html>

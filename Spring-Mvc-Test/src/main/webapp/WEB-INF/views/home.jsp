<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	<h>Ma Liste</h>
	<c:forEach items="${UM}" var="u">
	    ${u.id}
	    ${u.nom}
	    ${u.prenom}
	    ${u.age}
	</c:forEach>

</h1>
     <h1>getOne</h1>
    <form action="getOne" method="get">
		<input type="text" name="id">
		<button type="submit">Get</button>
	</form>
	
	${U.id}
	${U.nom}
	${U.prenom}
	${U.age}
	
	
	<h1>Remove</h1>
	
	 <form action="delete" method="post">
		<input type="text" name="id">
		<button type="submit">Get</button>
	</form>
	
	<h1>Save</h1>
	<form action="save" method="post">
	<label>Nom</label>
	<input type="text" name="nom">
	<label>Prénom</label>
	<input type="text" name="prenom">
	<label>Age</label>
	<input type="text" name="age">
	<button type="submit">Get</button>
	</form>
	
	${error}
	

</body>
</html>

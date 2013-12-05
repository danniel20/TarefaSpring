<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formul�rio Novo Usu�rio</title>
</head>
<body>
<h3>Cadastro de Usu�rio</h3>

	<form:errors path="usuario.login" cssStyle="color:red"/> <br />
	<form:errors path="usuario.senha" cssStyle="color:red"/> <br />
	
    <form action="cadastraUsuario" method="post">
      Login: <input type="text" name="login" /> <br />
      Senha: <input type="password" name="senha" /> <br />
      <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
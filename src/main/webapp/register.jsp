<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Cadastro Usuário</h2>
<form action="usuario" method="post">
    <input type="hidden" name="action" value="register"/>
    <label for="nome">Name:</label>
    <input type="text" id="nome" name="nome" required/>
    <br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/>
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required/>
    <br/>
    <button type="submit">Register</button>
</form>
<br/>
<a href="login.jsp">Já possui uma conta? Faça o login.</a>
<br/>
<a href="livros.jsp">Cadastrar Livro</a>
<br/>
<a href="welcome.jsp">Voltar para Tela Inicial</a>
</body>
</html>

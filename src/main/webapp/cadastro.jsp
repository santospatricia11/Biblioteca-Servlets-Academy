<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Cadastrar</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coffee & Literature - Home</title>
        <link rel="stylesheet" href="cadastro.css">

</head>
<body>
<h2>Cadastro Usuário</h2>

<form action="usuario" method="post">
    <input type="hidden" name="acao" value="inserir">
    Nome: <input type="text" name="nome"><br>
    Email: <input type="text" name="email"><br>
    Senha: <input type="password" name="password"><br>
    <input type="submit" value="Cadastrar">

    <a href="login.jsp">Entrar</a>

</form>

<br/>
<a href="login.jsp">Já possui uma conta? Faça o login.</a>
<br/>
<a href="livros.jsp">Cadastrar Livro</a>
<br/>
<a href=/welcome.jsp">Voltar para Tela Inicial</a>
</body>
</html>





<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro Usuário</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<jsp:include page="menubar.jsp" />
<div>
    <h2>Formulário de Cadastro Usuário</h2>
    <form action="#">
        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required />
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required />
        <button type="submit">Enviar</button>
    </form>
</div>
</body>
</html>--%>








<%--

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro Usuário</title>



</head>
<body>

<div>
    <h2>Formulário de Cadastro Usuário </h2>
    <form action="#">

        <label for="nome">Nome completo:</label>
        <input type="text" id="nome" name="nome" required />


        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required />

        <button type="submit">Enviar</button>
    </form>
</div>

</body>
</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Livros</title>
</head>
<body>

<p>Cadastre seu Livro</p>

<h1>${livro.ISBN == null ? 'Adicionar Novo Livro' : 'Editar Livro'}</h1>

<form action="${livro.ISBN == null ? 'insert' : 'update'}" method="post">
    <input type="hidden" name="ISBN" value="${livro.ISBN}">
    <table>
        <tr>
            <td>Nome do Livro:</td>
            <td><input type="text" name="nomeLivro" value="${livro.nomeLivro}"></td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td><input type="text" name="categoria" value="${livro.categoria}"></td>
        </tr>
        <tr>
            <td>Descrição:</td>
            <td><input type="text" name="descricao" value="${livro.descricao}"></td>
        </tr>
        <tr>
            <td>Diretório da Imagem:</td>
            <td><input type="text" name="diretorioImagem" value="${livro.diretorioImagem}"></td>
        </tr>
        <tr>
            <td>Quantidade:</td>
            <td><input type="number" name="quantidade" value="${livro.quantidade}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar"></td>
        </tr>
    </table>
</form>
<a href="testando/livro-list.jsp">Listar Livro</a>
</body>
</html>

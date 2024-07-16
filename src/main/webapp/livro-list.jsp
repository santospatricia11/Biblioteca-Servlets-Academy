<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Livros</title>
</head>
<body>
<h1>Lista de Livros</h1>
<a href="new">Adicionar Novo Livro</a>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>Nome do Livro</th>
        <th>Categoria</th>
        <th>Descrição</th>
        <th>Diretório da Imagem</th>
        <th>Quantidade</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="livro" items="${listLivro}">
        <tr>
            <td>${livro.ISBN}</td>
            <td>${livro.nomeLivro}</td>
            <td>${livro.categoria}</td>
            <td>${livro.descricao}</td>
            <td>${livro.diretorioImagem}</td>
            <td>${livro.quantidade}</td>
            <td>
                <a href="edit?ISBN=${livro.ISBN}">Editar</a>
                <a href="delete?ISBN=${livro.ISBN}">Deletar</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

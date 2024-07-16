<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Livro</title>
</head>
<body>
<h1>Editar Livro</h1>
<form action="livros/update" method="post">
    <input type="hidden" name="isbn" value="${livro.isbn}">
    <table>
        <tr>
            <td>Nome do Livro:</td>
            <td><input type="text" name="nomeLivro" value="${livro.nomeLivro}" required></td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td><input type="text" name="categoria" value="${livro.categoria}" required></td>
        </tr>
        <tr>
            <td>Descrição:</td>
            <td><input type="text" name="descricao" value="${livro.descricao}" required></td>
        </tr>
        <tr>
            <td>Diretório da Imagem:</td>
            <td><input type="text" name="diretorioImagem" value="${livro.diretorioImagem}"></td>
        </tr>
        <tr>
            <td>Quantidade:</td>
            <td><input type="number" name="quantidade" value="${livro.quantidade}" required></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar"></td>
        </tr>
    </table>
</form>
</body>
</html>

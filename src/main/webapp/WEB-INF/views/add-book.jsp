<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Novo Livro</title>
</head>
<body>
<h1>Adicionar Novo Livro</h1>
<form action="livros/insert" method="post">
    <table>
        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" required></td>
        </tr>
        <tr>
            <td>Nome do Livro:</td>
            <td><input type="text" name="nomeLivro" required></td>
        </tr>
        <tr>
            <td>Categoria:</td>
            <td><input type="text" name="categoria" required></td>
        </tr>
        <tr>
            <td>Descrição:</td>
            <td><input type="text" name="descricao" required></td>
        </tr>
        <tr>
            <td>Diretório da Imagem:</td>
            <td><input type="text" name="diretorioImagem"></td>
        </tr>
        <tr>
            <td>Quantidade:</td>
            <td><input type="number" name="quantidade" required></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Salvar"></td>
        </tr>
    </table>
</form>
</body>
</html>

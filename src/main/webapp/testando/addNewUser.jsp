<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding a New User</title>
</head>
<body>
<form action="addNewUser" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required />
    <br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Add</button>
</form>

</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Freemarker例子2</title>
</head>
<body>

    <P>  ${name} Hello Word ,${msg}</P>

    <br/>
<table>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
    </tr>

    <#list userList as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.sex}</td>
        </tr>
    </#list>
</table>
</body>
</html>
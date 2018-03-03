<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>მთავარი</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <div class="mainDiv">
            <form method="post" action="/login">
                <p>სახელი:</p>
                <input type="text" placeholder="სახელი" name="usernameField">
                <p>პაროლი:</p>
                <input type="password" placeholder="გვარი" name="passwordField">
                <p></p>
                <input type="submit" value="შესვლა">
                <%
                    String failedAuth = (String)request.getAttribute("failedAuth");
                    if (failedAuth != null && failedAuth.equals("true")) {
                        out.print("<p class=\"failedAuth\">მომხმარებლის სახელი/პაროლი არასწორია</p>");
                    }
                %>
            </form>
        </div>
    </body>
</html>

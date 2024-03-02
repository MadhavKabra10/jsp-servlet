<jsp:include page="include/header.jsp">
    <jsp:param name="page" value="Login"/>
</jsp:include>
<br/><br/><br/>
<form action = "<%=request.getContextPath()%>/Form" method="post">
    Enter Username:<input type = "text" name = "username"><br><br>
    Enter Email:<input type = "email" name = "email"><br>
    <input type = "hidden" name = "formType" value = "login"><br>
    <input type = "submit" value = "Find my userId">
</form>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
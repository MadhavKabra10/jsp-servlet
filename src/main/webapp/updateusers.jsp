<jsp:include page="include/header.jsp">
    <jsp:param name="page" value="UpdatePage"/>
</jsp:include>
<br/><br/><br/>
<h2>Update your credentials here..</h2>
<form action = "<%=request.getContextPath()%>/Form" method="post">
    Enter Username : <input type = "text" name = "Username" value = "${param.Username}"><br>
    Enter Email : <input type = "email" name = "email" value = "${param.email}"><br>
    <input type = "hidden" name = "formType" value = "Update">
    <input type = "hidden" name = "Id" value = "${param.Id}">
    <input type = "submit" name = "Update">
</form>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
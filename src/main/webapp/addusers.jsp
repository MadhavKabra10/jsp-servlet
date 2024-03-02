<jsp:include page="include/header.jsp">
<jsp:param name="page" value="AddUsers"/>
</jsp:include>
<br/><br/><br/>
<form action = "<%=request.getContextPath()%>/Form" method = "post">
Enter name:<input type = "text"  name = "Username"><br><br>
Enter Email:<input type = "email" name = "email"><br><br>
Set User_id:<input type = "number" name = "id"><br><br>
<input type = "hidden" name = "formType" value = "Add"><br/> 
<input type = "submit" value = "Add as a new user">
</form>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
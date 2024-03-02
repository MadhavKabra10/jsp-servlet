<jsp:include page="include/header.jsp">
    <jsp:param name="page" value="HomePage"/>
</jsp:include>
<br/><br/><br/>
<h2><%
    if(request.getAttribute("UserId").equals(-1)){
        out.print("No Such user exits");
    }else{
        out.print("Your user id is "+request.getAttribute("UserId"));
    }
%></h2>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
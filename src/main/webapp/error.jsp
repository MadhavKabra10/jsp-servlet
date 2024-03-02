<jsp:include page="include/header.jsp">
    <jsp:param name="page" value="error"/>
</jsp:include>
<br/><br/><br/>
<h2>Error Page</h2>
<a href="<%=request.getContextPath()%>/index.jsp">Return to home.</a>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
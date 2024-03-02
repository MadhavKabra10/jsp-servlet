<%@page import="java.util.*" %>
<%@ page import="org.IIITP.Users.User" %>
<%@page import="org.IIITP.DBOperations.*" %>
<jsp:include page="include/header.jsp">
<jsp:param name="page" value="ListUsers"/>
</jsp:include>
<br/><br/><br/>
<h2>List of our current users:</h2>
<table border="3">
<thead>
<th>User Id</th>
<th>Username</th>
<th>Email</th>
<th>Update Your account</th>
<th>Delete your account</th>
</thead>
<%
try {
    List<User> l = (List<User>)Operations.listAllUsers();
    for(User _user : l) {
        out.print("<tr>");
        out.print("<td>"+_user.getUser_id()+"</td>");
        out.print("<td>"+_user.getUsername()+"</td>");
        out.print("<td>"+_user.getEmail()+"</td>");
        out.print("<td>" + "<a href='" + request.getContextPath() + "/Home?page=UpdatePage&Id=" + _user.getUser_id() + "&Username=" + _user.getUsername() + "&email=" + _user.getEmail() + "'>Update</a>" + "</td>");
        out.print("<td>" + "<a href = " + request.getContextPath() + "/Form?formType=DeleteUsers&Id=" + _user.getUser_id() + "&Username=" + _user.getUsername() + "&email=" + _user.getEmail() +" >Delete</a>"+"</td>");
        out.print("</tr>");
    }

} catch (Exception e) {
    out.print("Error: " + e.getMessage());
}

%>
</table>
<br/><br/><br/><br/>
<jsp:include page="include/footer.jsp"/>
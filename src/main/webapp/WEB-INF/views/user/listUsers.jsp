<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Users</title>

<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/pure-0.4.2.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/jquery-ui.min.css"/>'>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/font-awesome.min.css"/>' />
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">

        <div id="userDialog" style="display: none;">
            <%@ include file="userForm.jsp"%>
        </div>

        <h2>List Of Users</h2>
        <form id="find" name="find" method="post">
            <button class="pure-button pure-button-primary" onclick="addUser()">
                <i class="fa fa-plus"></i> Add User
            </button>
            <input type="text" id="name" name="name" size="25"" placeholder="Enter seach name" autofocus required>
            <input type="submit" id="push" name="push" class="pure-button pure-button-primary" value="Find User">
        </form>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">N</th>
                  <th width="12%">Name</th>
                  <th width="12%">Age</th>
                  <th width="12%">Is Admin</th>
                  <th width="12%">Created Date</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${userListPaging}" var="user" varStatus="itr">
               <tr>
                   <td><c:out value="${offset + itr.index +1 }" /></td>
                   <td><c:out value="${user.name}" /></td>
                   <td><c:out value="${user.age}" /></td>
                   <td><c:out value="${user.admin}" /></td>
                   <td><c:out value="${user.createdDate}" /></td>

                   <td>
                     <nobr>
                        <button onclick="editUser(${user.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${user.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this user?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
         <tag:paginate max="15" offset="${offset}" count="${count}"
            uri="listUsers" next="&raquo;" previous="&laquo;"/>
     </div>

    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/bootstrap.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-2.1.4.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-ui.min.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/lib/jquery.ui.datepicker.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/resources/js/js-for-listUsers.js"/>'></script>
</body>
</html>
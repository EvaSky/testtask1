<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="userForm" commandName="user" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="User Name" maxlength="15"/>
          </div>
          <div class="pure-control-group">
               <label for="age">Age</label>
               <form:input path="age" placeholder="Age" />
          </div>
          <div class="pure-control-group">
              <label for="admin">Is Admin</label>
              <form:checkbox path="admin" />
          </div>
          <div class="pure-control-group">
              <label for="createdDate">created Date</label>
              <form:input path="createdDate" placeholder="YYYY-MM-DD" class="datepicker" />
          </div>

          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>
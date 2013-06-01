<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">3</c:param>
</c:import>
<mtw:useI18N />

<h1><mtw:i18n key="task.title" /></h1>
<div class="spacer">&nbsp;</div>
<div class="crud">
 <form action="task.update.mtw">
 <mtw:input name="id" type="hidden" value="${task.id}"/>
 <div class="row">
  <span class="label"><mtw:i18n key="task.name"/></span>
  <span class="formw">
   <mtw:textarea  name="name" id="name" cols="35" rows="5" maxlength="255" />
   <mtw:hasError><font color="red"><mtw:error field="name" /></font></mtw:hasError>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="task.projectId"/></span>
  <span class="formw">
   <mtw:select list="projectList" name="project.id"/>
   <mtw:hasError><font color="red"><mtw:error field="project.id" /></font></mtw:hasError>
  </span>
 </div>
 <div class="spacer">&nbsp;</div>
 <div class="row">
  <span class="label">&nbsp;</span>
  <span class="formw"><input type="submit" value="<mtw:i18n key="global.submit"/>"/></span>
 </div>
 <div class="spacer">&nbsp;</div>
 </form>
</div>
</body>
</html>
<script language="JavaScript">
 document.getElementById('name').value='<mtw:out value="task.name"/>';
</script>
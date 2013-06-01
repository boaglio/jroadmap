<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">1</c:param>
</c:import>
<mtw:useI18N />
<html>
<body>
<h1><mtw:i18n key="responsible.title" /></h1>
<div class="spacer">&nbsp;</div>
<div class="crud">
 <form action="responsible.update.mtw">
 <mtw:input name="id" type="hidden" value="${responsible.id}"/>
 <div class="row">
  <span class="label"><mtw:i18n key="responsible.name"/></span>
  <span class="formw">
   <mtw:input type="text" name="name" id="name" />
   <mtw:hasError><font color="red"><mtw:error field="name" /></font></mtw:hasError>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="responsible.email"/></span>
  <span class="formw">
   <mtw:input type="text" name="email"  id="email" />
   <mtw:hasError><font color="red"><mtw:error field="email" /></font></mtw:hasError>
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
 document.getElementById('name').value='<mtw:out value="responsible.name"/>';
 document.getElementById('email').value='<mtw:out value="responsible.email"/>';
</script>
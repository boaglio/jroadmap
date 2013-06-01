<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">4</c:param>
</c:import>
<mtw:inputDateConfig/>
<mtw:useI18N />
<html>
<body>
<h1><mtw:i18n key="plan.title" /></h1>
<div class="spacer">&nbsp;</div>
<div class="crud">
 <form action="plan.update.mtw">
 <mtw:input name="id" type="hidden" value="${plan.id}"/>
 <div class="row">
  <span class="label"><mtw:i18n key="plan.responsible"/></span>
  <span class="formw">
   <mtw:select list="responsibleList" name="responsible.id"/>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="plan.task"/></span>
  <span class="formw">
   <mtw:select list="taskList" name="task.id"/>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="plan.date"/></span>
  <span class="formw">
   <mtw:inputDate id="releaseDate" name="releaseDate"  dateFormat="dd-mm-yyyy"/>
   <mtw:hasError><font color="red"><mtw:error field="releaseDate"/></font><br/></mtw:hasError>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="plan.priority"/></span>
  <span class="formw">
   <mtw:radiobuttons list="priority" name="priority" id="priority"/>
   <mtw:hasError><font color="red"><mtw:error field="priority"/></font><br/></mtw:hasError>
  </span>
 </div>
 <div class="row">
  <span class="label"><mtw:i18n key="plan.status"/></span>
  <span class="formw">
    <mtw:radiobuttons list="status" name="status" id="status"/>
    <mtw:hasError><font color="red"><mtw:error field="status"/></font><br/></mtw:hasError>
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

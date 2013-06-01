<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">4</c:param>
</c:import>
<mtw:useI18N />
<html>
<body>
<h1><mtw:i18n key="plan.title" /></h1>

<div class="spacer">&nbsp;</div>

<div id="navcontainer">
 <ul id="navlist">
 <mtw:list value="planList">
  <mtw:loop var="plan">
  <li>
	 	 <mtw:out value="plan.releaseDate" formatter="dateFormatter"/>
	 - <b><mtw:out value="plan.task.name"/></b>
	 - <mtw:out value="plan.responsible.name"/>
	 &nbsp;&nbsp;&nbsp;
     [<a href="plan.delete.mtw?id=<mtw:out value="plan.id"/>"><mtw:i18n key="global.delete" /></a>]
     [<a href="plan.show.mtw?id=<mtw:out value="plan.id"/>"><mtw:i18n key="global.update" /></a>]
  </li>
  </mtw:loop>
  <mtw:isEmpty>
   <li><mtw:i18n key="global.noRows" /></li>
  </mtw:isEmpty>
 </mtw:list>
 </ul>
</div>

<div class="spacer">&nbsp;</div>
 <a href="plan.executeAdd.mtw">[<mtw:i18n key="global.add" />]</a>
</body>
</html>

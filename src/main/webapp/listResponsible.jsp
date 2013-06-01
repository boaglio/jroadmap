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

<div id="navcontainer">
 <ul id="navlist">
 <mtw:list value="responsibleList">
  <mtw:loop var="responsible">
  <li>
	 <mtw:out value="responsible.name"/> - <mtw:out value="responsible.email"/>
	 &nbsp;&nbsp;&nbsp;
     [<a href="responsible.delete.mtw?id=<mtw:out value="responsible.id"/>"><mtw:i18n key="global.delete" /></a>]
     [<a href="responsible.show.mtw?id=<mtw:out value="responsible.id"/>"><mtw:i18n key="global.update" /></a>]
  </li>
  </mtw:loop>
  <mtw:isEmpty>
   <li><mtw:i18n key="global.noRows" /></li>
  </mtw:isEmpty>
 </mtw:list>
 </ul>
</div>

<div class="spacer">&nbsp;</div>
 <a href="addResponsible.jsp">[<mtw:i18n key="global.add" />]</a>
</body>
</html>

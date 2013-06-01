<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">2</c:param>
</c:import>
<mtw:useI18N />
<html>
<body>
<h1><mtw:i18n key="project.title" /></h1>

<div class="spacer">&nbsp;</div>

<div id="navcontainer">
 <ul id="navlist">
 <mtw:list value="projectList">
  <mtw:loop var="project">
  <li>
	 <mtw:out value="project.name"/> - <mtw:out value="project.description"/>
	 &nbsp;&nbsp;&nbsp;
     [<a href="project.delete.mtw?id=<mtw:out value="project.id"/>"><mtw:i18n key="global.delete" /></a>]
     [<a href="project.show.mtw?id=<mtw:out value="project.id"/>"><mtw:i18n key="global.update" /></a>]
  </li>
  </mtw:loop>
  <mtw:isEmpty>
   <li><mtw:i18n key="global.noRows" /></li>
  </mtw:isEmpty>
 </mtw:list>
 </ul>
</div>

<div class="spacer">&nbsp;</div>
 <a href="addProject.jsp">[<mtw:i18n key="global.add" />]</a>
</body>
</html>

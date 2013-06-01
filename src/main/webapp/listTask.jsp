<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="menuJRoadmap.jsp">
 <c:param name="op">3</c:param>
</c:import>
<mtw:useI18N />
<html>
<body>
<h1><mtw:i18n key="task.title" /></h1>

<div class="spacer">&nbsp;</div>

<div id="navcontainer">
 <ul id="navlist">
 <mtw:list value="taskList">
  <mtw:loop var="task">
  <li>
	 <mtw:out value="task.name"/> - <mtw:out value="task.project.name"/>
	 &nbsp;&nbsp;&nbsp;
     [<a href="task.delete.mtw?id=<mtw:out value="task.id"/>"><mtw:i18n key="global.delete" /></a>]
     [<a href="task.show.mtw?id=<mtw:out value="task.id"/>"><mtw:i18n key="global.update" /></a>]
  </li>
  </mtw:loop>
  <mtw:isEmpty>
   <li><mtw:i18n key="global.noRows" /></li>
  </mtw:isEmpty>
 </mtw:list>
 </ul>
</div>

<div class="spacer">&nbsp;</div>
 <a href="task.executeAdd.mtw">[<mtw:i18n key="global.add" />]</a>
</body>
</html>

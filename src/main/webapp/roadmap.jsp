<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<mtw:useI18N />
<html>
<body>
<h1 class="jroadmapH"><a href="about.jsp" class="jroadmap"><mtw:i18n key="roadmap.title"/></a></h1>
<c:import url="menuJRoadmapSort.jsp"/>
<br/>
<div id="ContentRoadmap">
 <table>
 <mtw:list value="roadmapList">
   <tr style="text-transform:uppercase">
	<th colspan="2"><mtw:i18n key="roadmap.priority"/></th>
	<th colspan="2"><mtw:i18n key="roadmap.task"/></th>
	<th colspan="2"><mtw:i18n key="roadmap.releaseDate"/></th>
	<th colspan="2"><mtw:i18n key="roadmap.responsible"/></th>
	<th><mtw:i18n key="roadmap.status"/></th>
   </tr>
  <mtw:loop var="roadmap">
   <tr>
	<td class="priority"><mtw:out value="roadmap.priorityDesc"/></td>
	<td>&nbsp;</td>
	<td class="task"><mtw:out value="roadmap.task.name"/></td>
	<td>&nbsp;</td>
	<td class="releaseDate"><mtw:out value="roadmap.releaseDate" formatter="dateFormatter"/></td>
	<td>&nbsp;</td>
	<td class="responsible"><mtw:out value="roadmap.responsible.name"/></td>
	<td>&nbsp;</td>
	<td class="status"><mtw:out value="roadmap.statusDesc"/></td>
   </tr>
  </mtw:loop>
   <mtw:out value="priorities"/>
 <mtw:isEmpty>
  <tr>
   <td><mtw:i18n key="global.noRows" /></td>
  </tr>
 </mtw:isEmpty>
</mtw:list>
</table>
</div>
</body>
</html>

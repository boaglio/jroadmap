<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<mtw:useI18N />
<html>
 <head>
  <link rel="stylesheet" href="jroadmap.css" type="text/css" />
</head>
</style>
 <c:set var="opt"><mtw:out value="op"/></c:set>
<div id="menu">
 <ul class="basictab">
  <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li><mtw:i18n key="roadmap.sortBy"/></li>
  <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li <c:if test="${opt==1}"> class="selected"</c:if> ><a href="roadmap.mtw"><mtw:i18n key="roadmap.task"/></a></li>
  <li <c:if test="${opt==2}"> class="selected"</c:if> ><a href="roadmap.priority.mtw"><mtw:i18n key="roadmap.priority"/></a></li>
  <li <c:if test="${opt==3}"> class="selected"</c:if> ><a href="roadmap.responsible.mtw"><mtw:i18n key="roadmap.responsible"/></a></li>
  <li <c:if test="${opt==4}"> class="selected"</c:if> ><a href="roadmap.status.mtw"><mtw:i18n key="roadmap.status"/></a></li>
  <li <c:if test="${opt==5}"> class="selected"</c:if> ><a href="roadmap.releaseDate.mtw"><mtw:i18n key="roadmap.releaseDate"/></a></li>
 </ul>
</div>

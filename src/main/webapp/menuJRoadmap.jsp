<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<mtw:useI18N />
<html>
 <head>
  <title></title>
  <link rel="stylesheet" href="jroadmap.css" type="text/css" />
</head>
</style>
<h1 class="jroadmapH"><a href="about.jsp" class="jroadmap"><mtw:i18n key="roadmap.title"/></a></h1>
<div id="menu">
 <ul class="basictab">
  <li <c:if test="${param.op==1}"> class="selected"</c:if> ><a href="<mtw:contextPath/><mtw:i18n key="menu.href1"/>"><mtw:i18n key="menu.link1"/></a></li>
  <li <c:if test="${param.op==2}"> class="selected"</c:if> ><a href="<mtw:contextPath/><mtw:i18n key="menu.href2"/>"><mtw:i18n key="menu.link2"/></a></li>
  <li <c:if test="${param.op==3}"> class="selected"</c:if> ><a href="<mtw:contextPath/><mtw:i18n key="menu.href3"/>"><mtw:i18n key="menu.link3"/></a></li>
  <li <c:if test="${param.op==4}"> class="selected"</c:if> ><a href="<mtw:contextPath/><mtw:i18n key="menu.href4"/>"><mtw:i18n key="menu.link4"/></a></li>
  <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li <c:if test="${param.op==5}"> class="selected"</c:if> ><a href="<mtw:contextPath/><mtw:i18n key="menu.href5"/>"><mtw:i18n key="menu.link5"/></a></li>
 </ul>
</div>

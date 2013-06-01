<%@ page isErrorPage="true" %>
<%@ taglib uri="/WEB-INF/mentawai.tld" prefix="mtw" %>
<mtw:useI18N />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <link rel="stylesheet" href="jroadmap.css" type="text/css" />
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
 </head>
 <div class="c">
  <h1 class="jroadmapH"><mtw:i18n key="error.title"/></h1>
 </div>
 <div class="spacer">&nbsp;</div>
 <div id="Content">
  <b><mtw:i18n key="error.message"/></b>:
 <%= exception.getMessage() %>
 </div>
<div class="spacer">&nbsp;</div>
 <div id="Content">
  <b><mtw:i18n key="error.exception"/></b>:
  <%= exception.toString() %>
 </div>
<div class="spacer">&nbsp;</div>
 <div id="Content">
  <b><mtw:i18n key="error.exceptionDetails"/></b>:
  <% exception.printStackTrace(new java.io.PrintWriter(out));%>
 </div>
</html>

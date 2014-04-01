<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>
</head>

<body>
<h2>Spring's form tags example</h2>

<form:form method="POST" action="oweApp/QueryCalList.so" >

<form:errors path="*" cssClass="errorblock" element="div"/>

<table>
<tr>
	<td>oweYm : </td>
	<td><form:input path="oweYm" /></td>
	<td><form:errors path="oweYm" cssClass="error" /></td>
</tr>
</table>
<input type="submit" />

</form:form>
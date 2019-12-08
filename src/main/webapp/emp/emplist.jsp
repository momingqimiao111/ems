<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2019/10/30
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link href="${path}/css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">


    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome! &nbsp;&nbsp;&nbsp;<span style="color: red;">${user.name}</span>
            </h1>
            <a href="${path}/dept/queryAll">返回主页</a>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Dept
                    </td>
                    <td>
                        Operation(处理删除的友情提醒)
                    </td>
                </tr>
                <c:forEach items="${emps}" var="emp">
                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${emp.bir}"/>
                        </td>
                        <td>
                                ${emp.dept.name}
                        </td>
                        <td>
                            <a href="javascript:if(confirm('确定要删除吗?'))location='${path}/emp/delete?id=${emp.id}'">delete
                                emp</a>&nbsp;
                            <a href="${path}/emp/selectOne?id=${emp.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="pagination">
                <span class="firstPage">&nbsp;</span> <span class="previousPage">&nbsp;</span>
                <span class="currentPage">1</span> <a
                    href="javascript:$.pageSkip(2);">2</a> <a
                    href="javascript:$.pageSkip(3);">3</a> <span class="pageBreak">...</span>
                <a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
                <a class="lastPage" href="javascript: $.pageSkip(6);">&nbsp;</a>
                <span class="pageSkip"> 共${maxPage}页 到第<input id="pageNumber"
                                                              name="pageNumber" value="1" maxlength="9"
                                                              onpaste="return false;">页
								<button type="submit">&nbsp;</button>
						</span>(请在全部功能完成后在处理分页)
            </div>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/emp/addEmp.jsp'"/>
            </p>
        </div>
    </div>

    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>


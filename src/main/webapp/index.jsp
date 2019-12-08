<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/upload/upload" method="post" enctype="multipart/form-data">

    <input type="file" name="aaa"><input type="submit" value="上传">
</form>


<a href="">bear.jpg</a>
</body>
</html>

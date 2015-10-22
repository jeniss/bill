<%--
  Created by IntelliJ IDEA.
  User: jennifert
  Date: 2015/10/21
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title></title>
    <style type="text/css">
        .img-container {
            overflow: hidden
        }

        .img-container > img {
            display: block;
            width: 100%
        }

        .img-container > .fix-height {
            width: auto;
            height: 100%
        }
        .img-container{
            width: 500px;
            height: 600px;
        }
    </style>
</head>
<body>
hahhaha111111111: ${content}

<div class="l-u">
    <div class="img-container">
        <img src="<c:url value="/resources/images/Lighthouse.jpg" />">
    </div>
</div>
<script src="<c:url value='/resources/script/command.js'/>" type="text/javascript"></script>
<script type="text/javascript">
    window.onload = function () {
        var imgContainer = document.querySelectorAll('.img-container');
        for (var i in imgContainer) {
            if (i < imgContainer.length) {
                imageAdapt(imgContainer[i]);
            }
        }
    }
</script>
</body>
</html>

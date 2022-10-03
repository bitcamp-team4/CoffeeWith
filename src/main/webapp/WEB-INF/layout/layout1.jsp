<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
          rel="stylesheet">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <title>Layout1</title>

    <style type="text/css">
        * {
            font-family: 'Jua';
        }

        body {
            font-family: 'Jua';
            font-size: 20px;
        }

        .main_layout1 {
            display: flex;
            flex-direction: column;
        }

        a:link, a:visited {
            text-decoration: none;
        }

        a:hover {
            cursor: pointer;
        }

        #header {
            height: 90px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="main_layout1">
    <div class="main" id="header">
        <tiles:insertAttribute name="header"/>
    </div>
    <hr>
    <div class="main" id="main">
        <tiles:insertAttribute name="main"/>
    </div>
</div>
</body>
</html>
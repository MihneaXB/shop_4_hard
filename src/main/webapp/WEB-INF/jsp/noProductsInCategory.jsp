<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Atentie</h2>
<p style="color: red; font-weight: bold;">
        ${errorMsg}
</p>
<br>

<video width="480" height="270" autoplay muted loop playsinline>
        <source src="<c:url value='/static/video/error_404_2.mov' />" type="video/webm">
        Browserul tău nu suportă formatul video webm.
</video>
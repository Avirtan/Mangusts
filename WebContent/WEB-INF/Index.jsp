<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- <%@include file='pattern/header.jsp' %> --%>
<!--Это без регистрации  -->
	<c:if test="${empty sessionScope.user  }">
    <a href="Login">
        <div class="vhod">
            <p>Вход</p>
        </div>
    </a>
    <a href="Reg">
        <div class="reg">
            <p>Регистрация</p>
        </div>
    </a>
    </c:if>
    <c:if test="${not empty sessionScope.user  }">
    <!--Это с регистрацией  -->
    <a href="Profile">
                <div class="reg">
                <p>Профиль</p>
                </div>
            </a>
     </c:if>
<c:import url="pattern/header.jsp" />
<section>
        <div class="content">
	        <c:forEach items="${requestScope.post}" var="p" >
				     <a href="Post?p=${p.getId()}">
			              <div class="block">
			              <c:out value="${ p.getTitle() }"></c:out>
			                <p> <c:out value="${ p.getText() }"/></p>
			          </div>
			</c:forEach>
            
            </a>
        </div>
</section>

<c:import url="pattern/footer.jsp" />
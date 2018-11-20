<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="pattern/header.jsp" />
<section>
        <div class="content">
                <div class="block">
                	<c:if test="${not empty requestScope.title}">
	                	<h2><c:out value="${requestScope.title}"/></h2>
	                    <p><c:out value="${requestScope.text}"/></p>
	                    <br>
	                    <br>
	                    <h3>Комментарии : </h3>
	                    <c:forEach items="${requestScope.users_comments}" var="u">
							<h4>Что нам скажет <c:out value="${u[0]}"/>:</h4>
	                    		<c:out value="${u[1]}"/>
	                    </c:forEach>
	                    <br><br>
	                    <c:if test="${not empty sessionScope.user  }">
	                    Может ты хочешь нам что-то сказать:
	                     <form class="comment" action="Post" method="post">
	                        <input type="text" name="comm" value=""  size="50px">
	                        <p><input type="submit" name="otprComm" value="Оставить комментарий" ></p>
	                    </form>
	                    </c:if>
	                    <c:if test="${empty sessionScope.user  }">
	                    	Для комментирования надо зарегистрироваться 
	                    </c:if>
	                    <br><br>
                    </c:if>
                    <c:if test="${empty requestScope.title}">
                    	<H1 Style="color:red" align="center">Неверный запрос или пост ещё не создан</H1>
                    </c:if>
                </div>
        </div>
    </section>


<c:import url="pattern/footer.jsp" />
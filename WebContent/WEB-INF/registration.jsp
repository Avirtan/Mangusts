<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="pattern/header.jsp" />

<section>
        <div class="content">
            <div class="block">
                <p>Придумайте логин: </p>
                <p>
                <form class="registr" action="Reg" method="post">
	                 <input type="text" name="login" value=""> </p>
	                <!-- <p>Введите email:</p>
	                <p><input type="text" name="email" value=""> </p> -->
	                <p>Введите пароль: </p>
	                <p> <input type="password" name="pass_1" value="" > </p>
	                <p>Подтвердите пароль: </p>
	                <p> <input type="password" name="pass_2" value="" > </p>
	                <p> <input type="submit" name="sub" value="Зарегистрироваться"> </p>
                </form>
               <ul>
               <c:forEach items="${requestScope.error}" var="error" >
				    	<li><c:out value="${ error }"></c:out></li>
				</c:forEach>
				</ul>
            </div>
        </div>
    </section>

<c:import url="pattern/footer.jsp" />
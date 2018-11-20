<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="pattern/header.jsp" />

<section>
        <div class="content">
            <div class="block">
                <form class="formVhod" action="Login" method="post">
                    <p>Введите логин:</p>
                    <input type="text" name="login" value="" >
                    <p>Введите пароль:</p>
                    <input type="password" name="password" value="" >
                    <p><input type="submit" name="log" value="Войти" ></p>
                </form>
            </div>
        </div>
</section>

<c:import url="pattern/footer.jsp" />
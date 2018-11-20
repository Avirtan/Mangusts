<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
 <c:import url="pattern/header.jsp" />
 <section>
        <div class="content">
            <div class="block">
                <p class="nickInProfil"><c:out value="${sessionScope.user }"/></p>
                <p class="infaInProfil">!Сюда помещать уже указанную ранее инфу!</p>
                <p>Расскажите о себе, укажите ваши интересы:</p>
                <form class="aboutUser" action="index.html" method="post">
                    <p> <input type="text" name="infa" value="" form="aboutUser" size="50px"> </p>
                    <p> <input type="submit" name="" value="Добавить информацию" form="aboutUser"> </p>
                </form>
                <div class="">
                    <form class="vyhod" action="Profile" method="post">
                        <input type="submit" name="exit" value="Выход из профиля">
                    </form>
                </div>
            </div>
        </div>
    </section>
 <c:import url="pattern/footer.jsp" />
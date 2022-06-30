<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - SB Admin</title>
        <link href="../Admin/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                                    <div class="card-body">
                                        <form method="post" action="../controler/login.do">
                                            <div class="form-floating mb-3">
                                                <input name="ID" class="form-control" id="inputEmail" type="text" placeholder="아이디입력" />
                                                <label for="inputEmail">아이디입력</label>
                                            </div>
                                            <div class="form-floating mb-3" style="margin-bottom: 0px;">
                                                <input name="Pass" class="form-control" id="inputPassword" type="password" placeholder="Password" />
                                                <label for="inputPassword">패스워드입력</label>
                                            </div>
                                            <c:if test="${sucessOrfail == false }">
                                            <div class="col" style="color: red; font-weight:bolder font-size: 11px;">로그인정보가 알맞지않습니다 다시로그인해주세요</div>
                                            </c:if>
                                            <div class="form-check mb-3" style="padding-top: 10px;">
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="password.html">비밀번호를 잊어버리셨나요?</a>
                                                <button class="btn btn-primary" type="submit">로그인</button>
                                            </div>
                                            <c:if test="${ not empty requestScope.controllerPassURI }">  
                                            <div><input type="text" name="controllerPassURI" value="${requestScope.controllerPassURI }" /></div>                                       
                                          </c:if>                                          
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/AdminTest/Admin/noadmin/register.jsp">계정이 없으신가요? 지금 가입하세요!</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../Admin/js/scripts.js"></script>
    </body>
</html>

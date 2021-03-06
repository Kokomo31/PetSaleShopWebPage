<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Register - SB Admin</title>
        <link href="../css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form method="post" action="/AdminTest/controler/regist.do">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                <div class="form-floating">
                                                    <input name="user_name" class="form-control" id="inputLast" type="text" placeholder="이름을 입력하세요" />
                                                    <label for="inputLast">이름</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 ">
                                                <input name="user_gender" class="form-check-input" type="checkbox" value="남자" id="flexCheckDefault">남자
                                                <input name="user_gender" class="form-check-input" type="checkbox" value="여자" id="flexCheckDefault">여자
                                            </div>
                                        </div>
                                            <div class="form-floating mb-3">
                                                <input name="user_id" class="form-control" id="inputEmail" type="text" placeholder="name@example.com" />
                                                <label for="inputEmail">아이디</label>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input name="user_pass" class="form-control" id="inputPassword" type="password" placeholder="Create a password" onkeyup="passconfirm();"/>
                                                        <label for="inputPassword">패스워드</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputPasswordConfirm" type="password" placeholder="Confirm password" onkeyup="passconfirm();" />
                                                        <label for="inputPasswordConfirm">패스워드 확인</label>
                                                    </div>
                                                    <div id="iswrong" style="color: red;">비밀번호가 서로 맞지않습니다.</div>
                                                </div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input class="btn btn-primary btn-block" type="submit" value="가입하기"></div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        
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
        <script>
            
            
            function passconfirm(){
                if(document.querySelector('#inputPassword').value ==  document.querySelector('#inputPasswordConfirm').value ){
                   
                    document.querySelector('#iswrong').style.display = 'none';
                }
               else{
                   document.querySelector('#iswrong').style.display = 'block';
               }
            }
            
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
    </body>
</html>

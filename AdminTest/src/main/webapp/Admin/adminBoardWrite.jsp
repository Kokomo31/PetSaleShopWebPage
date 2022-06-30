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
        <title>분양글작성</title>
        <link href="../Admin/css/styles.css" rel="stylesheet" />
    <style>
    #paging{
    display: flex;
    justify-content: center;
    }
    li{
    list-style: none;
    }
    .row{
    padding: 10px;
    }
    </style>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body>
       <%@ include file="topnav.jsp" %>
        <div id="layoutSidenav">
				<%@ include file="sidenav.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">분양글작성 </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">분양글 작성</li>
                           
                        </ol>
                        	<form name="fileForm" method="post" enctype="multipart/form-data" action="../controler/adminboardwrite.do">
                        	<div class="container border  border-success">
                        		<div class="row border border-dark">
                        			<div class="col">제목:<input name="b_title" type="text" /> </div>
                        			<div class="col">이름:<input name="a_name" type="text" /></div>
                        			<div class="col">성별:<input name="a_gender" type="text" /></div>
                        		</div>
                        		<div class="row border border-dark">
                        			<div class="col-12">건강:<input name="a_health" size="80" type="text"  /> </div>
                        			
                        		</div>
                        		<div class="row border border-dark">
                        			<div class="col">가격:<input name="a_price" type="text" /> </div>
                        			<div class="col">종류:<input name="a_type" type="text" /></div>
                        			<div class="col">품종:<input name="a_species" type="text" /></div>
                        		</div>
                        		<div style="justify-content: center;" class="row border border-dark">
                        			<div class="col-6">이미지파일<input type="file" name="attachedFile"  /> </div>
                        			<div><textarea style="width: 100%" name="content" id="" cols="30" rows="10"></textarea></div>
                        			<div class="col-6" style="display: flex; justify-content: center;"><input type="submit" value="전송하기" /></div>
                        		</div>
                        	</div>   
                           </form>           
                </main>
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
        <script src="../Adminjs/script.js"></script>
    </body>
</html>

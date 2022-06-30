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
        <title>게시글 상세보기</title>
        <link href=" 
        <c:choose>
   		 	<c:when test="${ not empty boardLists }">
   			 ../Admin/css/styles.css /AdminTest/Admin/css/styles.css
    		</c:when>
    		<c:otherwise>
     		/AdminTest/Admin/css/styles.css
     		</c:otherwise>
    </c:choose>" rel="stylesheet" />
    <c:if test="${empty sessionScope.user_id }">
        <script>
            window.onload = function(){                 	
           	document.querySelector('body').style.opacity = 0.2;
            location.href ="../Admin/login.jsp";
             
            };  
        </script>
        </c:if>
    <style>
    #paging{
    display: flex;
    justify-content: center;
    }
    li{
    list-style: none;
    }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body>
       <%@ include file="shopnavbar.jsp" %>
        <div id="layoutSidenav">
				<%@ include file="sidenav.jsp" %>
            <div id="layoutSidenav_content"  style="background-color: #B1F2D0;">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">게시글 작성 </h1>                       
                        <div class="container">
                        	<div class="row" style="background-color: #F8F8F8; border-bottom:1px solid #CCCCCC;">
                        		<div class="col col-lg-2" style="padding-left: 40px">${dto.board_author }</div>
                        		<div class="col" style="text-align: center;">${dto.board_regdate }</div>                        		
                        		<div class="col col-lg-2" style="display: flex; flex-grow: 1;">
                        			<div style="flex-grow: 0.5; text-align:right;"></div>
                        			<div style="flex-grow: 0.5; text-align:center;"></div>                      		
                        		</div>
                        	</div>
                        	<form method="post" action="/AdminTest/controler/boardwrite.do">
                        	<div class="row" style="height:50px; background-color: #F8F8F8;  align-content: center;">
                        		<div class="col"><select name="category" class="selectpicker">
                    		<option value="">카테고리지정</option>
                    		<option value="2">분양글</option>
    						<option value=3>질문글</option>
    						<option value="1">자유게시글</option>
                    	</select></div>
                        		<div class="col" style="text-align: right; padding-right: 80px;">
                        		<a class="link-success" style="text-decoration: none;" href="../controler/boardlist.do">목록으로</a>
                        		 
                        		</div>
                        	</div>
                        	<div class="row" style="height:100px; background-color: #F1F1F1; color: #A52A2A;  align-items: center;">
                        		제목: <input name="title" type="text" />
                        	</div>
                        	<div class="row" style="background-color: #FFFFFF; padding-top: 20px;">                        	
                        		<textarea name="content" id="" cols="10" rows="30"></textarea>    
                        		
                        	</div>       
                        	
                        	     	
                        	<div class="row"><input class="btn btn-danger btn-block" type="submit" value="게시글작성완료"  /></div>
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
        <script src="
        	<c:choose>
   		 		<c:when test="${ not empty boardLists }">
   			 	../Adminjs/script.js
    			</c:when>
    			<c:otherwise>
   				/AdminTest/Admin/js/scripts.js 			
    			</c:otherwise> 			
   			 </c:choose>"></script>
    </body>
</html>

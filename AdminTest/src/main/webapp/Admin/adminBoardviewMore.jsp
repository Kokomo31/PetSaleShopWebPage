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
   			 ../Admin/css/styles.css
    		</c:when>
    		<c:otherwise>
     		../Admin/css/styles.css    		
     		</c:otherwise>
    </c:choose>" rel="stylesheet" />
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
       <%@ include file="topnav.jsp" %>
        <div id="layoutSidenav">
				<%@ include file="sidenav.jsp" %>
            <div id="layoutSidenav_content"  style="background-color: #B1F2D0;">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">게시글 상세보기 </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item "><a href="../controler/boardlist.do">게시판 관리</a></li>
                            <li class="breadcrumb-item active">게시글 상세보기</li>                          
                        </ol>
                        <c:if test="${ not empty dto }"></c:if> 
                        <div class="container">
                        	<div class="row" style="background-color: #F8F8F8; border-bottom:1px solid #CCCCCC;">
                        		<div class="col col-lg-2" style="padding-left: 40px">${dto.board_author }</div>
                        		<div class="col" style="text-align: center;">${dto.board_regdate }</div>                        		
                        		<div class="col col-lg-2" style="display: flex; flex-grow: 1;">
                        			<div style="flex-grow: 0.5; text-align:right;">조회수:${dto.board_viewcount }</div>
                        			<div style="flex-grow: 0.5; text-align:center;">추천수:${dto.board_like }</div>                      		
                        		</div>
                        	</div>
                        	<div class="row" style="height:50px; background-color: #F8F8F8;  align-content: center;">
                        		<div class="col">[${dto.board_category }]</div>
                        		<div class="col" style="text-align: right; padding-right: 80px;">
                        		<a class="link-success" style="text-decoration: none;" href="../controler/boardlist.do">목록</a> |댓글()
                        		</div>
                        	</div>
                        	<div class="row" style="height:100px; background-color: #F1F1F1; color: #A52A2A;  align-items: center;">
                        		<div class="col" ><h2>${dto.board_title }</h2></div>
                        	</div>
                        	<div class="row" style="background-color: #FFFFFF; padding-top: 20px;">                        	
                        		${dto.board_content }    
                        		
                        	</div>       
                        	<div class="row" style="flex-grow: 1; background-color: #FFFFFF;">
                        	<div class="col"></div>
                        	<i class="bi bi-heart" 
                        	id="like" style="font-size:45px; background-color: #FFFFFF; 
                        	 width: 67.5px; text-align: center;" onclick="likefunc();"></i>
                        	<div class="col" id="likeNum" style="display: flex; align-items: center;">11</div>
                        	</div>         
                        	     	
                        	<div class="row"><input class="btn btn-danger btn-block" type="button" value="게시글삭제" onclick="location.href='../controler/delete.do?checkedvalue=${dto.board_num}'" /></div>
                                            
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
        <script>
            function likefunc(){
                let likeNum = parseInt(document.querySelector("#likeNum").innerHTML);
               
                if( document.querySelector("#like").className =="bi bi-heart-fill"){
                    document.querySelector("#like").className = 'bi bi-heart';
                    document.querySelector("#likeNum").innerHTML = likeNum-1;
                }
                else{
                	 document.querySelector("#like").className = 'bi bi-heart-fill';
                	 document.querySelector("#likeNum").innerHTML = likeNum+1;
                }
            
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="
        	<c:choose>
   		 		<c:when test="${ not empty boardLists }">
   			 	../Adminjs/script.js
    			</c:when>
    			<c:otherwise>
   				 ../Adminjs/script.js    			
    			</c:otherwise> 			
   			 </c:choose>"></script>
    </body>
</html>

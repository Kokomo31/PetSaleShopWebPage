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
        <title>게시판관리</title>
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
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body>
       <%@ include file="topnav.jsp" %>
        <div id="layoutSidenav">
				<%@ include file="sidenav.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">게시판 관리 </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">게시판 관리</li>
                             <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <form action="../controler/boardlist.do">
                	<div class="input-group" >                		               		
                    	<select name="searchKeyWord" class="selectpicker">
                    		<option value="">찾을항목지정</option>
                    		<option value="c.cate_name">카테고리</option>
    						<option value="m.m_name">작성자</option>
    						<option value="board_title">제목</option>
                    	</select>
                    	<input class="form-control" name="searchWord" type="text" placeholder="검색할 단어를 입력해주세요" aria-label="Search for..." aria-describedby="btnNavbarSearch"  style="width: 283px;"/>                		
                    	<button class="btn btn-primary" id="btnNavbarSearch" type="submit"  ><i class="fas fa-search"></i></button>                
                	</div>
            	</form>
            </form>
                        </ol>
                        <div class="card mb-4">
                           <table class="table table-bordered" style="text-align: center;">
                           <thead>
                           	<tr>
                           		<th> </th>
                           		<th class="col">글번호</th>
                           		<th class="col">글작성자</th>
                           		<th class="col">제목</th>                           	
                           		<th class="col">조회수</th>
                           		<th class="col">관심수</th>
                           		<th class="col">카테고리</th>
                           		<th class="col">등록시간</th>                           		
                           	</tr>
                           </thead>
                           <tbody>     
                           <form action="../controler/delete.do">                 
                           <c:if test="${ not empty boardLists }">
                           <c:forEach items="${boardLists }" var="list" varStatus="loop">
                           	<tr>
                           		<th><input type="checkbox" name="checkedvalue" value="${list.board_num }"/></th>
                           		<th class="col">${list.board_num }</th>
                           		<td>${list.board_author }</td>
                           		<td><a class="link-success" style="text-decoration: none;" href="../controler/moreview.do?viewNum=${list.board_num }">${list.board_title }</a></td>
                           		<td>${list.board_viewcount }</td>
                           		<td>${list.board_like }</td>
                           		<td>${list.board_category }</td> 
                           		<td>${list.board_regdate }</td>                                   
                           	</tr>
                           	</c:forEach>
                          </c:if>
                           </tbody>
                           <tfoot> 
                           <tr>
                           <td colspan="8"><input class="btn btn-danger btn-block" type="submit" value="게시글삭제" /></td>  
                           </form>                        
                           </tr>
                           </tfoot>          
                           </table>
                        </div>   
            <div id="paging">${pagingStr }</div>
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
   				 ../Adminjs/script.js    			
    			</c:otherwise> 			
   			 </c:choose>"></script>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <style type="text/css">
    #page-content-wrapper{
    flex-grow: 1;
    }
    #paging{
    list-style: none;
    display: flex;
    justify-content: center;
    }
    </style>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
     	<c:if test="${not empty boardLists }">
     	<link href="../Admin/css/styles.css" rel="stylesheet" />
     	</c:if>
        <link href="../css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <div class="d-flex" id="wrapper" style="flex-shrink: 0; flex-grow: 1">
            <!-- Sidebar-->
            <%@ include file="sidenav.jsp" %>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <%@ include file="shopnavbar.jsp" %>
                <!-- Page content-->
                <div class="container-fluid" style="display: flex; flex-flow: column;">
                      <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" style="padding-bottom: 20px; margin-left: 0px">
                <form method="get" action="/AdminTest/controler/boardlist.do" >
                	<div class="input-group" >                		               		
                    	<select name="searchKeyWord" class="selectpicker">
                    		<option value="">찾을항목지정</option>
                    		<option value="c.cate_name">카테고리</option>
    						<option value="m.m_name">작성자</option>
    						<option value="board_title">제목</option>
                    	</select>
                    	<input class="form-control" name="searchWord" type="text" placeholder="검색할 단어를 입력해주세요" aria-label="Search for..." aria-describedby="btnNavbarSearch"  style="width: 283px;"/>                		
                    	<button class="btn btn-primary" id="btnNavbarSearch" type="submit"  ><i class="fas fa-search"></i>검색</button>                
                	</div>
            	</form>
            </form>
                        
                        <div class="card mb-4">
                           <table class="table table-bordered" style="text-align: center;">
                           <thead>
                           	<tr>
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
                           <c:if test="${ not empty boardLists }">
                           <c:forEach items="${boardLists }" var="list" varStatus="loop">
                           	<tr>  		
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
                             <td colspan="8"><input class="btn btn-primary btn-block" type="button" value="게시글작성" onclick="location.href='/AdminTest/Admin/noadmin/writeboard.jsp'" /></td>           
                              <div id="paging">${pagingStr }</div>                      
                           </tr>
                           </tfoot>          
                           </table>
                        </div>   
                        
                </div>
                
            </div>
        </div>
        <%@ include file="footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        
        <c:if test="${not empty boardLists }">
     	<script src="../Admin/js/scripts.js"></script>
     	</c:if>
      	<script src="../js/scripts.js"></script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>
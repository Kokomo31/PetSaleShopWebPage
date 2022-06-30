<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.sb-sidenav-menu{
display: flex;
}
.nav{

box-sizing:border-box;


}
.nav:last-child{
justify-content: space-between;
}
.nav-link{
justify-content: center;
font-size: 15px;
width: 150px;
}
#wrapper{
height: 100%;
}
#sb-sidenav-menu-heading{

}
#collapseLayouts{
width: 150px;
}
.sb-sidenav-menu-nested nav{
margin: 0px
}
</style>
<body>
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="../Admin/index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                홈
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                유저게시판
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/AdminTest/controler/boardlist.do">자유게시판</a>
                                    <a class="nav-link" href="../controler/list.do">Q/A</a>
                                </nav>
                            </div>                           

                             <div class="sb-sidenav-footer">
                       		 	<div class="small">Logged in as:</div>
                        		Start Bootstrap
                    		</div>
                            </div>
		               </nav>
            </div>
</body>
</html>
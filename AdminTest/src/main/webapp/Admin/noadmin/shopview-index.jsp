<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        <style type="text/css">
        #banner{
     	  background-image: url('/AdminTest/Uploads/놀숲.jpg') ;
     	  background: no-repeat ;
        }
        </style>
    </head>
    <body>
        <!-- Navigation-->
       <%@ include file="shopnavbar.jsp" %>
        <!-- Header-->
        <header id="banner" style="display: flex; align-items: center; justify-content: space-between; " class="bg-dark py-5">
            <button style="color: whitesmoke; font-size: 100px; background-color: #F2B900; float: left; height: 100%; "> < </button>
           
            <button style="color: whitesmoke; font-size: 100px; background-color: #F2B900; float: right; height: 100%;"> > </button>
        </header>
        <!-- Section-->
        <section class="py-5" >
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-flex-start" id="list">
                           
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="../js/scripts.js"></script>
        <script>
            count = 8;
            pages = 1;
            console.log(count);
            window.onload = function(){
                loadAJAX(pages);

            }
            window.onscroll = function(){
                if(getScrollTop() < getDocumentheight()*0.98 - window.innerHeight) return;
                if(count ==0 ){
                    return;
                }
                else
                loadAJAX(++pages);

                };
            
        function loadAJAX(){
            
            
            $.ajax({
                url:'../../controler/petboardlist.do',
                data: {"pageNum" : pages} ,
                type:"GET",
                dataType:"text"
            })
            .done(function(text){
                
                console.log(text);
                var obj = JSON.parse(text);
                var boardLists =obj.boardLists;
                var petInfo = boardLists.petsobj;
                count = Object.keys(boardLists).length; 
                console.log(count+"after");
                for(var i=0; i< count; i++) {
                	var appendStr = "";
                    appendStr +='<div class="col mb-5">';
                    appendStr +='<div class="card h-100">'
                    appendStr +='<img class="card-img-top" src="/AdminTest/Uploads/'+boardLists[i].board_img+'" alt="..." />' 
                    appendStr +='<div class="card-body p-4">  <div class="text-center">'
                    appendStr +='<h5 class=fw-bolder>'+boardLists[i].petsobj[i].pet_name+'</h5>'
                    appendStr +='분양가:'+boardLists[i].petsobj[i].pet_price+'<br>'
                    appendStr +='품종:'+boardLists[i].petsobj[i].pet_species
                    appendStr +='</div> </div>'
                    appendStr +='<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">'
                    appendStr +='<div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/AdminTest/control/">자세히 보기</a></div></div></div></div>'  
               		$("#list").append(appendStr);
                }
					//pages++;
            })
        }
        function getScrollTop(){
            return window.pageYOffset
        }
        function getDocumentheight() {
           const body = document.body;
           const html = document.documentElement 

           return Math.max(
            body.scrollHeight,
            body.offsetHeight,
            html.clientHeight,
            html.scrollHeight,
            html.offsetHeight
          );
        }                 
        </script>
    </body>
</html>

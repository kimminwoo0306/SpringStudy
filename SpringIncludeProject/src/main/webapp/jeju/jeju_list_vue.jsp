<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
h1{
   text-align: center
}
.ddd:hover{
  cursor: pointer
}
</style>
</head>
<body>
   <div class="container-fluid">
      <div class="col-sm-3">
        <div class="jumbotron">
        </div>
        
        <table class="table" v-for="vo in jeju_list">
				<tr>
								<td width=30% class="text-center" rowspan="4"><img
									:src="vo.poster" style="width: 100%" class="img-rounded ddd"
									v-on:click="jejuDetail(vo.no)"></td>
								<td width=70%>
									<h3 v-on:click="jejuDetail(vo.no)" class="ddd">
										{{vo.title }}
									</h3>
								</td>
				</tr>
			</table>
			</div>
			</div>
			<div class="col-sm-5" v-show="isShow">
			<table class="table">
				<tr>

					<td v-for="img in posters"><img :src="img"
						style="width: 100%"></td>

				</tr>
			</table>
			<div style="height: 20px"></div>
			<table class="table">
				<tr>
					<td colspan="2">
						<h3>
							{{vo1.title }}&nbsp;<span style="color: orange">{{vo1.score
								}}</span>
						</h3>
					</td>
				</tr>
				<tr>
					<th width=10%>주소</th>
					<td width=90%>{{vo1.addr }}</td>
				</tr>
				<tr>
					<th width=10%>전화</th>
					<td width=90%>{{vo1.tel }}</td>
				</tr>
				<tr>
					<th width=10%>음식종류</th>
					<td width=90%>{{vo1.type }}</td>
				</tr>
				<tr>
					<th width=10%>가격대</th>
					<td width=90%>{{vo1.price }}</td>
				</tr>
				<tr>
					<th width=10%>주차</th>
					<td width=90%>{{vo1.parking }}</td>
				</tr>
				<tr>
					<th width=10%>영업시간</th>
					<td width=90%>{{vo1.time }}</td>
				</tr>

			</table>
		</div>
    <script>
     new Vue({
    	 el:'.container-fluid',
    	 data:{
    		 jeju_list:[],
    		 vo1 :{},
    		 isShow:false
    	 },
    	 mounted:function(){
    		 let _this=this
    		 axios.get('http://localhost/web/jeju/jeju_list_vue.do',{
    			 params:{
    			 }
    		 // then => success:function(response)
    		 }).then(function(response){
    			 // response=>json
    			 console.log(response.data)
    			 _this.jeju_list=response.data;
    			 
    		 })
    	 },
    	 // http://localhost/web/food/category_vue.do?no=1
    	 methods:{
    		 jejuDetail:function(no){
    			 this.isShow=true
    			 let _this=this
        		 axios.get('http://localhost/web/jeju/jeju_detail_vue.do',{
        			 params:{
        				 no:no
        			 }
        		 // then => success:function(response)
        		 }).then(function(response){
        			 // response=>json
        			 console.log(response.data)
        			 _this.vo1=response.data;
        			 _this.posters = _this.vo1.poster
					 _this.menus = _this.vo1.menu
        		 })
    		 }
    		 
    	 }
     })
    </script>
</body>
</html>
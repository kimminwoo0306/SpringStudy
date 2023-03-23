<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<body>
	<div class="untree_co-section details" style="background-color: orange">
		<div class="container" style="background-color: pink">
			<h2 class="text-center">${vo.name}</h2>
			<div class="row mb-5">
		    <div class="col-lg-3 order-1" style="background-color: yellow">
	      	  <table class="table" style="float: center">
	      	  	<tr>
	      	  		<td ><img src="${vo.poster }" style="width: 230px; height: 230px;"></td>
	      	  	</tr>
	      	  	<tr>
	      	  		<td >${vo.name }</td>
	      	  	</tr>
	      	  	<tr>
	      	  		<td >회원수 ${vo.head }명 </td>
	      	  	</tr>
	      	  </table>
	      	  
	    	</div>
	    <div class="col-lg-6 order-2" style="background-color: green">
	    <div style="height: 20px"></div>
	      <textarea rows="1" cols="40" style="float: center"></textarea>
	      <div style="height: 20px"></div>
	       <!--======= 글쓰기 =========-->
	      
	       <div class="row">
	         <div>
		      <b-button block variant="outline-secondary" style="background-color: white; height: 100px " id="show-btn" v-on:click="showModal()">새로운 소식을 남겨보세요</b-button>
		      <b-modal ref="my-modal" hide-footer title="글쓰기">
		     		<table class="table app">
		     		 <tr>
					  	<th width=15% class=text-right>내용</th>
					  	<td width=85%>
					  		<textarea rows="10" cols="80" v-model="content"></textarea>
					  		<input type=hidden  v-model="rno" value=${vo.no } >
					  	</td>
					  </tr>
					  <tr>
					  	<th width=15% class=text-right>첨부파일</th>
					  	<td width=85%>
					  		<table class="table">
					  			<tr>
					  			  <td class="text-right">
					  			  	<input type=button value="추가" class="btn btn-xs btn-info" id="addBtn" v-on:click="addFile()">
					  			  	<input type=button value="취소" class="btn btn-xs btn-warning" id="removeBtn" v-on:click="removeFile()">
					  			  </td>
					  			</tr>
					  		</table>

					  			
					  		     <table id="user-table">
							     <tr v-for="(file, index) in fileList" :key="index">
							       <td width="20%">File {{ index + 1 }}</td>
							       <td width="80%"><input type="file" v-model="fileList[index]" name="files[]"></td>
							     </tr>
							   </table>
					  		<tr>
						  	<td colspan="2" class="text-center">
						  		<input type="submit" value = "전송" class="btn btn-sm btn-danger" v-on:click="insert()">
						  		<input type="button" value = "취소" class="btn btn-sm btn-warning" v-on:click="hideModal()">
						  	</td>
						  </tr>
		     		</table>
		     </div>
	      </div>
	      <div style="height: 50px"></div>
	      
	      <div class="row">
	      	 <input type="button" value = "글 보기" class="btn btn-sm btn-warning" v-on:click="send()">
		      <table class="table">
			       <tr v-for="rvo in regularBoard_list">
			        <td width="15%" class="text-center">아이디</td>
			        <td width="20%" class="text-center">{{rvo.dbday}}</td>
			        <td width="45%">{{rvo.content}}</td>
			        <td width="10%" class="text-center">{{rvo.rno}}</td>
			      </tr>
			      <tr>
			        <td colspan="5" class="text-center">
			          <input type="button" value="이전"class="btn btn-sm btn-danger" v-on:click=prev()>
			            {{curpage}} page / {{totalpage}} pages
			          <input type="button" value="다음"class="btn btn-sm btn-warning" v-on:click=next()>
			        </td>
			      </tr>
			    </table>
		    </div> 
	    </div>
	    
	    
	    </div>
  	  </div>
	</div>
	<script>
	console.log("detaillll")
 	new Vue({
		el:'.details',
		data:{
		     fileList: [],
		     curpage:1,
			 totalpage:0,
			 regularBoard_list:[],
			 content:'',
			 rno:${vo.no}
		},
		
		methods:{
			showModal:function(){
				this.$refs['my-modal'].show()
			},
			hideModal:function(){
				this.fileList.splice(0),
				this.$refs['my-modal'].hide()
			},
			
			addFile:function() {
			      this.fileList.push(null);
		    },
		    removeFile:function() {
		      if (this.fileList.length > 0) {
		        this.fileList.pop();
		      }
		    },
		    send:function(){
				let _this = this
				console.log("cur:"+this.curpage)
				console.log("rno:"+this.rno)
				axios.get("http://localhost:8080/web/regular/detail_vue.do",{
					params:{
						rno:this.rno,
						page:this.curpage
					}
				}).then(function(response){
					console.log(response.data)
					_this.regularBoard_list = response.data;
					_this.curpage=response.data[0].curpage;
		            _this.totalpage=response.data[0].totalpage;
				})
			},
		    prev:function(){
		           this.curpage=this.curpage>1?this.curpage-1:this.curpage;
		           this.send()
	        },
	        next:function(){
	           this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
	           this.send()
	        },
	        insert:function(){
	        	let _this = this;
	        	axios.get('http://localhost:8080/web/regular/board_insert_vue.do',{
	        		params:{
	        			content:this.content,
	        			rno:this.rno
	        		}
	        	}).then(function(response){
	        		alert(response.data);
	        		location.href= '../regular/detail.do?no=${vo.no}';
	        	})
	        }
		}
	});
	
	
   </script>
</body>
</html>
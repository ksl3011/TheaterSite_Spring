<%@page import="kr.co.sunnyside.cmn.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="context" value="${pageContext.request.contextPath }" />
<%


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>popup</title>
		<link href="${context}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${context}/resources/css/jquery-ui.css" rel="stylesheet">
		<link  href="${context}/resources/css/jquery.timepicker.min.css" rel="stylesheet">
		<link href="${context}/resources/css/headerStyle.css" rel="stylesheet" type="text/css">
		<style type="text/css">
			.popup_main{
				background-color: orange;
				border: 2px solid black;
				width: 500px;
				height: 10px;
				display: block;
				z-index: 10000;
				box-shadow: 3px 3px 7px 1px black;
				position: absolute;
				top: 70px;
				left: 70px;
				border-radius:.25rem;
				display: none;
			}
			.popup_title{
				height: 20px;
				padding-left: 10px;
				float: left;
			}
			.popup_contents{
				border-top: 1px solid black;
				width: 100%;
				background-color: white;
				padding: 5px;
				overflow: auto;
				border-radius:.25rem;
			}
			.popup_exit{
				height: 20px;
				float: right;
				padding-right: 10px;
				padding-top: 2px;
			}
			.popup_btn{
				width: 20px;
				height: 20px;
				line-height: 0px;
				padding: 0px;
				background-color: white;
				border-radius:.25rem;
			}
			.popup_contents pre{
				margin: 0px;
				padding: 0px;
				background-color: inherit;
				border: none;
				
			}
		</style>
	</head>
	<body>
		<div class="popup_main">
			<div class="popup_exit">
				<button class="popup_btn" onclick="javascript:popup_exitBtn();">X</button>
			</div>
			<div class="popup_title">
				<h4><b>안녕하세요</b></h4>
			</div>
			<br/>
			<div class="popup_contents">
				<pre>안녕하세요</pre>
			</div>
			
		</div>
		
		
		<script src="${context}/resources/js/jquery-1.12.4.js"></script>
		<script src="${context}/resources/js/bootstrap.min.js"></script>
		<script src="${context}/resources/js/jquery-ui.js"></script>
		<script src="${context}/resources/js/jquery.timepicker.min.js"></script>
		
		<script type="text/javascript">    		
    		$(function(){
    			popupStart();
    		})
    		
    		function popup_exitBtn(){
    			$(".popup_main").css("display", "none");
    		}
    		
    		function popupStart(){
    			$.ajax({
    				type : "POST",
    				url : "${context}/popup/do_retrieve.do",
    				dataType : "json",
    			}).done(function(data){
					var popup = data[0];
					var enable = popup.enable;
					if(enable == 'no' || enable == 'n' || enable == 'N' || enable == 'NO') return;
					$(".popup_title>h4>b").text(popup.title);
					$(".popup_contents>pre").text(popup.contents);
					$(".popup_main").css("display", "inline-block");
					popupSize();
				});
    		}
    		
    		function popupSize(){
    			var contentsHeight = parseInt($(".popup_contents>pre").height());
    			var popupHeight = parseInt($(".popup_main").height());
    			
    			if(parseInt(popupHeight) < parseInt(contentsHeight)){
    				$(".popup_main").css("height", eval(contentsHeight+44));
    			}
    		}
    	</script>
	</body>
</html>
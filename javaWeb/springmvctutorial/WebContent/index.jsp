<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Tutorial</title>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<style type="text/css">
body {
	background-color: #EEEEEE;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						/* ajax for get json */
						$('#btnGetJson').click(function() {
							$.ajax({
								type : "GET",
								url : "getJson",
								success : function(rs) {
									console.log(rs);
								}
							});
						});

						$('#btnRole').click(function() {
							$.ajax({
								type : "GET",
								url : "getjson",
								success : function(rs) {
									console.log(rs);
								}
							});
						});

						/* ajax for post json */
						$('#btnPostJson').click(
								function() {
									var person = {
										"name" : 'NhutNguyen',
										"age" : '27',
										"city" : "HCM"
									};
									$.ajax({
										url : "postjson",
										type : "POST",
										data : JSON.stringify(person),
										beforeSend : function(xhr) {
											xhr.setRequestHeader("Accept",
													"application/json");
											xhr.setRequestHeader(
													"Content-Type",
													"application/json");

										},
										success : function(rs) {
											console.log(rs);
										}
									});
								});
						/* ajax for post file with formData */
						var files;
						$("#myFile").on('change', prepareLoad);
						function prepareLoad(event) {
							files = event.target.files;
						}

						$('#subbutton').click(function() {
							processFileUpLoad();
						});

						function processFileUpLoad() {
							var strName = $('#txtFileName').val();
							var myForm = new FormData();
							myForm.append("file", file[0]);
							myForm.append("fileName", strName);
							$.ajax({
								url : "upload-file-with-ajax",
								type : "POST",
								data : myForm,
								enctype : 'multipart/form-data',
								processData : false,
								contentType : false,
								success : function(result) {
									console.log(result);
								}

							})
						}

						/* registration return token */
						$('#registration')
								.click(
										function() {
											var json = {
												"userName " : $('#txtUserName')
														.val(),
												"password " : $('#txtPassword')
														.val(),
												"email" : $('txtEmail').val()
											};
											$
													.ajax({
														url : "user/registration",
														type : "POST",
														data : JSon
																.stringify(json),
														beforeSend : function(
																xhr) {
															cosole
																	.log("heheeee");
															xhr
																	.setRequestHeader(
																			"Accept",
																			"application/json");
															xhr
																	.setRequestHeader(
																			"Content-Type",
																			"application/json");
														},
														success : function(res) {
															if (res.data == true) {
																document
																		.getElementById("alert").innerHTML = "Registration was successfully";
															} else {
																document
																		.getElementById("alert").innerHTML = res.message;

															}
														}
													});

										});
					});
</script>
</head>
<body>
	<br>
	<div style="text-align: center">
		<h2>Hey guy. This is index page</h2>
		<a href="Welcome">Click here to see welcome page</a>
	</div>
	<!-- demo form json -->
	<button id="btnGetJson">Get JSon</button>
	</br/>

	<!-- demo form post Json -->
	<button id="btnPostJson">Post Json</button>
	<br>


	<!-- Singer file upload no ajax -->
	<h1>Single File Upload No Ajax</h1>
	<form method="POST" enctype="multipart/form-data"
		action="upload-file-no-ajax">
		Upload File :<input type="file" name="myfile"><br>
		Desciption:<input type="text" name="myFileName" /> <input
			type="submit" value="send" />


	</form>
	<br />

	<!-- Singer File Upload with Ajax -->
	<h1>Singer File upload Ajax</h1>
	Upload File:
	<input type="file" id "myFile"/>
	<br /> Description:
	<input type="text" ip="txtFileName" />
	<input type="button" id "subbutton value="Send" />

	<!-- Registration  -->
	<h1>Resgistration Token</h1>
	User Name :
	<input type="text"
		id="txtUserName/><br/>
	Email: <input type ="text" id="txtEmail"/><br/>
	Password : <input type="password" id " txtPassword"/>
	<br />
	<input id="alert">
	</div>

	<h1>Hibernate</h1>
	<button id="btnRole">Read Role</button>
</body>
</html>

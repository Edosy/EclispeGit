$(document).ready(function() {
	$("tr:even").css("background-color", "antiquewhite");
})

function check_name() {
	var reUsername = /^([a-zA-Z](\d|[a-zA-Z])*)$/;
	var name = document.getElementById("username").value;
	var check_img = document.getElementById("check_name_img");
	
	if(name.search(reUsername) == -1){
		check_img.innerHTML = "✘";
		return false;
	}else{
		check_img.innerHTML = "✔";
		return true;
	}
	
	
}

function check_pwd() {
	var pwd = document.getElementById("pwd").value;
	if(pwd.length > 8) {
		document.getElementById("check_pwd_img").innerHTML = "✔";
		return true;
	}else{
		document.getElementById("check_pwd_img").innerHTML = "✘";
		return false;
	}
}

function check_pwd_two() {
	if(document.getElementById("t_text_pwd_two").value == document.getElementById("t_text_pwd").value){
		document.getElementById("check_pwd_two_img").innerHTML = "✔";
		return true;
	}else{
		document.getElementById("check_pwd_two_img").innerHTML = "✘";
		return false;
	}
}

function check_email() {
	var reEmail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if(document.getElementById("email").value.search(reEmail) == -1){
		document.getElementById("t_div_email").innerHTML = "✘";
		return true;
	}else{
		document.getElementById("t_div_email").innerHTML = "✔";
		return false;
	}
}

$(function(){
	$("#xieyi").click(function(){
		if($("#xieyi").is(":checked")){
			$("#denglu").removeAttr("disabled", "");
		}else{
			$("#denglu").attr("disabled", "disabled");
		}
	})
})


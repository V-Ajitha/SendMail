let mail = document.getElementById("mail");
let msg = document.getElementById("msg");
let sendBtn = document.getElementById("send-btn");
let response = document.getElementById("response");

sendBtn.addEventListener("click", function(){
	
    const xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			console.log("Success")
		}
	}
	xhr.open("POST","mail");
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("msg="+msg.value+"&mail="+mail.value);
	
	xhr.onload = function(){
		// to see a response in web page..
		response.innerText = xhr.responseText;
	}
})
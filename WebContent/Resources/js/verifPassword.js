console.log("lis le fichier")
var button = document.getElementById('buttonValidPassword'); 

function verifSamePassword(){
	console.log("le 1er" + document.querySelector("#inputNewPassword").value);
	console.log("le 1er" + document.querySelector("#inputNewPasswordVerif").value);
		if(document.querySelector("#inputNewPassword").value != document.querySelector("#inputNewPasswordVerif").value){
			document.querySelector(".hiddenMessage").style.display = "inherit";
			button.disabled = true; 
		}else{
			document.querySelector(".hiddenMessage").style.display = "none";
			button.disabled = false; 
		}

}


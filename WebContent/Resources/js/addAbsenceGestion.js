
	
var button = document.getElementById('buttonSendAbsence'); 
var StringDateFin = true;
var StringDateDebut = true;


function verifConge(){
	var congeType = document.querySelector("#congeTypeJs").value;
	
	
//	3 is "Congé sans solde"
	if(congeType == 3 ){
		console.log("Conge sans solde");
		document.getElementById("motifJs").required = true;
	}else{
		document.getElementById("motifJs").required = false;
	};	
	
}

function checkTypeConges(id){
	console.log(id);
	let options = document.querySelectorAll(".typeconges");
	let index = 1;
	
	options.forEach(element =>{
		
		if(id == index){
			console.log(index);
			element.setAttribute("selected","");
		}
		index++;
	});

}
	
function verifDateFin(){
		var dateFin = document.querySelector(".finDateJs").value;
		console.log(dateFin);
		var dateDebut = document.querySelector(".debutDateJs").value;
		console.log(dateDebut);
		
		if (dateFin < dateDebut){
			console.log("date de fin inferieur à date debut");
			document.querySelector(".messageFinDate").style.display = "inherit";
			StringDateFin = false;
			
		}
		else{
			document.querySelector(".messageFinDate").style.display = "none";
			StringDateFin = true;
		}
		 disabledButton();
	}

function verifDateDebut(){
	var dateDebut = document.querySelector(".debutDateJs").value;
	console.log(dateDebut);
	var dateActuelle = Date.now();
	var dActuelle = new Date(dateActuelle);
	
	var theyear = dActuelle.getFullYear();
	var themonth = dActuelle.getMonth() + 1;
	var thetoday = dActuelle.getDate();
	
	if(themonth<10){
		themonth = "0"+themonth;
	}
	var DateReallEnString = theyear+"-"+themonth+"-"+thetoday;

	console.log(DateReallEnString);
	
	if (DateReallEnString >= dateDebut ){
		console.log("date de debut n'est pas supérieure à la date actuelle ");
		document.querySelector(".messageDebutDate").style.display = "inherit";
		StringDateDebut = false;
		
	}
	else{
		document.querySelector(".messageDebutDate").style.display = "none";
		StringDateDebut = true;
	}
	 disabledButton();	

}

function disabledButton(){
	
	if(!StringDateDebut || !StringDateFin){
		button.disabled = true; 
	}else{
		button.disabled = false; 
	}
}



	




console.log("lit bien le fichier de controle")
var button = document.getElementById('boutonaddFerie'); 

var StringDateDebut = true;
var StringWeekend = true;

function verifType(){
	var congeType = document.querySelector("#ferieType").value;
	console.log(congeType);
	
//	3 is "Congé sans solde"
	if(congeType == 1 ){

		document.getElementById("message").required = true;
	}else{
		document.getElementById("message").required = false;
	};	
	console.log("test");
}
	
//function verifDateFin(){
//		var dateFin = document.querySelector(".finDateJs").value;
//		console.log(dateFin);
//		var dateDebut = document.querySelector(".debutDateJs").value;
//		console.log(dateDebut);
//		
//		if (dateFin < dateDebut){
//			console.log("date de fin inferieur à date debut");
//			document.querySelector(".messageFinDate").style.display = "inherit";
//			StringDateFin = false;
//			
//		}
//		else{
//			document.querySelector(".messageFinDate").style.display = "none";
//			StringDateFin = true;
//		}
//		 disabledButton();
//	}

function verifDateFerie(){
	var dateDebut = document.querySelector(".dateDayOff").value;
	var dateActuelle = Date.now();
	var dActuelle = new Date(dateActuelle);
	
	var theyear = dActuelle.getFullYear();
	var themonth = dActuelle.getMonth() + 1;
	var thetoday = dActuelle.getDate();
	
	if(themonth<10){
		themonth = "0"+themonth;
	}
	var DateReallEnString = theyear+"-"+themonth+"-"+thetoday;
	var dateDayOff = new Date(dateDebut);

	
	if (DateReallEnString >= dateDebut ){
		console.log("date de debut n'est pas supérieure à la date actuelle ");
		document.querySelector(".messagejourAnterieur").style.display = "inherit";
		StringDateDebut = false;
		disabledButton();	
	}
	else{
		document.querySelector(".messagejourAnterieur").style.display = "none";
		StringDateDebut = true;
		disabledButton();
	}
if(dateDayOff.getDay() == 0 || dateDayOff.getDay() == 6 ){
	document.querySelector(".messageweekend").style.display = "inherit";
	StringWeekend = false;
	disabledButton()
}else{
	document.querySelector(".messageweekend").style.display = "none";
	StringWeekend = true;
	disabledButton()
}

}

function disabledButton(){
	console.log("verifDateDebut ; " + StringDateDebut)

	if(!StringDateDebut || !StringWeekend){
		button.disabled = true; 
	}else{
		button.disabled = false; 
	}
}


function checkTypeConges(id){
	console.log(id);
	let options = document.querySelectorAll(".ferieType");
	let index = 1;
	
	options.forEach(element =>{
		console.log('plop');
		if(id == index){
			console.log(index);
			element.setAttribute("selected","");
		}
		index++;
	});

}



//
//	console.log("lit bien le fichier")
//var button = document.getElementById('buttonSendAbsence'); 
//var StringDateFin = true;
//var StringDateDebut = true;
//
//
//function verifConge(){
//	var congeType = document.querySelector("#congeTypeJs").value;
//	console.log(congeType);
//	
////	3 is "Congé sans solde"
//	if(congeType == 3 ){
//		console.log("Conge sans solde");
//		document.getElementById("motifJs").required = true;
//	}else{
//		document.getElementById("motifJs").required = false;
//	};	
//	console.log("test");
//}
//	
//function verifDateFin(){
//		var dateFin = document.querySelector(".finDateJs").value;
//		console.log(dateFin);
//		var dateDebut = document.querySelector(".debutDateJs").value;
//		console.log(dateDebut);
//		
//		if (dateFin < dateDebut){
//			console.log("date de fin inferieur à date debut");
//			document.querySelector(".messageFinDate").style.display = "inherit";
//			StringDateFin = false;
//			
//		}
//		else{
//			document.querySelector(".messageFinDate").style.display = "none";
//			StringDateFin = true;
//		}
//		 disabledButton();
//	}
//
//function verifDateDebut(){
//	var dateDebut = document.querySelector(".debutDateJs").value;
//	console.log(dateDebut);
//	var dateActuelle = Date.now();
//	var dActuelle = new Date(dateActuelle);
//	
//	var theyear = dActuelle.getFullYear();
//	var themonth = dActuelle.getMonth() + 1;
//	var thetoday = dActuelle.getDate();
//	
//	if(themonth<10){
//		themonth = "0"+themonth;
//	}
//	var DateReallEnString = theyear+"-"+themonth+"-"+thetoday;
//
//	console.log(DateReallEnString);
//	
//	if (DateReallEnString >= dateDebut ){
//		console.log("date de debut n'est pas supérieure à la date actuelle ");
//		document.querySelector(".messageDebutDate").style.display = "inherit";
//		StringDateDebut = false;
//		
//	}
//	else{
//		document.querySelector(".messageDebutDate").style.display = "none";
//		StringDateDebut = true;
//	}
//	 disabledButton();	
//
//}
//
//function disabledButton(){
//	console.log("verifDateDebut ; " + StringDateDebut)
//	console.log("verifDateFin ; " + StringDateFin)
//	if(!StringDateDebut || !StringDateFin){
//		button.disabled = true; 
//	}else{
//		button.disabled = false; 
//	}
//}
//
//


	console.log("lit bien le fichier")

function verifConge(){
	var congeType = document.querySelector("#congeTypeJs").value;
	console.log(congeType);
	
//	3 is "Congé sans solde"
	if(congeType == 3 ){
		console.log("Conge sans solde");
		document.getElementById("motifJs").required = true;
	}else{
		document.getElementById("motifJs").required = false;
	};	
	console.log("test");
}
	
function verifDateFin(){
		var dateFin = document.querySelector(".finDateJs").value;
		console.log(dateFin);
		var dateDebut = document.querySelector(".debutDateJs").value;
		console.log(dateDebut);
		
		if (dateFin < dateDebut){
			console.log("date de fin inferieur à date debut");
			document.querySelector(".messageFinDate").style.display = "inherit";
			
		}
		else{
			document.querySelector(".messageFinDate").style.display = "none";
		}
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
//	var DateReal = new Date(DateReallEnString);
	console.log(DateReallEnString);
	
	if (DateReallEnString >= dateDebut ){
		console.log("date de debut n'est pas supérieure à la date actuelle ");
		document.querySelector(".messageDebutDate").style.display = "inherit";
		
	}
	else{
		document.querySelector(".messageDebutDate").style.display = "none";
	}
}




<script>
function selectedGreatOption(){
	

	let year = '${requestScope["year"]}';
	let month = '${requestScope["month"]}';
	let dep = '${requestScope.dep}';
	
	
	let optDep = document.querySelectorAll('#departement option');
	
	 console.log(year +"  month===> "+ month +"dep  " +dep)
	 
	 optDep.forEach(element => {
        if (element.value == dep) {
            element.setAttribute("selected", ""); ;
        }
    });
	 let optMonth = document.querySelectorAll('#month option');
		
	
	 optMonth.forEach(element => {
        if (element.value == month) {
            element.setAttribute("selected", ""); ;
        }
    }); 
	 let optYear = document.querySelectorAll('#year option');
		
	
	 optYear.forEach(element => {
        if (element.textContent == year) {
            element.setAttribute("selected", ""); ;
        }
    }); 
	
}


$(document).ready(
		
		function() {
			var getDaysInMonth = function(month,year) {
				
				 return new Date(year, month, 0).getDate();
				
				};
			let year = '${requestScope["year"]}';
			let month = '${requestScope["month"]}';
			if(month<10){
				month = "0"+month;
			}
			
			let tab = '${requestScope.absenceForChart}';
			let absences =	JSON.parse(tab);
			
			let date =[];
			let lastDay = getDaysInMonth(month, year)
			let nbrOfAbs =[];
			for(let i=1;i <= lastDay;i++){
				let day = i;
				if(day<10){
					day = "0"+day;
				}
				date.push(day+"-"+month+"-"+year);
				nbrOfAbs.push(0);
			}
			
			
			for(let i=1;i <= lastDay;i++){
				let day = i;
				if(day<10){
					day = "0"+day;
				}
				for(let j =0; j<absences.length ;j++){
					if(day ==absences[j].dateStart.day ){	
						if(absences[j].duration!=1){
							for(let k=0 ; k< absences[j].duration;k++){
								nbrOfAbs[i+k] = nbrOfAbs[i+k]+1;
							}
						}else{
							nbrOfAbs[i] = nbrOfAbs[i]+1;
						}	
					}
			 	}
			}
		
			var label = date.map(function(e) {
   					return e;
				});
			var abs = nbrOfAbs.map(function(e) {
					return e;
			});
			
			var ctx = document.getElementById("myChart");
			var myChart = new Chart(ctx, {
				type : 'bar',
				data : {
					labels : label ,
					
					datasets : [ {
						label : 'Synthese par jour',
						data : abs,
						backgroundColor : [ 
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)',
								'rgba(54, 162, 235, 0.2)' ],
						borderColor : [ 'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)',
								'rgba(54, 162, 235, 1)' ],
						borderWidth : 1
					} ]
				},
				options : {
					responsive :true,
					scales : {
						xAxes : [ {
							ticks : {
								maxRotation : 90,
								minRotation : 80
							}
						} ],
						yAxes : [ {
							ticks : {
								beginAtZero : true,
								 suggestedMax: 5,
								stepSize :1
							}
						} ]
					}
				}
			});
		});
		
		
		</script>
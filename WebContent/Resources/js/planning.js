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
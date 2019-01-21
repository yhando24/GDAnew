<script>
$(document).ready(
		
		function() {
			selectedGreatOption()
		
	});
function selectedGreatOption(){
	

	let year = '${selectYear}';
	

	 let optYear = document.querySelectorAll('#selectYear option');
		
	
	 optYear.forEach(element => {
        if (element.textContent == year) {
            element.setAttribute("selected", ""); ;
        }
    }); 
	
}


</script>
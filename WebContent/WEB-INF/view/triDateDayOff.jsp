
<script >function dayOffbyYear(){
	
	var select = document.getElementById('selectYear');
	var year = select.value;
	console.log(year);
	
	window.location = 'http://localhost:8080/GDA/day-off-management?year='+year
	
}</script>

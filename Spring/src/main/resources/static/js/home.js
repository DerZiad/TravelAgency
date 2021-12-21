voyagesID = []
let productNumber = 0;
jQuery(document).ready(function() {	
	$('#numberPanier').html(productNumber)
});

function addToChart(id){
	var test = 1;
	for(voyage of voyagesID){
		if(voyage == id){
			test = 0;
		}
	}
	if(test == 1){
		voyagesID.push(id)
		productNumber++;
		$('#numberPanier').html(productNumber);
	} 
}
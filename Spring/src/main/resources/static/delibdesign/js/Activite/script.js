$(document).ready(function() {
	$('button[id=rst]').click(function(){
		clearAddCache();
		window.location.href = '/admin/activite';

		});
    var max_fields = 10;
    var wrapper = $(".container1");
    var add_button = $(".add_form_field");

    var x = 1;
    $(add_button).click(function(e) {
        e.preventDefault();
        if (x < max_fields) {
            x++;
            $(wrapper).append('<div><label for="name" class="">Label SousActivite</label><input id="ssa" type="text" value=""name="myparams"/></br><label for="name" class="">Description SousActivite</label><input type="text" id="dess" value=""name="SousActdescrip"/><a href="#" class="delete">Delete</a></div>'); //add input box
        } else {
            alert('Ca se suffit ?!!')
        }
    });

    $(wrapper).on("click", ".delete", function(e) {
        e.preventDefault();
        $(this).parent('div').remove();
        x--;
    })
});
function clearAddCache() {
	$('input[name=id]').val("");
	$('input[name=name]').val("");
	$('input[name=description]').val("");
	$('input[name=myparams]').val("");
	$('input[name=SousActdescrip]').val("");
	
}



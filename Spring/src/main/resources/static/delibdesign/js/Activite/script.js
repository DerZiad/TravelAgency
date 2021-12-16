$(document).ready(function() {
    var max_fields = 10;
    var wrapper = $(".container1");
    var add_button = $(".add_form_field");

    var x = 1;
    $(add_button).click(function(e) {
        e.preventDefault();
        if (x < max_fields) {
            x++;
            $(wrapper).append('<div><label for="name" class="">Label SousActivite</label><input type="text" value=""name="myparams"/></br><label for="name" class="">Description SousActivite</label><input type="text" value=""name="SousActdescrip"/><a href="#" class="delete">Delete</a></div>'); //add input box
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

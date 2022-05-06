$(document).ready(function() {

    $(".button-plus").click(function(){
        increaseValue();
    });

    $(".button-minus").click(function(){
        decreaseValue();
    });

});

function increaseValue() {
    const field = $(".quantity-field");
    if (field.val() < 10) {
        parseInt(field.val(parseInt(field.val()) + 1));
    }
}

function decreaseValue() {
    const field = $(".quantity-field");
    if (field.val() > 1) {
        parseInt(field.val(parseInt(field.val()) - 1));
    }
}


$(document).ready(function() {

    $(".button-plus").click(function() {
        increaseValue();
    });

    $(".button-minus").click(function() {
        decreaseValue();
    });

    $(".remove").click(function() {
        removeItem();
    });

    $(".input-delivery").click(function() {
        selectedDelivery();
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

function removeItem() {
    $(".remove").remove();
    $(".item").remove();
    $(".itemImg").remove();
    $(".price-2").val("$0");
    $(".price-3").val("$0");
}

function selectedDelivery() {
    $(this).addClass("selected-delivery");
}


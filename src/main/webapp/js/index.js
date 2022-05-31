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

    $(".button-delivery-1").click(function() {
        selectedDelivery1();
    });

    $(".button-delivery-2").click(function() {
        selectedDelivery2();
    });

    $(".button-delivery-3").click(function() {
        selectedDelivery3();
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
    $(".price-2").text("$0");
    $(".price-3").text("$0");
    $(".price").text("$0");
    $(".input-name").prop("disabled", true);
    $(".continue").remove();
    $(".overlap-group-1").remove();
    $(".default").remove();
}

function selectedDelivery1() {
    $(".button-delivery-1").addClass("selected-delivery");
}

function selectedDelivery2() {
    $(".button-delivery-2").addClass("selected-delivery");
}

function selectedDelivery3() {
    $(".button-delivery-3").addClass("selected-delivery");
}
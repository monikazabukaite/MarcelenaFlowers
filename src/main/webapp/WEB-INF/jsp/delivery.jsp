<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<style>
    <%@include file="/WEB-INF/css/checkout.css" %>
</style>
<div class="cart screen">
    <div class="flex-col">
        <h1 class="title">Checkout</h1>
        <div class="flex-row-1">
            <p class="delivery-address">Delivery Options</p>
            <div class="title-1">Your Cart</div>
        </div>
    </div>
    <div class="flex-row-2">
        <div class="flex-col-3">
            <div class="input-delivery">
                <div class="input-name playfairdisplay-semi-bold-woodsmoke-15px">Standard Delivery:</div>
                <div class="input-name valign-text-middle">3-4 Business Days</div>
            </div>
            <div class="input-delivery">
                <div class="input-name playfairdisplay-semi-bold-woodsmoke-15px">Next-Day Delivery:</div>
                <div class="input-name valign-text-middle">Delivered between 7am and 10pm</div>
            </div>
            <div class="input-delivery">
                <div class="input-name playfairdisplay-semi-bold-woodsmoke-15px">Nominated Day:</div>
                <div class="input-name valign-text-middle">Choose a day that suits you</div>
            </div>
            <div class="default">
                <div class="overlap-group-1">
                    <a href="/thank-you" style="color: #fff;">Continue</a>
                </div>
            </div>
        </div>
        <div class="flex-col-1">
            <img class="x36c4577975feb4cb36f6b7bd052c8845-1" src="../../${item.imgUrl}"/>
        </div>
        <div class="flex-col-2">
            <div class="the-charlie playfairdisplay-semi-bold-black-20px">${item.name}</div>
            <div class="quantity-1 playfairdisplay-normal-black-14px">Quantity ${quantity}</div>
            <div class="price valign-text-middle playfairdisplay-normal-black-20px">$${item.price}</div>
        </div>
        <div class="remove-container">
            <div class="remove playfairdisplay-normal-black-14px">Remove</div>
        </div>
    </div>
</div>
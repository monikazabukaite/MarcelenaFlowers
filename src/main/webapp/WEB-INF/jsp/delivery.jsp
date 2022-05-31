<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<script src="../../js/index.js"></script>
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
            <button class="button-delivery button-delivery-1" style="padding-right: 248px; padding-left: 22px;">
                <span class="bold">Standard Delivery:</span>
                </br>
                <span>3-4 Business Days</span>
            </button>
            <button class="button-delivery button-delivery-2">
                <span class="bold">Next-Day Delivery:</span>
                </br>
                <span>Delivered between 7am and 10pm</span>
            </button>
            <button class="button-delivery button-delivery-3">
                <span class="bold">Nominated Day:</span>
                </br>
                <span>Choose a day that suits you</span>
            </button>
            <div class="default">
                <div class="overlap-group-0">
                    <a class="continue" href="/thank-you" style="color: #fff;">Continue</a>
                </div>
            </div>
        </div>
        <div class="flex-col-1">
            <img class="x36c4577975feb4cb36f6b7bd052c8845-1 itemImg" src="../../${item.imgUrl}"/>
        </div>
        <div class="flex-col-2">
            <div class="the-charlie playfairdisplay-semi-bold-black-20px item">${item.name}</div>
            <div class="quantity-1 playfairdisplay-normal-black-14px item">Quantity ${quantity}</div>
            <div class="price valign-text-middle playfairdisplay-normal-black-20px item">$${item.price * quantity}</div>
        </div>
        <div class="remove-container">
            <div class="remove playfairdisplay-normal-black-14px"><a>
                Remove
            </a></div>
        </div>
    </div>
</div>
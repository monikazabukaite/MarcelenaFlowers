<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<script src="../../js/index.js"></script>
<style>
    <%@include file="/WEB-INF/css/cart.css" %>
</style>
<div class="cart screen">
    <div class="flex-col">
        <h1 class="title">Your cart</h1>
        <div class="flex-row-1">
            <a class="not-ready-to-checkout" href="/shop">Not ready to checkout? Continue shopping!</a>
            <div class="title-1">Order Summary</div>
        </div>
    </div>
    <div class="flex-row-2">
        <div class="flex-col-1">
            <img class="x36c4577975feb4cb36f6b7bd052c8845-1 itemImg" src="../../${item.imgUrl}"/>
            <%--            <img class="last-weeks-flowers-f" src="../../images/flower2.jpg"/>--%>
        </div>
        <div class="flex-col-2">
            <div class="the-charlie playfairdisplay-semi-bold-black-20px item">${item.name}</div>
            <div class="quantity-1 playfairdisplay-normal-black-14px item">Quantity ${quantity}</div>
            <div class="price valign-text-middle playfairdisplay-normal-black-20px item">$${item.price}</div>
        </div>
        <div class="remove-container">
            <div class="remove playfairdisplay-normal-black-14px">
                <a>
                    Remove
                </a>
            </div>
            <%--            <div class="remove-1 playfairdisplay-normal-black-14px">Remove</div>--%>
        </div>
        <div class="flex-col-3">
            <input placeholder="Enter coupon code here" class="input-name valign-text-middle input"/>
            <div class="line-items">
                <div class="order-line-item">
                    <div class="subtotal playfairdisplay-normal-woodsmoke-15px">Subtotal</div>
                    <p class="price-2 playfairdisplay-normal-woodsmoke-15px">$${item.price * quantity}</p>
                </div>
                <div class="order-line-item">
                    <div class="subtotal-1 playfairdisplay-normal-woodsmoke-15px">Shipping</div>
                    <p class="x108">Calculated at the next step</p>
                </div>
                <img class="line-7" src="line-7.svg"/>
                <div class="order-line-item">
                    <div class="subtotal-2 playfairdisplay-semi-bold-woodsmoke-15px">Total</div>
                    <div class="price-3 playfairdisplay-semi-bold-woodsmoke-15px">$${item.price * quantity}</div>
                </div>
            </div>
            <div class="default">
                <div class="overlap-group-1">
                    <div class="button-text">
                        <a class="continue" href="/checkout/${item.id}/1" style="color: #fff;">Continue to Checkout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
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
            <p class="delivery-address">Delivery Address</p>
            <div class="title-1">Your Cart</div>
        </div>
    </div>
    <div class="flex-row-2">
        <div class="flex-col-3" style="margin-left: 205px">
            <input placeholder="First Name" class="input-name valign-text-middle input"/>
            <input placeholder="Last Name" class="input-name valign-text-middle input"/>

            <div class="row" style="margin-left: -9px;">
                <input placeholder="City" class="input-name valign-text-middle inputCard column"/>
                <input placeholder="Street" class="input-name valign-text-middle inputCard column"/>
            </div>

            <select name="country" id="country" style="margin-left: 1px;">
                <option value="select">Country</option>
                <option value="BE">Belgium</option>
                <option value="DE">Germany</option>
                <option value="DK">Denmark</option>
                <option value="FR">France</option>
                <option value="GR">Greece</option>
                <option value="LT">Lithuania</option>
                <option value="MT">Malta</option>
            </select>

            <input placeholder="Zipcode" class="input-name valign-text-middle input"/>

            <label class="container subtotal playfairdisplay-normal-woodsmoke-15px">Save contact information
                <input type="checkbox">
                <span class="checkmark"></span>
            </label>

            <div class="default">
                <div class="overlap-group-1">
                    <div class="button-text">
                        <a class="continue" href="/payment/${item.id}/1" style="color: #fff;">Continue</a>
                    </div>
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
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script src="../js/index.js"></script>
<div class="container">

    <div class="section-title" style="padding-bottom: 0;">
        <span>${item.name}</span>
        <h2>${item.name}</h2>
    </div>

    <div class="row" style="margin-left: 2%;">
        <div class="card" style="width: 45%;">
            <a class="card-a">
                <img src="../${item.imgUrl}" class="item-img" alt="...">
            </a>
        </div>

        <div class="item" style="width: 25rem;">
            <a class="item-a">
                <h5 class="item-title" >${item.name}</h5>
                <h4 class="item-text" >16 stems including snapdragons, orchids, rhododendron, pistache and alstroemeria.</h4>
                <p class="item-price">$${item.price}</p>
                <div class="input-group">
                    <input type="button" value="-" class="button-minus" data-field="quantity">
                    <input type="number" step="1" max="10" value="1" name="quantity" class="quantity-field">
                    <input type="button" value="+" class="button-plus" data-field="quantity">
                </div>
                <div class="buygroup">
                    <a href="/cart/${item.id}/1">
                        <input type="submit"  class="button-addtocart" value="Add to Cart" >
                    </a>
<%--                    <form id="thisone" action="cart" method="post">--%>
<%--                        <input type="submit"  class="button-addtocart" value="Add to Cart" >--%>
<%--                    </form>--%>
                </div>
                <div class="buygroup">
                    <a href="/checkout/${item.id}/1">
                        <input type="submit"  class="button-buynow"  value="Buy Now">
                    </a>
<%--                    <form id="thistoo" action="checkout" method="post">--%>
<%--                        <input type="submit"  class="button-buynow"  value="Buy Now" >--%>
<%--                    </form>--%>
                </div>
            </a>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
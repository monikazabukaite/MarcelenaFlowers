<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script src="js/index.js"></script>
<div class="container">

    <div class="row" style="margin-left: 2%;">
        <div class="card" style="width: 45%;">
            <a class="card-a">
                <img src="images/flower1.jpg" alt="..."   class="item-img" >
            </a>
        </div>

        <div class="item" style="width: 25rem;">
            <a class="item-a">
                <h5 class="item-title" >The Ellen</h5>
                <h4 class="item-text" >16 stems including snapdragons, orchids, rhododendron, pistache and alstroemeria.</h4>
                <p class="item-price">$49</p>
                <div class="input-group">
                    <input type="button" value="-" class="button-minus" data-field="quantity">
                    <input type="number" step="1" max="10" value="1" name="quantity" class="quantity-field">
                    <input type="button" value="+" class="button-plus" data-field="quantity">
                </div>
                <div class="buygroup">
                    <form id="thisone" action="cart" method="post">
                        <input type="submit"  class="button-addtocart" value="Add to Cart" >
                    </form>
                </div>
                <div class="buygroup">
                    <form id="thistoo" action="checkout" method="post">
                        <input type="submit"  class="button-buynow"  value="Buy Now" >
                    </form>
                </div>
            </a>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <div class="section-title" style="padding-bottom: 0;">
        <span>Shop</span>
        <h2>Shop</h2>
        <p>Find what you are looking for</p>
    </div>

    <ul class="nav" style="margin-top: 2%; margin-bottom: 2%">
        <li class="nav-item ">
            <a class="nav-link active categories" aria-current="page" href="#" style="padding-left: 0px">Hand-tied
                bouqets</a>
        </li>
        <li class="nav-item">
            <a class="nav-link categories" href="#">Dried flowers</a>
        </li>
        <li class="nav-item">
            <a class="nav-link categories" href="#">Letterbox flowers</a>
        </li>
        <li class="nav-item">
            <a class="nav-link categories" href="#">Spring flowers</a>
        </li>
    </ul>

    <div class="row" style="margin-left: 2%;">
        <c:forEach begin="0" end="3" items="${itemsList}" var="item">
            <div class="card col-md-3" style="width: 18rem;">
                <a class="card-a" href="/item/${item.id}">
                    <img src="${item.imgUrl}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">$${item.price}</p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

    <div class="row" style="margin-left: 2%;">
        <c:forEach begin="4" end="7" items="${itemsList}" var="item">
            <div class="card col-md-3" style="width: 18rem;">
                <a class="card-a" href="/item/${item.id}">
                    <img src="${item.imgUrl}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">$${item.price}</p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

    <div class="row" style="margin-left: 2%;">
        <c:forEach begin="8" end="11" items="${itemsList}" var="item">
            <div class="card col-md-3" style="width: 18rem;">
                <a class="card-a" href="/item/${item.id}">
                    <img src="${item.imgUrl}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">$${item.price}</p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

</div>
<%@ include file="common/footer.jspf" %>
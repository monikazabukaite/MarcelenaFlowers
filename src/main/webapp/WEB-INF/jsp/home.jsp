<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <section id="hero" class="d-flex align-items-center scrolled-offset">
        <div class="container position-relative aos-init aos-animate" data-aos="fade-up" data-aos-delay="500">
            <h1 style="color: #fff; font-weight: 600; font-family: 'Playfair Display'; font-size: 48px; text-align: center">
                Make your everyday bloom.</h1>
        </div>
    </section>

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
</div>
<%@ include file="common/footer.jspf" %>
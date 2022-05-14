<%@ page import="java.util.Objects" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<style>
    <%@include file="/WEB-INF/css/login.css" %>
    <%@include file="/WEB-INF/css/reviews.css" %>
</style>

<div class="container">

    <div class="section-title" style="padding-bottom: 0;">
        <span>Reviews</span>
        <h2>Reviews</h2>
        <p>Read the reviews of our customers</p>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <h1 class="title">Reviews</h1>
            <div class="flex-col-1">
                <img
                        class="component-5"
                        src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/component-5@2x.svg"
                />
                <div class="address">${reviews.size()} reviews</div>
                <div class="rating-count-row-1">
                    <div class="address-1 playfairdisplay-medium-black-17px">5 stars</div>
                    <div class="group-31">
                        <img
                                class="line-8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/line-8@2x.svg"
                        />
                    </div>
                    <div class="x5 playfairdisplay-medium-black-17px">
                        (${reviews.stream().filter(r -> r.getRating() == 5).count()})
                    </div>
                </div>
                <div class="rating-count-row-2">
                    <div class="x5-stars playfairdisplay-medium-black-17px">4 stars</div>
                    <div class="group-31">
                        <img
                                class="line-8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/line-8@2x.svg"
                        />
                    </div>
                    <div class="x5-1 playfairdisplay-medium-black-17px">
                        (${reviews.stream().filter(r -> r.getRating() == 4).count()})
                    </div>
                </div>
                <div class="rating-count-row-3">
                    <div class="x5-stars-1 playfairdisplay-medium-black-17px">3 stars</div>
                    <div class="group-31">
                        <img
                                class="line-8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/line-8@2x.svg"
                        />
                    </div>
                    <div class="x5-2 playfairdisplay-medium-black-17px">
                        (${reviews.stream().filter(r -> r.getRating() == 3).count()})
                    </div>
                </div>
                <div class="rating-count-row">
                    <div class="x5-stars-2 playfairdisplay-medium-black-17px">2 stars</div>
                    <div class="group-31">
                        <img
                                class="line-8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/line-8@2x.svg"
                        />
                    </div>
                    <div class="x5-3 playfairdisplay-medium-black-17px">
                        (${reviews.stream().filter(r -> r.getRating() == 2).count()})
                    </div>
                </div>
                <div class="rating-count-row">
                    <div class="x5-stars-3 playfairdisplay-medium-black-17px">1 stars</div>
                    <div class="group-31">
                        <img
                                class="line-8"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/line-8-4@2x.svg"
                        />
                    </div>
                    <div class="x5-4 playfairdisplay-medium-black-17px">
                        (${reviews.stream().filter(r -> r.getRating() == 1).count()})
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm" style="margin-top: 6em">
            <div class="component-container">
                <c:forEach items="${reviews}" var="review">
                    <div class="flex-row-3">
                        <img
                                class="frame"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/frame@2x.svg"
                        />
                        <img
                                class="frame-1"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/frame@2x.svg"
                        />
                        <img
                                class="frame"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/frame@2x.svg"
                        />
                        <img
                                class="frame-1"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/frame@2x.svg"
                        />
                        <img
                                class="frame-1"
                                src="https://anima-uploads.s3.amazonaws.com/projects/62696d3b3d4164e3db77b2f1/releases/62696d510d9823d4331aadc6/img/frame@2x.svg"
                        />
                        <div class="february-14-2022 playfairdisplay-normal-black-14px">${review.date}</div>
                    </div>
                    <div class="flex-row">
                        <div class="the-ellen playfairdisplay-semi-bold-black-20px">${review.product}</div>
                        <div class="emilly playfairdisplay-normal-black-14px">${review.user}</div>
                    </div>
                    <div class="lorem-ipsum-dolor-si playfairdisplay-normal-black-20px">${review.details}</div>
                </c:forEach>
            </div>
        </div>
    </div>
    <%
        if (request.getAttribute("role") != null && Objects.equals(request.getAttribute("role"), "user")) {
    %>
    <div style="padding-left: 25%; padding-right: 25%">
        <h3>Leave a review</h3>
        <form:form method="post" action="/add-review" modelAttribute="review">
            <div class="col-md" style="margin-top: 1%">
                <div class="form-outline mb-4">
                    <form:label cssClass="form-label" path="user">User name</form:label>
                    <form:input cssClass="form-control" type="text" path="user" required="required"/>
                </div>
                <div class="form-outline mb-4">
                    <form:label cssClass="form-label" path="product">Product name</form:label>
                    <form:input cssClass="form-control" type="text" path="product" required="required"/>
                </div>
                <div class="form-outline mb-4">
                    <form:label cssClass="form-label" path="rating">Rating</form:label>
                    <form:input cssClass="form-control" type="number" max="5" min="1" path="rating"
                                required="required"/>
                </div>
                <div class="form-outline mb-4">
                    <form:label cssClass="form-label" path="details">Review</form:label>
                    <form:input cssClass="form-control" type="text" path="details" required="required"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
            </div>
        </form:form>
        <% }
        %>

    </div>
</div>
<%@ include file="common/footer.jspf" %>
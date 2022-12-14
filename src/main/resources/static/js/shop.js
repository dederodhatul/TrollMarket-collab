var addProduct = document.querySelector('.add-product');
var formAddProduct = document.querySelector('.form-addProduct');

addProduct.addEventListener('click', function(){
    formAddProduct.style.visibility = "visible";
})

var detailProduct = document.querySelector(".detail-product");
var formDetailProduct = document.querySelector(".popup-detail-product");

detailProduct.addEventListener('click', function(){
    formDetailProduct.style.visibility = "visible";
})



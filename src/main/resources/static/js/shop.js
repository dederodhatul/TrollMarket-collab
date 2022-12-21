
//var formAddProduct = document.querySelector('.form-addProduct');
//
//addProduct.addEventListener('click', function(){
//    formAddProduct.style.visibility = "visible";
//})

//var detailProduct = document.querySelectorAll(".detail-product");
//
//document.addEventListener('DOMContentLoaded',function(){
//   for (let i = 0; i < detailProduct.length; i++) {
//       document.getElementById("form-info-"+i).style.visibility = "hidden";
//   }
//   for(let i = 0; i < detailProduct.length; i++){
//       document.getElementById("btn-info-"+i).addEventListener('click', function(e){
//                  document.getElementById("form-info-"+i).style.visibility = "visible";
//       })
//   }
//
//})


var modal = document.querySelectorAll(".modal");

function fetchDetailInfo(id){
 var request = new XMLHttpRequest();
     request.open("GET","/troll-market/shop/detailProduct?id="+id);
     request.send();
     request.onload = ()=>{
         var object = JSON.parse(request.response);
         console.log(object);
         document.getElementById("product-name").innerHTML = object.name;
         document.getElementById("product-category").innerHTML = object.category;
         document.getElementById("product-description").innerHTML = object.description;
         document.getElementById("product-price").innerHTML = object.price;
         document.getElementById("product-seller").innerHTML = object.seller.fullName;
         modal[0].style.display ="flex";
     }
}

function addToCart(id){
    document.getElementById("productID").value = id;
    modal[1].style.display ="flex";
}

//
//var addProduct = document.querySelectorAll('.add-product');

document.addEventListener('DOMContentLoaded',function(){
    if(document.getElementById("hasErrors")!=null){
        addToCart(document.getElementById("hasErrors").innerHTML);
    }
})




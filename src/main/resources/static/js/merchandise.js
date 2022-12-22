var modal = document.querySelector(".modal")

function fetchInfoProduct(id){
    var request = new XMLHttpRequest();
     request.open("GET","/troll-market/merchandise/infoProduct?id="+id);
     request.send();
     request.onload = ()=>{
         var object = JSON.parse(request.response);
         document.getElementById("product-name").innerHTML = object.name;
         document.getElementById("product-category").innerHTML = object.category;
         document.getElementById("product-description").innerHTML = object.description;
         document.getElementById("product-price").innerHTML = object.priceIDR;
         document.getElementById("product-discontinue").innerHTML = object.status;
         modal.style.display ="flex";
     }
}
var buttonAddNewShipment = document.getElementById("add-shipment");
var formPopup = document.querySelector(".form-popup");
var buttonPopupBatal = document.getElementById("btn-popup-batal");
var buttonEditShipment = document.getElementById("edit-shipment");

document.addEventListener('DOMContentLoaded',function(){
    if(document.getElementById("hasErrors")==null){
        formPopup.style.visibility ="hidden";
    }
//
//    buttonPopupBatal.addEventListener("click",function(){
//        formPopup.style.visibility = "hidden";
//        document.getElementById("input-service").style.visibility= "hidden";
//    })
})

function fetchShipment(id){
    if(id == 0){
        document.getElementById("input-service").style.visibility= "visible";
    }else{
        document.getElementById("input-service").style.visibility= "hidden";
    }
     var request = new XMLHttpRequest();
     request.open("GET","/troll-market/shipment/edit?id="+id);
     request.send();
     request.onload = ()=>{
         var object = JSON.parse(request.response);
         document.getElementById("input-id").value = object.id;
         document.getElementById("input-name").value = object.name;
         document.getElementById("input-price").value = object.price;
         formPopup.style.visibility ="visible";
     }
}

//var formAddProduct = document.querySelector('.form-addProduct');
//
//addProduct.addEventListener('click', function(){
//    formAddProduct.style.visibility = "visible";
//})

var detailProduct = document.querySelectorAll(".detail-product");

document.addEventListener('DOMContentLoaded',function(){
   for (let i = 0; i < detailProduct.length; i++) {
       document.getElementById("form-info-"+i).style.visibility = "hidden";
   }
   for(let i = 0; i < detailProduct.length; i++){
       document.getElementById("btn-info-"+i).addEventListener('click', function(e){
                  document.getElementById("form-info-"+i).style.visibility = "visible";
       })
   }

})

var addProduct = document.querySelectorAll('.add-product');

document.addEventListener('DOMContentLoaded',function(){

    var error = document.getElementById("hasErrors")
   console.log(document.getElementById("hasErrors"))

   if(error==null){
       for (let i = 0; i < addProduct.length; i++) {
           document.getElementById("form-add-"+i).style.visibility = "hidden";
       }
   }
   for(let i = 0; i < addProduct.length; i++){
       document.getElementById("btn-add-"+i).addEventListener('click', function(e){
                  document.getElementById("form-add-"+i).style.visibility = "visible";
       })
   }
})




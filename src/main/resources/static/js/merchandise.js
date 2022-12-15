var infoMerchand = document.querySelectorAll(".info")

document.addEventListener('DOMContentLoaded',function(){
   for (let i = 0; i < infoMerchand.length; i++) {
       document.getElementById("form-info-"+i).style.visibility = "hidden";
   }
   for(let i = 0; i < infoMerchand.length; i++){
       document.getElementById("btn-info-"+i).addEventListener('click', function(e){
                  document.getElementById("form-info-"+i).style.visibility = "visible";
              })
   }

})
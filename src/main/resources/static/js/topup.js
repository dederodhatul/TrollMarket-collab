var btnTopupTambah = document.querySelector(".btn-topup-tambah")
var btnTopupBatal = document.querySelector(".form-popup a")


document.addEventListener('DOMContentLoaded',function(){

    if(document.getElementById("hasErrors")==null){
        document.querySelector(".form-popup").style.visibility = "hidden";
    }
    btnTopupTambah.addEventListener('click',function(){
        document.querySelector(".form-popup").style.visibility = "visible";
    })
    btnTopupBatal.addEventListener('click',function(){
        document.querySelector(".form-popup").style.visibility = "hidden";
    })
})



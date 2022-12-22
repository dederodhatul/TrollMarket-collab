var btnTopupTambah = document.querySelector(".btn-topup-tambah")
var btnTopupBatal = document.querySelector(".modal-content a")
var modal = document.querySelector(".modal")

document.addEventListener('DOMContentLoaded',function(){

    if(document.getElementById("hasErrors")!=null){
        modal.style.display = "flex";
    }
    btnTopupTambah.addEventListener('click',function(){
        modal.style.display = "flex";
    })
    btnTopupBatal.addEventListener('click',function(){
        modal.style.display = "none";
    })
})



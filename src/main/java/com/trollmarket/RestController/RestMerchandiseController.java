package com.trollmarket.RestController;

import com.trollmarket.dto.product.ProductDTO;
import com.trollmarket.entity.Product;
import com.trollmarket.exceptionhandler.ObjectNotFound;
import com.trollmarket.service.ProductService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/merchandise")
public class RestMerchandiseController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;

    @GetMapping()
    public ResponseEntity<Page<Product>> getAllMerchandise(@RequestParam(defaultValue = "1") Integer page,
                                                           Authentication authentication, Model mode) {
        return new ResponseEntity<>(productService.findAllProductBySeller(authentication.getName(), page), HttpStatus.FOUND);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProductMerchandise(@Valid @RequestBody ProductDTO productDTO,
                                                        Authentication authentication) {
        productService.save(productDTO, authentication.getName());
        return new ResponseEntity<>("success add product!", HttpStatus.OK);
    }

    @GetMapping("/detailProduct/{id}")
    public ResponseEntity<Product> getDetailProduct(@PathVariable("id") Long id, Authentication authentication) {
        Product product = productService.findProductSellerById(id, authentication.getName());

        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @PutMapping("/editProduct/{id}")
    public ResponseEntity<String> editProductById(@PathVariable("id") Long id,
                                                  @Valid @RequestBody ProductDTO productDTO,
                                                  Authentication authentication) {

        productDTO.setId(id);

        ProductDTO proDTO = productService.findProductDTOById(id);

        if(productDTO.getDiscontinue() != null){
            productDTO.setDiscontinue(proDTO.getDiscontinue());
        }

        productService.save(productDTO, authentication.getName());
        return new ResponseEntity<>("success edited product!", HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id,
                                                    Authentication authentication){
        if(productService.CountProductSellerById(sellerService.findSellerByUsername(authentication.getName()).getId(), id) == 0){
            throw new ObjectNotFound("Seller " + authentication.getName() + " tidak memiliki produk dengan id "+id);
        }else if(productService.findById(id).getOrder() == true){
            throw new RuntimeException("Produk dengan id " + id + "tidak dapat dihapus karena telah ditransaksikan!");
        }

        productService.delete(id);
        return new ResponseEntity<>("success deleted product!", HttpStatus.OK);
    }

    @GetMapping("/discontinue/{id}")
    public ResponseEntity<String> setDiscontinueProduct(@PathVariable("id") Long id,
                                                        Authentication authentication){

        ProductDTO dto = productService.findProductDTOById(id);
        if(dto.getDiscontinue() == true){
            throw new RuntimeException("product has been discontinued!");
        }else{
            dto.setDiscontinue(true);
            productService.save(dto, authentication.getName());
        }

        return new ResponseEntity<>("success discontinue this product!", HttpStatus.OK);
    }

}

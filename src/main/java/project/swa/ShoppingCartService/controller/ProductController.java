package project.swa.ShoppingCartService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swa.ShoppingCartService.exception.ShoppingCartNotFoundException;
import project.swa.ShoppingCartService.service.ShoppingCartDTO;
import project.swa.ShoppingCartService.service.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ProductController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> getCustomers() {
        List<ShoppingCartDTO> customerDTO1 = shoppingCartService.getAll();
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new ShoppingCartNotFoundException("Product not found");
            }
        } catch (ShoppingCartNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<ShoppingCartDTO> addCustomer(@RequestBody ShoppingCartDTO customerDTO) {
        ShoppingCartDTO customerDTO1 = shoppingCartService.add(customerDTO);
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
            } else {
                throw new ShoppingCartNotFoundException("Product not found");
            }
        } catch (ShoppingCartNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> updateCustomer(@PathVariable String id, @RequestBody ShoppingCartDTO customerDTO) {
        ShoppingCartDTO customerDTO1 = shoppingCartService.update(id, customerDTO);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new ShoppingCartNotFoundException("Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> deleteCustomer(@PathVariable String id) {
        ShoppingCartDTO customerDTO1 = shoppingCartService.delete(id);
        if (customerDTO1 != null) {
            return new ResponseEntity<>(customerDTO1, HttpStatus.CREATED);
        } else {
            throw new ShoppingCartNotFoundException("Product not found");
        }
    }
}

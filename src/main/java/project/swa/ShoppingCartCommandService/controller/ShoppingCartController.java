package project.swa.ShoppingCartCommandService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.swa.ShoppingCartCommandService.exception.ShoppingCartNotFoundException;
import project.swa.ShoppingCartCommandService.integration.KafkaSender;
import project.swa.ShoppingCartCommandService.service.ShoppingCartDTO;
import project.swa.ShoppingCartCommandService.service.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping("/shoppingcommand")
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class.getName());

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> getCustomers() {
        logger.info("Calling GET /shoppingcommand");
        List<ShoppingCartDTO> customerDTO1 = shoppingCartService.getAll();
        try {
            if (customerDTO1 != null) {
                return new ResponseEntity<>(customerDTO1, HttpStatus.OK);
            } else {
                throw new ShoppingCartNotFoundException("Product not found");
            }
        } catch (ShoppingCartNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<ShoppingCartDTO> addCustomer(@RequestBody ShoppingCartDTO cartDTO) {
        logger.info("Calling POST /shoppingcommand");
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.add(cartDTO);
        try {
            if (shoppingCartDTO != null) {
                kafkaSender.send(shoppingCartDTO);
                return new ResponseEntity<>(shoppingCartDTO, HttpStatus.CREATED);
            } else {
                throw new ShoppingCartNotFoundException("Product not found");
            }
        } catch (ShoppingCartNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> updateCustomer(@PathVariable String id, @RequestBody ShoppingCartDTO cartDTO) {
        logger.info("Calling PUT /shoppingcommand");
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.update(id, cartDTO);
        if (shoppingCartDTO != null) {
            kafkaSender.send(shoppingCartDTO);
            return new ResponseEntity<>(shoppingCartDTO, HttpStatus.OK);
        } else {
            throw new ShoppingCartNotFoundException("Product not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> deleteCustomer(@PathVariable String id) {
        logger.info("Calling DELETE /shoppingcommand");
        ShoppingCartDTO shoppingCartDTO = shoppingCartService.delete(id);
        if (shoppingCartDTO != null) {
            kafkaSender.send(shoppingCartDTO);
            return new ResponseEntity<>(shoppingCartDTO, HttpStatus.OK);
        } else {
            throw new ShoppingCartNotFoundException("Product not found");
        }
    }
}

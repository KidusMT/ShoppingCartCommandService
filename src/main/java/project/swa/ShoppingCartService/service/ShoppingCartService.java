package project.swa.ShoppingCartService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.swa.ShoppingCartService.data.ShoppingCartRepository;
import project.swa.ShoppingCartService.domain.ShoppingCart;
import project.swa.ShoppingCartService.exception.ShoppingCartNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCartDTO> getAll() {
        return shoppingCartRepository.findAll().stream().map(ShoppingCartAdapter::getShoppingCartDTO).toList();
    }

    public ShoppingCartDTO add(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart customer = shoppingCartRepository.save(ShoppingCartAdapter.getShoppingCart(shoppingCartDTO));
        return ShoppingCartAdapter.getShoppingCartDTO(customer);
    }

    public ShoppingCartDTO update(String id, ShoppingCartDTO shoppingCartDTO) {
        Optional<ShoppingCart> customerDTO1 = shoppingCartRepository.findById(id);
        if (customerDTO1.isPresent()) {
            shoppingCartDTO.setShoppingCartNumber(id);
            ShoppingCart customer = shoppingCartRepository.save(ShoppingCartAdapter.getShoppingCart(shoppingCartDTO));
            return ShoppingCartAdapter.getShoppingCartDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }

    public ShoppingCartDTO delete(String customerId) throws ShoppingCartNotFoundException {
        Optional<ShoppingCart> customerOptional = shoppingCartRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            ShoppingCart customer = customerOptional.get();
            shoppingCartRepository.delete(customer);
            return ShoppingCartAdapter.getShoppingCartDTO(customer);
        }
//        throw new CustomerNotFoundException();
        return null;
    }
}

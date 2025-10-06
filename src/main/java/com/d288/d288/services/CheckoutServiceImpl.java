package com.d288.d288.services;

import com.d288.d288.dao.CartRepository;
import com.d288.d288.dao.CustomerRepository;
import com.d288.d288.entities.Cart;
import com.d288.d288.entities.CartItem;
import com.d288.d288.entities.Customer;
import com.d288.d288.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the cart info
        Cart cart = purchase.getCart();


        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with CartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        cart.setStatus(StatusType.CartStatus.ordered);
        //save to db
        cartRepository.save(cart);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {
        //generate a random UUID
        return UUID.randomUUID().toString();
    }
}

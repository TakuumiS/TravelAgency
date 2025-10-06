package com.d288.d288.services;

import com.d288.d288.entities.Cart;
import com.d288.d288.entities.CartItem;
import com.d288.d288.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private String address;
    private Set<CartItem> cartItems;

}

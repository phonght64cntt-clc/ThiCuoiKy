package com.bake.bake_backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bake.bake_backend.entity.Order;
import com.bake.bake_backend.entity.OrderItem;
import com.bake.bake_backend.entity.Product;
import com.bake.bake_backend.entity.User;
import com.bake.bake_backend.repository.OrderRepository;
import com.bake.bake_backend.repository.ProductRepository;
import com.bake.bake_backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Order createOrder(String email, String address, List<Map<String, Object>> items) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User không tồn tại!"));

        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setStatus(Order.Status.PENDING);

        double total = 0;
        List<OrderItem> orderItems = new java.util.ArrayList<>();

        for (Map<String, Object> item : items) {
            Long productId = Long.valueOf(item.get("productId").toString());
            Integer quantity = Integer.valueOf(item.get("quantity").toString());

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại!"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(product.getPrice());

            total += product.getPrice() * quantity;
            orderItems.add(orderItem);
        }

        order.setTotal(total);
        order.setItems(orderItems);
        return orderRepository.save(order);
    }

    public List<Order> getMyOrders(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User không tồn tại!"));
        return orderRepository.findByUserId(user.getId());
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn hàng không tồn tại!"));
        order.setStatus(Order.Status.valueOf(status));
        return orderRepository.save(order);
    }
}
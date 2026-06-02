package com.bake.bake_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bake.bake_backend.entity.Order;
import com.bake.bake_backend.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // User đặt hàng
    @PostMapping
    public ResponseEntity<?> createOrder(Authentication auth,
                                          @RequestBody Map<String, Object> body) {
        try {
            String email = auth.getName();
            String address = body.get("address").toString();
            List<Map<String, Object>> items = (List<Map<String, Object>>) body.get("items");
            return ResponseEntity.ok(orderService.createOrder(email, address, items));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // User xem đơn của mình
    @GetMapping("/my")
    public ResponseEntity<?> getMyOrders(Authentication auth) {
        return ResponseEntity.ok(orderService.getMyOrders(auth.getName()));
    }

    // Admin xem tất cả đơn
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // Admin cập nhật trạng thái
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                           @RequestBody Map<String, String> body) {
        try {
            return ResponseEntity.ok(orderService.updateStatus(id, body.get("status")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
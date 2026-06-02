const BASE_URL = 'http://localhost:8081/api';

// Lấy token từ localStorage
const getToken = () => localStorage.getItem('token');

// Header có token
const authHeader = () => ({
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${getToken()}`
});

// AUTH
const api = {
    // Đăng ký
    register: async (name, email, password) => {
        const res = await fetch(`${BASE_URL}/auth/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, email, password })
        });
        return res.json();
    },

    // Đăng nhập
    login: async (email, password) => {
        const res = await fetch(`${BASE_URL}/auth/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password })
        });
        return res.json();
    },

    // PRODUCTS
    getProducts: async () => {
        const res = await fetch(`${BASE_URL}/products`);
        return res.json();
    },

    getProductsByCategory: async (categoryId) => {
        const res = await fetch(`${BASE_URL}/products/category/${categoryId}`);
        return res.json();
    },

    // CATEGORIES
    getCategories: async () => {
        const res = await fetch(`${BASE_URL}/categories`);
        return res.json();
    },

    // ORDERS
    createOrder: async (address, items) => {
        const res = await fetch(`${BASE_URL}/orders`, {
            method: 'POST',
            headers: authHeader(),
            body: JSON.stringify({ address, items })
        });
        return res.json();
    },

    getMyOrders: async () => {
        const res = await fetch(`${BASE_URL}/orders/my`, {
            headers: authHeader()
        });
        return res.json();
    },

   

    updateOrderStatus: async (id, status) => {
        const res = await fetch(`${BASE_URL}/orders/${id}/status`, {
            method: 'PUT',
            headers: authHeader(),
            body: JSON.stringify({ status })
        });
        return res.json();
    }
};

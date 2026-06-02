# BAKE - Bakery Store Website

Project: `64131798_HuynhThanhPhong_ThiCK`

BAKE is a bakery store web application with a static HTML/CSS/JavaScript frontend and a Spring Boot backend API. The application supports browsing products, adding items to cart, checkout, authentication, and viewing order history.

## Main Features

- Landing page introducing the BAKE bakery brand.
- Product page with 5 categories:
  - Cake
  - Cupcake
  - Macaron
  - Cookie
  - Dessert
- 30 bakery products, each with image, description, price, rating, and Add to Cart action.
- Shopping cart page:
  - View cart items
  - Increase/decrease quantity
  - Remove item
  - Clear cart
  - Order summary
  - Checkout modal
- Authentication:
  - Login
  - Logout
  - JWT-based backend authentication
- Order workflow:
  - Add products to cart before login
  - Login required before checkout
  - Create order through backend API
  - View My Orders page
- Responsive UI matching the bakery theme with purple and pink colors.

## Technologies

Frontend:

- HTML5
- CSS3
- JavaScript
- Font Awesome

Backend:

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- H2 Database
- Maven Wrapper

## Project Structure

```text
64131798_HuynhThanhPhong_ThiCK/
├── BAKE/                 # Frontend static website
│   ├── index.html
│   ├── menu.html
│   ├── order.html
│   ├── orders.html
│   ├── css/
│   ├── js/
│   └── img/
└── bake-backend/         # Spring Boot backend
    ├── src/main/java/
    ├── src/main/resources/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## Default Test Account

```text
Email: admin@bake.com
Password: admin123
```

## How To Run

### 1. Run Backend

Open a terminal in `bake-backend` and run:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell/CMD:

```bat
mvnw.cmd spring-boot:run
```

By default, the backend is configured for port `8080`. If port `8080` is busy, run it on port `8081`:

```bat
set SERVER_PORT=8081&&mvnw.cmd spring-boot:run
```

The frontend currently uses:

```text
http://localhost:8081/api
```

This is configured in:

```text
BAKE/js/api.js
```

### 2. Run Frontend

Open the frontend by serving the `BAKE` folder with any static server. Example using Node:

```bash
npx http-server BAKE -p 5510 -a 127.0.0.1 -c-1
```

Then open:

```text
http://127.0.0.1:5510/menu.html
```

## Main Pages

- `index.html`: Landing page
- `menu.html`: Product listing and categories
- `order.html`: Shopping cart and checkout
- `orders.html`: User order history

## Notes

- Local H2 database files are ignored by Git.
- Product seed data is stored in `bake-backend/src/main/resources/data.sql`.
- Product images are stored in `BAKE/img/products`.

# BAKE - Website bán bánh ngọt

Tên project: `64131798_HuynhThanhPhong_ThiCK`

BAKE là website bán bánh ngọt gồm frontend tĩnh bằng HTML/CSS/JavaScript và backend API bằng Spring Boot. Dự án hỗ trợ xem sản phẩm, lọc theo danh mục, thêm vào giỏ hàng, đăng nhập, đặt hàng và xem lịch sử đơn hàng.

## Chức năng chính

- Trang chủ giới thiệu thương hiệu BAKE.
- Trang sản phẩm với 5 danh mục:
  - Cake
  - Cupcake
  - Macaron
  - Cookie
  - Dessert
- 30 sản phẩm bánh, mỗi sản phẩm có:
  - Hình ảnh
  - Tên sản phẩm
  - Mô tả
  - Giá
  - Đánh giá sao
  - Nút thêm vào giỏ hàng
- Trang giỏ hàng:
  - Xem danh sách sản phẩm đã thêm
  - Tăng/giảm số lượng
  - Xóa từng sản phẩm
  - Xóa toàn bộ giỏ hàng
  - Xem tổng tiền
  - Mở form nhập thông tin giao hàng
- Chức năng tài khoản:
  - Đăng nhập
  - Đăng xuất
  - Lưu token JWT ở phía frontend
- Chức năng đặt hàng:
  - Người dùng có thể thêm sản phẩm vào giỏ trước khi đăng nhập
  - Khi thanh toán bắt buộc phải đăng nhập
  - Gửi đơn hàng lên backend
  - Lưu đơn hàng vào cơ sở dữ liệu H2
- Trang đơn hàng:
  - Xem lịch sử đơn hàng của người dùng
  - Lọc đơn hàng theo trạng thái
  - Hiển thị mã đơn, thời gian, số lượng sản phẩm, tổng tiền và trạng thái
- Giao diện responsive, dùng tông màu tím và hồng theo phong cách tiệm bánh.

## Công nghệ sử dụng

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

## Cấu trúc thư mục

```text
64131798_HuynhThanhPhong_ThiCK/
├── BAKE/                 # Frontend
│   ├── index.html        # Trang chủ
│   ├── menu.html         # Trang sản phẩm
│   ├── order.html        # Trang giỏ hàng/thanh toán
│   ├── orders.html       # Trang lịch sử đơn hàng
│   ├── css/
│   ├── js/
│   └── img/
└── bake-backend/         # Backend Spring Boot
    ├── src/main/java/
    ├── src/main/resources/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## Tài khoản test

```text
Email: admin@bake.com
Mật khẩu: admin123
```

## Cách chạy dự án

### 1. Chạy backend

Mở terminal tại thư mục `bake-backend`.

Trên Windows:

```bat
mvnw.cmd spring-boot:run
```

Nếu port `8080` đang bận, có thể chạy backend ở port `8081`:

```bat
set SERVER_PORT=8081&&mvnw.cmd spring-boot:run
```

Frontend hiện đang gọi API tại:

```text
http://localhost:8081/api
```

Cấu hình này nằm trong file:

```text
BAKE/js/api.js
```

Nếu muốn dùng port khác, sửa biến `BASE_URL` trong file trên.

### 2. Chạy frontend

Có thể mở frontend bằng một static server. Ví dụ dùng Node:

```bash
npx http-server BAKE -p 5510 -a 127.0.0.1 -c-1
```

Sau đó mở trình duyệt:

```text
http://127.0.0.1:5510/menu.html
```

## Các trang chính

- `index.html`: Trang giới thiệu
- `menu.html`: Trang sản phẩm và danh mục
- `order.html`: Trang giỏ hàng và thanh toán
- `orders.html`: Trang lịch sử đơn hàng

## Dữ liệu mẫu

- Dữ liệu danh mục, sản phẩm và tài khoản admin được seed trong:

```text
bake-backend/src/main/resources/data.sql
```

- Hình ảnh sản phẩm nằm trong:

```text
BAKE/img/products
```

## Ghi chú

- File database H2 local không được đưa lên Git.
- Thư mục build `target/` không được đưa lên Git.
- Khi checkout, người dùng cần đăng nhập để backend tạo đơn hàng theo tài khoản.

## Video demo



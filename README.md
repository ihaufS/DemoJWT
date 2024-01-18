# DemoJWT Project

## Giới thiệu

DemoJWT là một dự án mẫu được xây dựng để minh họa việc triển khai bảo mật API sử dụng Spring Security và JWT (JSON Web
Tokens) trong Spring Boot.

## Công nghệ

- **Spring Boot**: Để phát triển và triển khai một dịch vụ bảo mật với JWT.
- **Spring Security**: Để cung cấp các cơ chế bảo mật cho ứng dụng.
- **JWT**: Để tạo và xác thực tokens cho việc xác thực người dùng.

## Cài đặt và Chạy Dự Án

### Yêu cầu

Để chạy dự án này, bạn cần có:

- JDK 1.8 trở lên
- Maven 3.2+

### Cài đặt

Để cài đặt dự án, bạn cần thực hiện các bước sau:

1. Clone repository:

```
git clone https://github.com/ihaufS/DemoJWT.git
```

2. Truy cập vào thư mục chứa dự án và cài đặt các dependency bằng Maven:

```
cd DemoJWT
mvn install
```

### Chạy ứng dụng

Để chạy ứng dụng, bạn có thể sử dụng Spring Boot Maven plugin:

```
mvn spring-boot:run
```

Ứng dụng sẽ chạy trên cổng mặc định là `8080`.

## Sử dụng

### Đăng ký người dùng mới

```
POST /api/auth/signup
{
"username": "newuser",
"email": "newuser@example.com",
"password": "password"
}
```

### Đăng nhập và nhận JWT

```
POST /api/auth/signin
{
"username": "newuser",
"password": "password"
}
```

Sau khi đăng nhập thành công, bạn sẽ nhận được một JWT trong phần body của response.

### Truy cập tài nguyên được bảo vệ

Sử dụng JWT nhận được để truy cập các tài nguyên được bảo vệ:

```
GET /api/protected
Header: Authorization: Bearer <your_jwt_token_here>
```

## Kiến trúc

Dự án này bao gồm các thành phần chính sau:

- `SecurityConfig`: Cấu hình bảo mật cho ứng dụng.
- `AuthController`: Xử lý đăng ký và đăng nhập.
- `JwtTokenProvider`: Tạo và xác thực JWT.

## Bảo mật

Tất cả các mật khẩu đều được mã hóa trước khi lưu trữ trong cơ sở dữ liệu.

## License

Được cấp phép theo [MIT License](LICENSE).

## Tác giả

- [**IHau**](https://fb.com/LeKhuongHau) - *Initial work* - [DemoJWT](https://github.com/ihaufS/DemoJWT)

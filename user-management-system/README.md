# 用户管理系统

基于 Spring Boot + Vue 3 的用户管理系统，支持用户管理、角色权限管理、部门管理和操作日志。

## 技术栈

### 后端
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Spring Security + JWT
- MySQL 8.0

### 前端
- Vue 3 + TypeScript
- Vite
- Element Plus
- Pinia
- Vue Router
- Axios

## 功能模块

- 用户认证：登录、JWT token 认证
- 用户管理：用户增删改查、状态管理、批量操作
- 角色管理：角色列表、权限分配
- 部门管理：部门树形结构、增删改查
- 操作日志：用户操作记录、日志查询

## 快速开始

### 数据库配置

1. 确保 MySQL 已安装并运行
2. 执行数据库脚本：
```bash
mysql -h <host> -P 3306 -u root -p < database/schema.sql
```

默认数据库连接配置在 `backend/src/main/resources/application.yml`

### 后端启动

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

后端服务将在 http://localhost:8080 启动

### 前端启动

```bash
cd frontend
npm install
npm run dev
```

前端服务将在 http://localhost:5173 启动

## 默认账号

- 用户名：`admin`
- 密码：`admin123`

## API 接口

### 认证
- POST `/api/auth/login` - 用户登录

### 用户管理
- GET `/api/users` - 用户列表（支持搜索、分页）
- GET `/api/users/{id}` - 获取用户详情
- POST `/api/users` - 创建用户
- PUT `/api/users/{id}` - 更新用户
- DELETE `/api/users/{id}` - 删除用户
- PATCH `/api/users/{id}/status` - 更新用户状态

### 角色管理
- GET `/api/roles` - 角色列表
- GET `/api/roles/{id}` - 获取角色详情
- GET `/api/roles/user/{userId}` - 获取用户角色

### 部门管理
- GET `/api/departments` - 部门列表
- GET `/api/departments/tree` - 部门树
- POST `/api/departments` - 创建部门
- PUT `/api/departments/{id}` - 更新部门
- DELETE `/api/departments/{id}` - 删除部门

### 操作日志
- GET `/api/logs` - 操作日志列表（支持搜索、分页）

## 项目结构

```
user-management-system/
├── backend/                    # 后端
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/usermanagement/
│   │       │       ├── entity/      # 实体类
│   │       │       ├── repository/  # 数据访问层
│   │       │       ├── service/     # 业务逻辑层
│   │       │       ├── controller/  # 控制器
│   │       │       ├── dto/         # 数据传输对象
│   │       │       ├── config/      # 配置类
│   │       │       └── util/        # 工具类
│   │       └── resources/
│   │           └── application.yml  # 应用配置
│   └── pom.xml
├── frontend/                   # 前端
│   ├── src/
│   │   ├── api/              # API 接口
│   │   ├── views/            # 页面组件
│   │   ├── stores/           # Pinia 状态管理
│   │   ├── router/           # 路由配置
│   │   └── main.ts           # 入口文件
│   ├── package.json
│   └── vite.config.ts
└── database/
    └── schema.sql            # 数据库脚本
```

## 开发说明

### 数据库连接配置

修改 `backend/src/main/resources/application.yml` 中的数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://<host>:<port>/<database>?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: <username>
    password: <password>
```

### JWT 配置

修改 `application.yml` 中的 JWT 配置：

```yaml
jwt:
  secret: your-secret-key-change-this-in-production
  expiration: 86400000  # token 有效期（毫秒）
```

## License

MIT

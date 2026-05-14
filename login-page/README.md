# 科技感炫酷登录页面

一个具有科技感和炫酷视觉效果的登录页面，使用纯 HTML/CSS/JavaScript 实现。

## 功能特性

- ✨ 科技感炫酷视觉设计
- 🎨 深色主题配合霓虹渐变
- 💫 粒子背景动画
- 🪟 玻璃态（Glassmorphism）效果
- 🔄 流畅的动画过渡
- 📱 完全响应式设计
- 🔐 多种登录方式支持

## 登录方式

1. 邮箱 + 密码登录
2. 手机号 + 验证码登录
3. 微信社交登录

## 文件结构

```
login-page/
├── index.html              # 主页面
├── css/
│   ├── style.css           # 主样式
│   └── animations.css      # 动画关键帧
├── js/
│   ├── particles.js        # 粒子背景动画
│   ├── tabs.js             # Tab 切换逻辑
│   ├── form.js             # 表单验证
│   └── carousel.js         # 展示区轮播
└── assets/
    └── images/
        ├── logo.svg        # Logo
        └── wechat.svg      # 微信图标
```

## 使用方法

1. 直接在浏览器中打开 `index.html` 文件
2. 或使用本地服务器：
   ```bash
   # 使用 Python
   python -m http.server 8000

   # 使用 Node.js
   npx serve
   ```

## 浏览器兼容性

- Chrome/Edge: 最新版
- Firefox: 最新版
- Safari: 最新版

## 技术栈

- HTML5
- CSS3 (Flexbox, Grid, 动画, backdrop-filter)
- 原生 JavaScript
- Canvas API

## 自定义

### 修改配色

在 `css/style.css` 的 `:root` 中修改 CSS 变量：

```css
:root {
    --accent-primary: #00f0ff;    /* 主强调色 */
    --accent-secondary: #7b2dff;  /* 次强调色 */
    /* ... */
}
```

### 调整粒子数量

在 `js/particles.js` 中修改 `particleCount`：

```javascript
this.particleCount = 80; // 默认 80 个粒子
```

## API 集成

在 `js/form.js` 中找到 TODO 注释，替换为实际的 API 调用。

## License

MIT

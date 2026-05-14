# 科技感炫酷登录页面实施计划

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** 构建一个具有科技感炫酷视觉效果的登录页面，支持邮箱密码、手机验证码和微信登录三种方式

**Architecture:** 纯 HTML/CSS/JavaScript 单页应用，使用 Canvas 绘制粒子背景动画，CSS 实现玻璃态效果和动画，原生 JavaScript 处理表单逻辑

**Tech Stack:** HTML5, CSS3 (Flexbox/Grid, 动画, backdrop-filter), 原生 JavaScript, Canvas API

---

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

---

### Task 1: 创建项目目录结构

**Files:**
- Create: `index.html`, `css/style.css`, `css/animations.css`, `js/particles.js`, `js/tabs.js`, `js/form.js`, `js/carousel.js`
- Create: `assets/images/` 目录

- [ ] **Step 1: 创建所有必要的目录**

```bash
mkdir -p login-page/css login-page/js login-page/assets/images
```

- [ ] **Step 2: 创建所有空文件**

```bash
touch login-page/index.html
touch login-page/css/style.css
touch login-page/css/animations.css
touch login-page/js/particles.js
touch login-page/js/tabs.js
touch login-page/js/form.js
touch login-page/js/carousel.js
```

- [ ] **Step 3: 初始化 git 仓库并创建 .gitignore**

```bash
cd login-page
git init
cat > .gitignore << 'EOF'
node_modules/
.DS_Store
*.log
EOF
```

- [ ] **Step 4: 提交初始结构**

```bash
git add .
git commit -m "chore: initialize project structure"
```

---

### Task 2: 创建 CSS 动画定义文件

**Files:**
- Create: `css/animations.css`

- [ ] **Step 1: 编写 animations.css 文件**

```css
/* 背景流光渐变动画 */
@keyframes gradientFlow {
    0% {
        background-position: 0% 50%;
    }
    50% {
        background-position: 100% 50%;
    }
    100% {
        background-position: 0% 50%;
    }
}

/* 输入框聚焦发光动画 */
@keyframes inputGlow {
    0% {
        box-shadow: 0 0 5px rgba(0, 240, 255, 0.3);
    }
    50% {
        box-shadow: 0 0 20px rgba(0, 240, 255, 0.6), 0 0 30px rgba(0, 240, 255, 0.4);
    }
    100% {
        box-shadow: 0 0 5px rgba(0, 240, 255, 0.3);
    }
}

/* 按钮渐变流动效果 */
@keyframes buttonGradient {
    0% {
        background-position: 0% 50%;
    }
    50% {
        background-position: 100% 50%;
    }
    100% {
        background-position: 0% 50%;
    }
}

/* 按钮发光效果 */
@keyframes buttonGlow {
    0%, 100% {
        box-shadow: 0 0 20px rgba(0, 240, 255, 0.4);
    }
    50% {
        box-shadow: 0 0 40px rgba(0, 240, 255, 0.8), 0 0 60px rgba(123, 45, 255, 0.4);
    }
}

/* Tab 下划线滑动动画 */
@keyframes tabSlide {
    from {
        transform: translateX(0);
    }
    to {
        transform: translateX(100%);
    }
}

/* 元素淡入上浮动画 */
@keyframes fadeSlideUp {
    from {
        opacity: 0;
        transform: translateY(30px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* 霓虹文字闪烁 */
@keyframes neonPulse {
    0%, 100% {
        text-shadow: 0 0 10px rgba(0, 240, 255, 0.5),
                     0 0 20px rgba(0, 240, 255, 0.3),
                     0 0 30px rgba(0, 240, 255, 0.2);
    }
    50% {
        text-shadow: 0 0 20px rgba(0, 240, 255, 0.8),
                     0 0 40px rgba(0, 240, 255, 0.5),
                     0 0 60px rgba(0, 240, 255, 0.3);
    }
}

/* 卡片玻璃态出现动画 */
@keyframes glassAppear {
    from {
        opacity: 0;
        backdrop-filter: blur(0px);
        transform: scale(0.95);
    }
    to {
        opacity: 1;
        backdrop-filter: blur(20px);
        transform: scale(1);
    }
}

/* 轮播图切换动画 */
@keyframes slideIn {
    from {
        opacity: 0;
        transform: translateX(50px);
    }
    to {
        opacity: 1;
        transform: translateX(0);
    }
}

/* 微信图标悬浮效果 */
@keyframes wechatHover {
    0% {
        transform: translateY(0);
        box-shadow: 0 4px 15px rgba(7, 193, 102, 0.3);
    }
    50% {
        transform: translateY(-3px);
        box-shadow: 0 8px 25px rgba(7, 193, 102, 0.5);
    }
    100% {
        transform: translateY(0);
        box-shadow: 0 4px 15px rgba(7, 193, 102, 0.3);
    }
}

/* 案例卡片滚动动画 */
@keyframes scrollCards {
    0% {
        transform: translateX(0);
    }
    100% {
        transform: translateX(-50%);
    }
}

/* 加载动画 */
@keyframes spin {
    from {
        transform: rotate(0deg);
    }
    to {
        transform: rotate(360deg);
    }
}
```

- [ ] **Step 2: 提交 animations.css**

```bash
git add css/animations.css
git commit -m "feat: add CSS animations definitions"
```

---

### Task 3: 创建主样式文件

**Files:**
- Create: `css/style.css`

- [ ] **Step 1: 编写 style.css 文件 - CSS 变量和重置**

```css
/* ===== CSS 变量 ===== */
:root {
    /* 背景色 */
    --bg-primary: #0a0e27;
    --bg-secondary: #1a1f3a;

    /* 强调色 */
    --accent-primary: #00f0ff;
    --accent-secondary: #7b2dff;
    --accent-success: #00ffa3;

    /* 文字色 */
    --text-primary: #ffffff;
    --text-secondary: #a0aec0;

    /* 玻璃态 */
    --glass-bg: rgba(255, 255, 255, 0.05);
    --glass-border: rgba(0, 240, 255, 0.3);

    /* 微信绿 */
    --wechat-green: #07c160;
}

/* ===== 重置样式 ===== */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
    overflow-x: hidden;
}
```

- [ ] **Step 2: 添加背景样式**

```css
/* 在 style.css 中添加 */

/* ===== 背景容器 ===== */
.background-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(135deg, var(--bg-primary), var(--bg-secondary), var(--bg-primary));
    background-size: 400% 400%;
    animation: gradientFlow 15s ease infinite;
    z-index: -2;
}

/* 粒子画布 */
#particles-canvas {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: -1;
}
```

- [ ] **Step 3: 添加主容器布局**

```css
/* 在 style.css 中添加 */

/* ===== 主容器 ===== */
.main-container {
    display: flex;
    min-height: 100vh;
    align-items: center;
    justify-content: center;
    padding: 20px;
}
```

- [ ] **Step 4: 添加登录卡片样式**

```css
/* 在 style.css 中添加 */

/* ===== 登录卡片 ===== */
.login-card {
    background: var(--glass-bg);
    backdrop-filter: blur(20px);
    border: 1px solid var(--glass-border);
    border-radius: 24px;
    padding: 40px;
    width: 100%;
    max-width: 420px;
    animation: glassAppear 0.6s ease-out;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
}
```

- [ ] **Step 5: 添加 Logo 和标题样式**

```css
/* 在 style.css 中添加 */

/* ===== Logo 和标题 ===== */
.logo-section {
    text-align: center;
    margin-bottom: 32px;
}

.logo {
    width: 64px;
    height: 64px;
    margin: 0 auto 16px;
}

.logo svg {
    width: 100%;
    height: 100%;
    fill: var(--accent-primary);
    filter: drop-shadow(0 0 10px rgba(0, 240, 255, 0.5));
}

.title {
    font-size: 28px;
    font-weight: 700;
    color: var(--text-primary);
    margin-bottom: 8px;
    animation: neonPulse 3s ease-in-out infinite;
}

.subtitle {
    font-size: 14px;
    color: var(--text-secondary);
}
```

- [ ] **Step 6: 添加 Tab 切换样式**

```css
/* 在 style.css 中添加 */

/* ===== Tab 切换 ===== */
.tab-container {
    display: flex;
    background: rgba(0, 0, 0, 0.2);
    border-radius: 12px;
    padding: 4px;
    margin-bottom: 24px;
    position: relative;
}

.tab-item {
    flex: 1;
    padding: 12px;
    text-align: center;
    cursor: pointer;
    color: var(--text-secondary);
    font-size: 14px;
    font-weight: 500;
    transition: all 0.3s ease;
    border-radius: 8px;
    position: relative;
    z-index: 1;
}

.tab-item.active {
    color: var(--text-primary);
    background: linear-gradient(135deg, rgba(0, 240, 255, 0.2), rgba(123, 45, 255, 0.2));
}

.tab-item:hover:not(.active) {
    color: var(--text-primary);
    background: rgba(255, 255, 255, 0.05);
}
```

- [ ] **Step 7: 添加表单元素样式**

```css
/* 在 style.css 中添加 */

/* ===== 表单元素 ===== */
.form-group {
    margin-bottom: 20px;
}

.form-label {
    display: block;
    font-size: 13px;
    color: var(--text-secondary);
    margin-bottom: 8px;
}

.form-input {
    width: 100%;
    padding: 14px 16px;
    background: rgba(0, 0, 0, 0.2);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 12px;
    color: var(--text-primary);
    font-size: 15px;
    transition: all 0.3s ease;
    outline: none;
}

.form-input:focus {
    border-color: var(--accent-primary);
    animation: inputGlow 2s ease-in-out infinite;
}

.form-input::placeholder {
    color: rgba(255, 255, 255, 0.3);
}

.form-input-error {
    border-color: #ff4757;
}

.error-message {
    font-size: 12px;
    color: #ff4757;
    margin-top: 6px;
    display: none;
}

.error-message.show {
    display: block;
}
```

- [ ] **Step 8: 添加验证码输入组样式**

```css
/* 在 style.css 中添加 */

/* ===== 验证码输入组 ===== */
.verification-group {
    display: flex;
    gap: 12px;
}

.verification-group .form-input {
    flex: 1;
}

.send-code-btn {
    padding: 14px 20px;
    background: linear-gradient(135deg, var(--accent-primary), var(--accent-secondary));
    background-size: 200% 200%;
    border: none;
    border-radius: 12px;
    color: var(--text-primary);
    font-size: 14px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
    white-space: nowrap;
    animation: buttonGradient 3s ease infinite;
}

.send-code-btn:hover:not(:disabled) {
    animation: buttonGradient 3s ease infinite, buttonGlow 2s ease-in-out infinite;
}

.send-code-btn:disabled {
    opacity: 0.5;
    cursor: not-allowed;
}
```

- [ ] **Step 9: 添加记住我和忘记密码样式**

```css
/* 在 style.css 中添加 */

/* ===== 记住我 & 忘记密码 ===== */
.form-options {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 24px;
}

.checkbox-group {
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
}

.checkbox-group input[type="checkbox"] {
    appearance: none;
    width: 18px;
    height: 18px;
    border: 2px solid rgba(255, 255, 255, 0.2);
    border-radius: 4px;
    cursor: pointer;
    position: relative;
    transition: all 0.3s ease;
}

.checkbox-group input[type="checkbox"]:checked {
    background: linear-gradient(135deg, var(--accent-primary), var(--accent-secondary));
    border-color: var(--accent-primary);
}

.checkbox-group input[type="checkbox"]:checked::after {
    content: '✓';
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: var(--text-primary);
    font-size: 12px;
    font-weight: bold;
}

.checkbox-label {
    font-size: 13px;
    color: var(--text-secondary);
    user-select: none;
}

.forgot-password {
    font-size: 13px;
    color: var(--accent-primary);
    text-decoration: none;
    transition: all 0.3s ease;
}

.forgot-password:hover {
    color: var(--accent-secondary);
    text-shadow: 0 0 10px rgba(123, 45, 255, 0.5);
}
```

- [ ] **Step 10: 添加按钮样式**

```css
/* 在 style.css 中添加 */

/* ===== 按钮 ===== */
.btn {
    width: 100%;
    padding: 16px;
    border: none;
    border-radius: 12px;
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.3s ease;
}

.btn-primary {
    background: linear-gradient(135deg, var(--accent-primary), var(--accent-secondary));
    background-size: 200% 200%;
    color: var(--text-primary);
    animation: buttonGradient 3s ease infinite;
}

.btn-primary:hover {
    animation: buttonGradient 3s ease infinite, buttonGlow 2s ease-in-out infinite;
    transform: translateY(-2px);
}

.btn-primary:active {
    transform: translateY(0);
}

.btn-loading {
    position: relative;
    color: transparent;
}

.btn-loading::after {
    content: '';
    position: absolute;
    top: 50%;
    left: 50%;
    width: 20px;
    height: 20px;
    margin: -10px 0 0 -10px;
    border: 2px solid transparent;
    border-top-color: var(--text-primary);
    border-radius: 50%;
    animation: spin 0.8s linear infinite;
}
```

- [ ] **Step 11: 添加分割线样式**

```css
/* 在 style.css 中添加 */

/* ===== 分割线 ===== */
.divider {
    display: flex;
    align-items: center;
    margin: 24px 0;
    color: var(--text-secondary);
    font-size: 13px;
}

.divider::before,
.divider::after {
    content: '';
    flex: 1;
    height: 1px;
    background: rgba(255, 255, 255, 0.1);
}

.divider span {
    padding: 0 16px;
}
```

- [ ] **Step 12: 添加社交登录样式**

```css
/* 在 style.css 中添加 */

/* ===== 社交登录 ===== */
.social-login {
    display: flex;
    justify-content: center;
    gap: 16px;
}

.social-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    padding: 14px;
    background: rgba(0, 0, 0, 0.2);
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 12px;
    cursor: pointer;
    transition: all 0.3s ease;
}

.social-btn svg {
    width: 24px;
    height: 24px;
    fill: var(--wechat-green);
}

.social-btn:hover {
    animation: wechatHover 1.5s ease-in-out infinite;
    background: rgba(7, 193, 102, 0.1);
    border-color: var(--wechat-green);
}
```

- [ ] **Step 13: 添加注册链接样式**

```css
/* 在 style.css 中添加 */

/* ===== 注册链接 ===== */
.register-link {
    text-align: center;
    margin-top: 24px;
    font-size: 14px;
    color: var(--text-secondary);
}

.register-link a {
    color: var(--accent-primary);
    text-decoration: none;
    font-weight: 600;
    transition: all 0.3s ease;
}

.register-link a:hover {
    color: var(--accent-secondary);
    text-shadow: 0 0 10px rgba(123, 45, 255, 0.5);
}
```

- [ ] **Step 14: 添加表单容器样式（控制显示隐藏）**

```css
/* 在 style.css 中添加 */

/* ===== 表单容器 ===== */
.form-container {
    display: none;
    animation: fadeSlideUp 0.4s ease-out;
}

.form-container.active {
    display: block;
}
```

- [ ] **Step 15: 添加响应式样式**

```css
/* 在 style.css 中添加 */

/* ===== 响应式设计 ===== */
@media (max-width: 768px) {
    .login-card {
        padding: 24px;
        max-width: 100%;
    }

    .title {
        font-size: 24px;
    }

    .form-input {
        padding: 12px 14px;
        font-size: 14px;
    }

    .btn {
        padding: 14px;
        font-size: 15px;
    }
}
```

- [ ] **Step 16: 添加展示区样式（桌面版左侧）**

```css
/* 在 style.css 中添加 */

/* ===== 展示区（桌面版） ===== */
@media (min-width: 1024px) {
    .main-container {
        justify-content: center;
        gap: 60px;
    }

    .showcase-section {
        flex: 1;
        max-width: 500px;
        display: flex;
        flex-direction: column;
        animation: fadeSlideUp 0.6s ease-out 0.2s both;
    }

    .showcase-logo {
        text-align: center;
        margin-bottom: 32px;
    }

    .showcase-logo .logo {
        width: 80px;
        height: 80px;
    }

    .showcase-title {
        font-size: 36px;
        font-weight: 700;
        color: var(--text-primary);
        text-align: center;
        margin-bottom: 12px;
        animation: neonPulse 3s ease-in-out infinite;
    }

    .showcase-subtitle {
        font-size: 18px;
        color: var(--text-secondary);
        text-align: center;
    }

    .carousel-container {
        margin-top: 40px;
        position: relative;
        overflow: hidden;
        border-radius: 16px;
        aspect-ratio: 16/10;
        background: rgba(0, 0, 0, 0.2);
    }

    .carousel-slide {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        opacity: 0;
        transition: opacity 0.5s ease;
        display: flex;
        align-items: center;
        justify-content: center;
        background: linear-gradient(135deg, rgba(0, 240, 255, 0.1), rgba(123, 45, 255, 0.1));
    }

    .carousel-slide.active {
        opacity: 1;
        animation: slideIn 0.5s ease-out;
    }

    .carousel-placeholder {
        font-size: 72px;
        color: var(--accent-primary);
    }

    .carousel-indicators {
        position: absolute;
        bottom: 16px;
        left: 50%;
        transform: translateX(-50%);
        display: flex;
        gap: 8px;
    }

    .carousel-indicator {
        width: 8px;
        height: 8px;
        border-radius: 50%;
        background: rgba(255, 255, 255, 0.3);
        cursor: pointer;
        transition: all 0.3s ease;
    }

    .carousel-indicator.active {
        width: 24px;
        border-radius: 4px;
        background: var(--accent-primary);
    }

    .testimonials {
        margin-top: 40px;
    }

    .testimonials-title {
        font-size: 16px;
        color: var(--text-secondary);
        margin-bottom: 20px;
    }

    .testimonial-card {
        background: rgba(0, 0, 0, 0.2);
        border: 1px solid rgba(255, 255, 255, 0.05);
        border-radius: 12px;
        padding: 20px;
        margin-bottom: 16px;
    }

    .testimonial-text {
        font-size: 14px;
        color: var(--text-primary);
        line-height: 1.6;
        margin-bottom: 12px;
    }

    .testimonial-author {
        font-size: 13px;
        color: var(--text-secondary);
    }
}
```

- [ ] **Step 17: 添加平板版样式**

```css
/* 在 style.css 中添加 */

/* ===== 平板版 ===== */
@media (min-width: 768px) and (max-width: 1023px) {
    .main-container {
        flex-direction: column;
        gap: 24px;
    }

    .showcase-section {
        display: flex;
        max-width: 100%;
        flex-direction: row;
        align-items: center;
        gap: 24px;
    }

    .showcase-logo {
        margin-bottom: 0;
    }

    .showcase-logo .logo {
        width: 48px;
        height: 48px;
        margin: 0;
    }

    .showcase-title {
        font-size: 24px;
        text-align: left;
    }

    .showcase-subtitle {
        display: none;
    }

    .carousel-container {
        display: none;
    }

    .testimonials {
        display: none;
    }
}
```

- [ ] **Step 18: 提交 style.css**

```bash
git add css/style.css
git commit -m "feat: add main styles with responsive design"
```

---

### Task 4: 创建粒子背景动画

**Files:**
- Create: `js/particles.js`

- [ ] **Step 1: 编写 particles.js 文件**

```javascript
/**
 * 粒子背景动画
 * 创建浮动的粒子网格效果
 */

class ParticleNetwork {
    constructor(canvasId) {
        this.canvas = document.getElementById(canvasId);
        this.ctx = this.canvas.getContext('2d');
        this.particles = [];
        this.particleCount = 80;
        this.connectionDistance = 120;
        this.mouseRadius = 150;

        this.mouse = {
            x: null,
            y: null
        };

        this.init();
    }

    init() {
        this.resize();
        this.createParticles();
        this.addEventListeners();
        this.animate();
    }

    resize() {
        this.canvas.width = window.innerWidth;
        this.canvas.height = window.innerHeight;
    }

    createParticles() {
        this.particles = [];
        for (let i = 0; i < this.particleCount; i++) {
            this.particles.push({
                x: Math.random() * this.canvas.width,
                y: Math.random() * this.canvas.height,
                vx: (Math.random() - 0.5) * 0.5,
                vy: (Math.random() - 0.5) * 0.5,
                radius: Math.random() * 2 + 1
            });
        }
    }

    addEventListeners() {
        window.addEventListener('resize', () => {
            this.resize();
            this.createParticles();
        });

        window.addEventListener('mousemove', (e) => {
            this.mouse.x = e.x;
            this.mouse.y = e.y;
        });

        window.addEventListener('mouseout', () => {
            this.mouse.x = null;
            this.mouse.y = null;
        });
    }

    updateParticle(particle) {
        // 移动粒子
        particle.x += particle.vx;
        particle.y += particle.vy;

        // 边界检测
        if (particle.x < 0 || particle.x > this.canvas.width) {
            particle.vx *= -1;
        }
        if (particle.y < 0 || particle.y > this.canvas.height) {
            particle.vy *= -1;
        }

        // 鼠标交互
        if (this.mouse.x !== null && this.mouse.y !== null) {
            const dx = this.mouse.x - particle.x;
            const dy = this.mouse.y - particle.y;
            const distance = Math.sqrt(dx * dx + dy * dy);

            if (distance < this.mouseRadius) {
                const force = (this.mouseRadius - distance) / this.mouseRadius;
                particle.x -= dx * force * 0.02;
                particle.y -= dy * force * 0.02;
            }
        }
    }

    drawParticle(particle) {
        this.ctx.beginPath();
        this.ctx.arc(particle.x, particle.y, particle.radius, 0, Math.PI * 2);
        this.ctx.fillStyle = 'rgba(0, 240, 255, 0.6)';
        this.ctx.fill();
    }

    drawConnections() {
        for (let i = 0; i < this.particles.length; i++) {
            for (let j = i + 1; j < this.particles.length; j++) {
                const dx = this.particles[i].x - this.particles[j].x;
                const dy = this.particles[i].y - this.particles[j].y;
                const distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < this.connectionDistance) {
                    const opacity = (1 - distance / this.connectionDistance) * 0.3;
                    this.ctx.beginPath();
                    this.ctx.strokeStyle = `rgba(0, 240, 255, ${opacity})`;
                    this.ctx.lineWidth = 1;
                    this.ctx.moveTo(this.particles[i].x, this.particles[i].y);
                    this.ctx.lineTo(this.particles[j].x, this.particles[j].y);
                    this.ctx.stroke();
                }
            }
        }
    }

    animate() {
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);

        this.particles.forEach(particle => {
            this.updateParticle(particle);
            this.drawParticle(particle);
        });

        this.drawConnections();

        requestAnimationFrame(() => this.animate());
    }
}

// 初始化
document.addEventListener('DOMContentLoaded', () => {
    new ParticleNetwork('particles-canvas');
});
```

- [ ] **Step 2: 提交 particles.js**

```bash
git add js/particles.js
git commit -m "feat: add particle background animation"
```

---

### Task 5: 创建 Tab 切换逻辑

**Files:**
- Create: `js/tabs.js`

- [ ] **Step 1: 编写 tabs.js 文件**

```javascript
/**
 * Tab 切换功能
 * 处理邮箱登录和手机验证码登录之间的切换
 */

document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.tab-item');
    const forms = document.querySelectorAll('.form-container');

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            // 移除所有 active 状态
            tabs.forEach(t => t.classList.remove('active'));
            forms.forEach(f => f.classList.remove('active'));

            // 添加 active 状态到当前选中的 tab
            tab.classList.add('active');

            // 显示对应的表单
            const targetForm = tab.dataset.form;
            document.getElementById(targetForm).classList.add('active');
        });
    });
});
```

- [ ] **Step 2: 提交 tabs.js**

```bash
git add js/tabs.js
git commit -m "feat: add tab switching functionality"
```

---

### Task 6: 创建表单验证

**Files:**
- Create: `js/form.js`

- [ ] **Step 1: 编写 form.js 文件 - 验证函数**

```javascript
/**
 * 表单验证和处理
 */

// 验证规则
const validators = {
    email: (value) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!value) return '请输入邮箱地址';
        if (!emailRegex.test(value)) return '请输入有效的邮箱地址';
        return null;
    },

    password: (value) => {
        if (!value) return '请输入密码';
        if (value.length < 8) return '密码至少需要8位';
        if (!/(?=.*[a-zA-Z])(?=.*\d)/.test(value)) {
            return '密码需要包含字母和数字';
        }
        return null;
    },

    phone: (value) => {
        const phoneRegex = /^1[3-9]\d{9}$/;
        if (!value) return '请输入手机号';
        if (!phoneRegex.test(value)) return '请输入有效的手机号';
        return null;
    },

    code: (value) => {
        const codeRegex = /^\d{6}$/;
        if (!value) return '请输入验证码';
        if (!codeRegex.test(value)) return '请输入6位数字验证码';
        return null;
    }
};

// 显示错误
function showError(inputId, message) {
    const input = document.getElementById(inputId);
    const errorElement = document.getElementById(`${inputId}-error`);

    if (input && errorElement) {
        input.classList.add('form-input-error');
        errorElement.textContent = message;
        errorElement.classList.add('show');
    }
}

// 清除错误
function clearError(inputId) {
    const input = document.getElementById(inputId);
    const errorElement = document.getElementById(`${inputId}-error`);

    if (input && errorElement) {
        input.classList.remove('form-input-error');
        errorElement.classList.remove('show');
    }
}

// 验证单个字段
function validateField(inputId) {
    const input = document.getElementById(inputId);
    const type = input.dataset.validate;

    if (type && validators[type]) {
        const error = validators[type](input.value);
        if (error) {
            showError(inputId, error);
            return false;
        } else {
            clearError(inputId);
            return true;
        }
    }
    return true;
}

// 验证整个表单
function validateForm(formId) {
    const form = document.getElementById(formId);
    const inputs = form.querySelectorAll('[data-validate]');
    let isValid = true;

    inputs.forEach(input => {
        if (!validateField(input.id)) {
            isValid = false;
        }
    });

    return isValid;
}
```

- [ ] **Step 2: 添加实时验证功能**

```javascript
// 在 form.js 中添加

/**
 * 实时验证
 */
document.addEventListener('DOMContentLoaded', () => {
    // 为所有需要验证的输入框添加实时验证
    const inputs = document.querySelectorAll('[data-validate]');

    inputs.forEach(input => {
        input.addEventListener('blur', () => {
            validateField(input.id);
        });

        input.addEventListener('input', () => {
            if (input.classList.contains('form-input-error')) {
                validateField(input.id);
            }
        });
    });
});
```

- [ ] **Step 3: 添加表单提交处理**

```javascript
// 在 form.js 中添加

/**
 * 表单提交处理
 */
document.addEventListener('DOMContentLoaded', () => {
    // 邮箱登录表单
    const emailForm = document.getElementById('email-form');
    if (emailForm) {
        emailForm.addEventListener('submit', async (e) => {
            e.preventDefault();

            if (!validateForm('email-form')) {
                return;
            }

            const submitBtn = emailForm.querySelector('.btn-primary');
            const originalText = submitBtn.textContent;

            submitBtn.classList.add('btn-loading');
            submitBtn.disabled = true;

            // 模拟 API 调用
            await new Promise(resolve => setTimeout(resolve, 1500));

            // TODO: 实际的 API 调用
            console.log('Email login:', {
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
                remember: document.getElementById('remember').checked
            });

            submitBtn.classList.remove('btn-loading');
            submitBtn.disabled = false;
            alert('登录成功！（演示）');
        });
    }

    // 手机验证码登录表单
    const smsForm = document.getElementById('sms-form');
    if (smsForm) {
        smsForm.addEventListener('submit', async (e) => {
            e.preventDefault();

            if (!validateForm('sms-form')) {
                return;
            }

            const submitBtn = smsForm.querySelector('.btn-primary');
            const originalText = submitBtn.textContent;

            submitBtn.classList.add('btn-loading');
            submitBtn.disabled = true;

            // 模拟 API 调用
            await new Promise(resolve => setTimeout(resolve, 1500));

            // TODO: 实际的 API 调用
            console.log('SMS login:', {
                phone: document.getElementById('phone').value,
                code: document.getElementById('code').value
            });

            submitBtn.classList.remove('btn-loading');
            submitBtn.disabled = false;
            alert('登录成功！（演示）');
        });
    }
});
```

- [ ] **Step 4: 添加发送验证码功能**

```javascript
// 在 form.js 中添加

/**
 * 发送验证码
 */
document.addEventListener('DOMContentLoaded', () => {
    const sendCodeBtn = document.getElementById('send-code-btn');

    if (sendCodeBtn) {
        let countdown = 0;
        let timer = null;

        sendCodeBtn.addEventListener('click', async () => {
            const phoneInput = document.getElementById('phone');

            // 验证手机号
            const error = validators.phone(phoneInput.value);
            if (error) {
                showError('phone', error);
                return;
            }

            clearError('phone');

            // 开始倒计时
            countdown = 60;
            sendCodeBtn.disabled = true;
            sendCodeBtn.textContent = `${countdown}s 后重新发送`;

            timer = setInterval(() => {
                countdown--;
                if (countdown > 0) {
                    sendCodeBtn.textContent = `${countdown}s 后重新发送`;
                } else {
                    clearInterval(timer);
                    sendCodeBtn.disabled = false;
                    sendCodeBtn.textContent = '发送验证码';
                }
            }, 1000);

            // TODO: 实际的 API 调用
            console.log('Send SMS code to:', phoneInput.value);
            alert('验证码已发送！（演示）');
        });
    }
});
```

- [ ] **Step 5: 添加微信登录处理**

```javascript
// 在 form.js 中添加

/**
 * 微信登录
 */
document.addEventListener('DOMContentLoaded', () => {
    const wechatBtn = document.querySelector('.wechat-login-btn');

    if (wechatBtn) {
        wechatBtn.addEventListener('click', () => {
            // TODO: 实际的微信 OAuth 流程
            console.log('WeChat login initiated');
            alert('微信登录功能开发中...');

            // 实际实现示例：
            // window.location.href = '/api/auth/wechat/authorize';
        });
    }
});
```

- [ ] **Step 6: 提交 form.js**

```bash
git add js/form.js
git commit -m "feat: add form validation and submission handling"
```

---

### Task 7: 创建轮播图功能

**Files:**
- Create: `js/carousel.js`

- [ ] **Step 1: 编写 carousel.js 文件**

```javascript
/**
 * 展示区轮播图
 */
class Carousel {
    constructor(containerId, options = {}) {
        this.container = document.getElementById(containerId);
        if (!this.container) return;

        this.slides = this.container.querySelectorAll('.carousel-slide');
        this.indicators = this.container.querySelectorAll('.carousel-indicator');
        this.currentIndex = 0;
        this.autoplayDelay = options.autoplayDelay || 5000;
        this.autoplayTimer = null;

        this.init();
    }

    init() {
        // 绑定指示器点击事件
        this.indicators.forEach((indicator, index) => {
            indicator.addEventListener('click', () => {
                this.goToSlide(index);
            });
        });

        // 开始自动播放
        this.startAutoplay();

        // 鼠标悬停时暂停
        this.container.addEventListener('mouseenter', () => {
            this.stopAutoplay();
        });

        this.container.addEventListener('mouseleave', () => {
            this.startAutoplay();
        });
    }

    goToSlide(index) {
        // 移除当前活动状态
        this.slides[this.currentIndex].classList.remove('active');
        this.indicators[this.currentIndex].classList.remove('active');

        // 更新索引
        this.currentIndex = index;

        // 添加新的活动状态
        this.slides[this.currentIndex].classList.add('active');
        this.indicators[this.currentIndex].classList.add('active');
    }

    nextSlide() {
        const nextIndex = (this.currentIndex + 1) % this.slides.length;
        this.goToSlide(nextIndex);
    }

    startAutoplay() {
        this.autoplayTimer = setInterval(() => {
            this.nextSlide();
        }, this.autoplayDelay);
    }

    stopAutoplay() {
        if (this.autoplayTimer) {
            clearInterval(this.autoplayTimer);
            this.autoplayTimer = null;
        }
    }
}

// 初始化
document.addEventListener('DOMContentLoaded', () => {
    new Carousel('carousel', {
        autoplayDelay: 5000
    });
});
```

- [ ] **Step 2: 提交 carousel.js**

```bash
git add js/carousel.js
git commit -m "feat: add carousel functionality"
```

---

### Task 8: 创建 Logo SVG 图标

**Files:**
- Create: `assets/images/logo.svg`

- [ ] **Step 1: 创建 Logo SVG 文件**

```svg
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
    <defs>
        <linearGradient id="logoGradient" x1="0%" y1="0%" x2="100%" y2="100%">
            <stop offset="0%" style="stop-color:#00f0ff;stop-opacity:1" />
            <stop offset="100%" style="stop-color:#7b2dff;stop-opacity:1" />
        </linearGradient>
    </defs>

    <!-- 外圈 -->
    <circle cx="32" cy="32" r="28" fill="none" stroke="url(#logoGradient)" stroke-width="2" opacity="0.5"/>

    <!-- 内圈 -->
    <circle cx="32" cy="32" r="20" fill="none" stroke="url(#logoGradient)" stroke-width="2"/>

    <!-- 中心六边形 -->
    <polygon points="32,12 44,20 44,36 32,44 20,36 20,20" fill="none" stroke="url(#logoGradient)" stroke-width="2.5"/>

    <!-- 中心点 -->
    <circle cx="32" cy="28" r="4" fill="url(#logoGradient)"/>

    <!-- 装饰点 -->
    <circle cx="32" cy="8" r="2" fill="#00f0ff" opacity="0.8"/>
    <circle cx="48" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
    <circle cx="48" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
    <circle cx="32" cy="48" r="2" fill="#7b2dff" opacity="0.8"/>
    <circle cx="16" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
    <circle cx="16" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
</svg>
```

- [ ] **Step 2: 提交 logo.svg**

```bash
git add assets/images/logo.svg
git commit -m "feat: add logo SVG"
```

---

### Task 9: 创建微信图标

**Files:**
- Create: `assets/images/wechat.svg`

- [ ] **Step 1: 创建微信 SVG 文件**

```svg
<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
    <path d="M8.5,13.5c-0.8,0-1.5-0.7-1.5-1.5s0.7-1.5,1.5-1.5s1.5,0.7,1.5,1.5S9.3,13.5,8.5,13.5z M13.5,13.5
        c-0.8,0-1.5-0.7-1.5-1.5s0.7-1.5,1.5-1.5s1.5,0.7,1.5,1.5S14.3,13.5,13.5,13.5z M19,7.5c0-3-2.7-5.5-6-5.5S7,4.5,7,7.5
        c0,1.5,0.7,2.9,1.8,3.9L8,13l2.1-0.6C10.8,12.8,11.4,13,12,13c0.3,0,0.7,0,1-0.1c0.5,2.6,2.9,4.6,5.8,4.6c0.6,0,1.2-0.1,1.7-0.3
        L22,18l-0.8-1.4C21.7,15.9,22,15,22,14C22,10.5,20.8,7.5,19,7.5z"/>
</svg>
```

- [ ] **Step 2: 提交 wechat.svg**

```bash
git add assets/images/wechat.svg
git commit -m "feat: add WeChat icon SVG"
```

---

### Task 10: 创建主 HTML 文件

**Files:**
- Create: `index.html`

- [ ] **Step 1: 编写 index.html 文件 - 基础结构**

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录 - 科技感登录页面</title>
    <link rel="stylesheet" href="css/animations.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- 背景容器 -->
    <div class="background-container"></div>
    <canvas id="particles-canvas"></canvas>

    <!-- 主容器 -->
    <div class="main-container">
        <!-- 展示区（桌面版） -->
        <section class="showcase-section">
            <div class="showcase-logo">
                <div class="logo">
                    <!-- 内联 SVG 避免加载延迟 -->
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
                        <defs>
                            <linearGradient id="showcaseLogoGradient" x1="0%" y1="0%" x2="100%" y2="100%">
                                <stop offset="0%" style="stop-color:#00f0ff;stop-opacity:1" />
                                <stop offset="100%" style="stop-color:#7b2dff;stop-opacity:1" />
                            </linearGradient>
                        </defs>
                        <circle cx="32" cy="32" r="28" fill="none" stroke="url(#showcaseLogoGradient)" stroke-width="2" opacity="0.5"/>
                        <circle cx="32" cy="32" r="20" fill="none" stroke="url(#showcaseLogoGradient)" stroke-width="2"/>
                        <polygon points="32,12 44,20 44,36 32,44 20,36 20,20" fill="none" stroke="url(#showcaseLogoGradient)" stroke-width="2.5"/>
                        <circle cx="32" cy="28" r="4" fill="url(#showcaseLogoGradient)"/>
                        <circle cx="32" cy="8" r="2" fill="#00f0ff" opacity="0.8"/>
                        <circle cx="48" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
                        <circle cx="48" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="32" cy="48" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="16" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="16" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
                    </svg>
                </div>
            </div>
            <h1 class="showcase-title">未来已至<br>即刻登录</h1>
            <p class="showcase-subtitle">体验前所未有的科技之旅</p>

            <!-- 轮播图 -->
            <div class="carousel-container" id="carousel">
                <div class="carousel-slide active">
                    <div class="carousel-placeholder">🚀</div>
                </div>
                <div class="carousel-slide">
                    <div class="carousel-placeholder">⚡</div>
                </div>
                <div class="carousel-slide">
                    <div class="carousel-placeholder">🎯</div>
                </div>
                <div class="carousel-indicators">
                    <span class="carousel-indicator active"></span>
                    <span class="carousel-indicator"></span>
                    <span class="carousel-indicator"></span>
                </div>
            </div>

            <!-- 客户评价 -->
            <div class="testimonials">
                <h3 class="testimonials-title">用户评价</h3>
                <div class="testimonial-card">
                    <p class="testimonial-text">"这是我见过最炫酷的登录界面，科技感十足！"</p>
                    <p class="testimonial-author">— 科技爱好者</p>
                </div>
                <div class="testimonial-card">
                    <p class="testimonial-text">"体验非常流畅，视觉效果令人印象深刻。"</p>
                    <p class="testimonial-author">— 产品经理</p>
                </div>
            </div>
        </section>

        <!-- 登录卡片 -->
        <div class="login-card">
            <div class="logo-section">
                <div class="logo">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64">
                        <defs>
                            <linearGradient id="cardLogoGradient" x1="0%" y1="0%" x2="100%" y2="100%">
                                <stop offset="0%" style="stop-color:#00f0ff;stop-opacity:1" />
                                <stop offset="100%" style="stop-color:#7b2dff;stop-opacity:1" />
                            </linearGradient>
                        </defs>
                        <circle cx="32" cy="32" r="28" fill="none" stroke="url(#cardLogoGradient)" stroke-width="2" opacity="0.5"/>
                        <circle cx="32" cy="32" r="20" fill="none" stroke="url(#cardLogoGradient)" stroke-width="2"/>
                        <polygon points="32,12 44,20 44,36 32,44 20,36 20,20" fill="none" stroke="url(#cardLogoGradient)" stroke-width="2.5"/>
                        <circle cx="32" cy="28" r="4" fill="url(#cardLogoGradient)"/>
                        <circle cx="32" cy="8" r="2" fill="#00f0ff" opacity="0.8"/>
                        <circle cx="48" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
                        <circle cx="48" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="32" cy="48" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="16" cy="36" r="2" fill="#7b2dff" opacity="0.8"/>
                        <circle cx="16" cy="20" r="2" fill="#00f0ff" opacity="0.8"/>
                    </svg>
                </div>
                <h2 class="title">欢迎回来</h2>
                <p class="subtitle">登录您的账户</p>
            </div>

            <!-- Tab 切换 -->
            <div class="tab-container">
                <div class="tab-item active" data-form="email-form">邮箱登录</div>
                <div class="tab-item" data-form="sms-form">手机验证码</div>
            </div>

            <!-- 邮箱登录表单 -->
            <form id="email-form" class="form-container active">
                <div class="form-group">
                    <label class="form-label" for="email">邮箱地址</label>
                    <input
                        type="email"
                        id="email"
                        class="form-input"
                        placeholder="your@email.com"
                        data-validate="email"
                        required
                    >
                    <p class="error-message" id="email-error"></p>
                </div>

                <div class="form-group">
                    <label class="form-label" for="password">密码</label>
                    <input
                        type="password"
                        id="password"
                        class="form-input"
                        placeholder="至少8位，包含字母和数字"
                        data-validate="password"
                        required
                    >
                    <p class="error-message" id="password-error"></p>
                </div>

                <div class="form-options">
                    <label class="checkbox-group">
                        <input type="checkbox" id="remember">
                        <span class="checkbox-label">记住我</span>
                    </label>
                    <a href="#" class="forgot-password">忘记密码？</a>
                </div>

                <button type="submit" class="btn btn-primary">登录</button>
            </form>

            <!-- 手机验证码登录表单 -->
            <form id="sms-form" class="form-container">
                <div class="form-group">
                    <label class="form-label" for="phone">手机号</label>
                    <input
                        type="tel"
                        id="phone"
                        class="form-input"
                        placeholder="请输入手机号"
                        data-validate="phone"
                        required
                    >
                    <p class="error-message" id="phone-error"></p>
                </div>

                <div class="form-group">
                    <label class="form-label" for="code">验证码</label>
                    <div class="verification-group">
                        <input
                            type="text"
                            id="code"
                            class="form-input"
                            placeholder="6位数字"
                            data-validate="code"
                            required
                        >
                        <button type="button" id="send-code-btn" class="send-code-btn">发送验证码</button>
                    </div>
                    <p class="error-message" id="code-error"></p>
                </div>

                <button type="submit" class="btn btn-primary">登录</button>
            </form>

            <!-- 分割线 -->
            <div class="divider">
                <span>或使用其他方式</span>
            </div>

            <!-- 社交登录 -->
            <div class="social-login">
                <button class="social-btn wechat-login-btn">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path d="M8.5,13.5c-0.8,0-1.5-0.7-1.5-1.5s0.7-1.5,1.5-1.5s1.5,0.7,1.5,1.5S9.3,13.5,8.5,13.5z M13.5,13.5
                            c-0.8,0-1.5-0.7-1.5-1.5s0.7-1.5,1.5-1.5s1.5,0.7,1.5,1.5S14.3,13.5,13.5,13.5z M19,7.5c0-3-2.7-5.5-6-5.5S7,4.5,7,7.5
                            c0,1.5,0.7,2.9,1.8,3.9L8,13l2.1-0.6C10.8,12.8,11.4,13,12,13c0.3,0,0.7,0,1-0.1c0.5,2.6,2.9,4.6,5.8,4.6c0.6,0,1.2-0.1,1.7-0.3
                            L22,18l-0.8-1.4C21.7,15.9,22,15,22,14C22,10.5,20.8,7.5,19,7.5z"/>
                    </svg>
                    微信登录
                </button>
            </div>

            <!-- 注册链接 -->
            <p class="register-link">
                还没有账户？<a href="#">立即注册</a>
            </p>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="js/particles.js"></script>
    <script src="js/tabs.js"></script>
    <script src="js/form.js"></script>
    <script src="js/carousel.js"></script>
</body>
</html>
```

- [ ] **Step 2: 提交 index.html**

```bash
git add index.html
git commit -m "feat: add main HTML structure"
```

---

### Task 11: 创建 README 文档

**Files:**
- Create: `README.md`

- [ ] **Step 1: 编写 README.md 文件**

```markdown
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
```

- [ ] **Step 2: 提交 README.md**

```bash
git add README.md
git commit -m "docs: add README documentation"
```

---

### Task 12: 最终测试

**Files:**
- Test: 在浏览器中打开 `index.html`

- [ ] **Step 1: 启动本地服务器**

```bash
# 在 login-page 目录下
cd login-page
python -m http.server 8000
```

- [ ] **Step 2: 在浏览器中测试**

打开浏览器访问 `http://localhost:8000`

检查清单：
- [ ] 页面正常加载
- [ ] 粒子背景动画运行正常
- [ ] Tab 切换功能正常
- [ ] 表单验证功能正常
- [ ] 发送验证码倒计时正常
- [ ] 微信登录按钮可点击
- [ ] 轮播图自动播放
- [ ] 响应式布局正常（调整浏览器窗口大小）

- [ ] **Step 3: 提交最终版本**

```bash
git add .
git commit -m "chore: final implementation complete"
```

---

## 实施完成检查清单

完成所有任务后，确认以下内容：

- [ ] 所有文件已创建
- [ ] 粒子背景动画正常运行
- [ ] Tab 切换功能正常
- [ ] 表单验证（邮箱、密码、手机号、验证码）正常工作
- [ ] 发送验证码倒计时功能正常
- [ ] 轮播图自动播放和手动切换正常
- [ ] 响应式设计在各断点正常显示
- [ ] 所有动画效果流畅
- [ ] 浏览器控制台无错误
- [ ] README 文档完整

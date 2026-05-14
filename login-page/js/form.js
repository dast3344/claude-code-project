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

function showError(inputId, message) {
    const input = document.getElementById(inputId);
    const errorElement = document.getElementById(`${inputId}-error`);
    if (input && errorElement) {
        input.classList.add('form-input-error');
        errorElement.textContent = message;
        errorElement.classList.add('show');
    }
}

function clearError(inputId) {
    const input = document.getElementById(inputId);
    const errorElement = document.getElementById(`${inputId}-error`);
    if (input && errorElement) {
        input.classList.remove('form-input-error');
        errorElement.classList.remove('show');
    }
}

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

// 实时验证
document.addEventListener('DOMContentLoaded', () => {
    const inputs = document.querySelectorAll('[data-validate]');
    inputs.forEach(input => {
        input.addEventListener('blur', () => validateField(input.id));
        input.addEventListener('input', () => {
            if (input.classList.contains('form-input-error')) {
                validateField(input.id);
            }
        });
    });

    // 邮箱登录表单
    const emailForm = document.getElementById('email-form');
    if (emailForm) {
        emailForm.addEventListener('submit', async (e) => {
            e.preventDefault();
            if (!validateForm('email-form')) return;

            const submitBtn = emailForm.querySelector('.btn-primary');
            submitBtn.classList.add('btn-loading');
            submitBtn.disabled = true;

            await new Promise(resolve => setTimeout(resolve, 1500));

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
            if (!validateForm('sms-form')) return;

            const submitBtn = smsForm.querySelector('.btn-primary');
            submitBtn.classList.add('btn-loading');
            submitBtn.disabled = true;

            await new Promise(resolve => setTimeout(resolve, 1500));

            console.log('SMS login:', {
                phone: document.getElementById('phone').value,
                code: document.getElementById('code').value
            });

            submitBtn.classList.remove('btn-loading');
            submitBtn.disabled = false;
            alert('登录成功！（演示）');
        });
    }

    // 发送验证码
    const sendCodeBtn = document.getElementById('send-code-btn');
    if (sendCodeBtn) {
        let countdown = 0;
        let timer = null;

        sendCodeBtn.addEventListener('click', async () => {
            const phoneInput = document.getElementById('phone');
            const error = validators.phone(phoneInput.value);
            if (error) {
                showError('phone', error);
                return;
            }
            clearError('phone');

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

            console.log('Send SMS code to:', phoneInput.value);
            alert('验证码已发送！（演示）');
        });
    }

    // 微信登录
    const wechatBtn = document.querySelector('.wechat-login-btn');
    if (wechatBtn) {
        wechatBtn.addEventListener('click', () => {
            console.log('WeChat login initiated');
            alert('微信登录功能开发中...');
        });
    }
});

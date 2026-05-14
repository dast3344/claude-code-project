/**
 * Tab 切换功能
 * 处理邮箱登录和手机验证码登录之间的切换
 */

document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.tab-item');
    const forms = document.querySelectorAll('.form-container');

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            tabs.forEach(t => t.classList.remove('active'));
            forms.forEach(f => f.classList.remove('active'));

            tab.classList.add('active');

            const targetForm = tab.dataset.form;
            document.getElementById(targetForm).classList.add('active');
        });
    });
});

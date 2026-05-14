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
        this.indicators.forEach((indicator, index) => {
            indicator.addEventListener('click', () => {
                this.goToSlide(index);
            });
        });

        this.startAutoplay();

        this.container.addEventListener('mouseenter', () => {
            this.stopAutoplay();
        });

        this.container.addEventListener('mouseleave', () => {
            this.startAutoplay();
        });
    }

    goToSlide(index) {
        this.slides[this.currentIndex].classList.remove('active');
        this.indicators[this.currentIndex].classList.remove('active');

        this.currentIndex = index;

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

document.addEventListener('DOMContentLoaded', () => {
    new Carousel('carousel', {
        autoplayDelay: 5000
    });
});
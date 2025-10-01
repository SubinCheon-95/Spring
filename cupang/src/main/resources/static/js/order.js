/* 주문/결제 - 쿠폰 & 포인트 계산 */
document.addEventListener("DOMContentLoaded", () => {
    const couponCheck = document.getElementById("coupon-check");
    const basePriceEl = document.getElementById("basePrice");
    const orderTotalEl = document.querySelector(".order-total strong");
    const currentPointEl = document.getElementById("currentPoint");
    const usePointEl = document.getElementById("usePoint");

    let basePrice = parseInt(basePriceEl.textContent.replace(/,/g, ""));
    let finalPrice = basePrice;
    let userPoint = 7200;
    let couponDiscount = 0;
    let usedPoint = 0;

    function updateTotal() {
        const summaryBox = document.querySelector(".order-summary ul");
        summaryBox.innerHTML = `
            <li><span>상품금액</span><span><strong>${basePrice.toLocaleString()}</strong>원</span></li>
            <li><span>쿠폰할인</span><span><strong>-${couponDiscount.toLocaleString()}</strong>원</span></li>
            <li><span>포인트사용</span><span><strong>-${usedPoint.toLocaleString()}</strong>원</span></li>
            <li><span>배송비</span><span><strong>+0</strong>원</span></li>
            <li><span>적립 포인트</span><span><strong>${Math.floor(finalPrice * 0.01).toLocaleString()}</strong>원</span></li>
        `;
        orderTotalEl.textContent = finalPrice.toLocaleString();
        currentPointEl.textContent = userPoint.toLocaleString();
    }

    // 쿠폰 체크 이벤트
    couponCheck.addEventListener("change", function() {
        if (this.checked) {
            const discountRate = parseFloat(this.dataset.discount);
            couponDiscount = Math.floor(basePrice * discountRate);
        } else {
            couponDiscount = 0;
        }
        calcFinalPrice();
    });

    // 포인트 사용
    window.applyPoint = function() {
        const input = parseInt(usePointEl.value) || 0;
        if (input >= 5000 && input <= userPoint) {
            usedPoint = input;
            userPoint -= input;
        } else {
            alert("포인트는 5,000점 이상부터 사용 가능합니다.");
            usedPoint = 0;
        }
        calcFinalPrice();
    };

    function calcFinalPrice() {
        finalPrice = basePrice - couponDiscount - usedPoint;
        if (finalPrice < 0) finalPrice = 0;
        updateTotal();
    }

    // 초기 세팅
    updateTotal();
});

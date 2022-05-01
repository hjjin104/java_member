package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    //비즈니스 계산 로직
    public int calcPrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    //출력할 때 보기 쉽게 하기 위해서 생성
    //command+n 누른 뒤, toString 검색
    public String toString() {
        return " Order" +System.lineSeparator()+
                "{memberId: " + memberId + System.lineSeparator() +
                "itemName: " + itemName + System.lineSeparator() +
                "itemPrice: " + itemPrice +System.lineSeparator()+
                "discountPrice: " + discountPrice + "}";
    }
}

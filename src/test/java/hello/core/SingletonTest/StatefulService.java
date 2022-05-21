package hello.core.SingletonTest;

public class StatefulService {

    //상태를 유지하는 필드
    private int price;

    public void order(String name, int price){
        System.out.println("name = "+name+" price = "+price);
        this.price = price; // Problem!
    }

    public int getPrice(){
        return price;
    }
}

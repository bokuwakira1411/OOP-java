package Decorator.Order;

public class BaseOrder implements Order{

    @Override
    public double calculateTotalCost() {
        return price + shippingFee;
    }

    private double price, shippingFee;
    public void setPrice(double amount){
        this.price = amount;
    }
    public void setShippingFee(double amount){
        this.shippingFee = amount;
    }
}

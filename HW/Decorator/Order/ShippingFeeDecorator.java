package Decorator.Order;

public class ShippingFeeDecorator extends OrderDecorator{
    private double shippingFee;
    public ShippingFeeDecorator(Order order, double amount) {
        super(order);
        this.shippingFee = amount;
    }

    @Override
    public double calculateTotalCost() {
        double base = order.calculateTotalCost();
        return base + shippingFee;
    }
}

package Decorator.Order;

public class DiscountDecorator extends OrderDecorator{
    private double discount;
    public DiscountDecorator(Order order, double amount) {
        super(order);
        this.discount = amount;
    }

    @Override
    public double calculateTotalCost() {
        double base = order.calculateTotalCost();
        return base - base * discount;
    }
}

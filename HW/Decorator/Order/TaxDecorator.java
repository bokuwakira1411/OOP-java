package Decorator.Order;

public class TaxDecorator extends OrderDecorator{
    private double tax;
    public TaxDecorator(Order order, double tax){
        super(order);
        this.tax = tax;
    }
    @Override
    public double calculateTotalCost() {
        double base = order.calculateTotalCost();
        return base + tax;
    }
}

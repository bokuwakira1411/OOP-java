package Decorator.Order;

public class Client {
    public static void main(){
        BaseOrder order = new BaseOrder();
        order.setPrice(100.0);
        order.setShippingFee(10.0);
        OrderDecorator decoratedOrder = new ShippingFeeDecorator(order, 5.0);
        decoratedOrder = new TaxDecorator(decoratedOrder, 0.1);
        decoratedOrder = new DiscountDecorator(decoratedOrder, 0.2);
        double totalCost = decoratedOrder.calculateTotalCost();
        System.out.println("Total Cost: " + totalCost);
    }
}

class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment...");
        }
    }
}

public class WithoutOCP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CreditCard");
        processor.processPayment("PayPal");
    }
}

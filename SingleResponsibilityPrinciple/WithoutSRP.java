class Invoice {
    public void calculateTotal() {
        System.out.println("Calculating total...");
    }

    public void printInvoice() {
        System.out.println("Printing invoice...");
    }

    public void saveToDatabase() {
        System.out.println("Saving invoice to database...");
    }
}

public class WithoutSRP {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.calculateTotal();
        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}

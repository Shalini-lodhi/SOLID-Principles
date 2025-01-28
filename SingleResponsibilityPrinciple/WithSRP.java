class Invoice {
    public void calculateTotal() {
        System.out.println("Calculating total...");
    }
}

class InvoicePrinter {
    public void printInvoice() {
        System.out.println("Printing invoice...");
    }
}

class InvoiceRepository {
    public void saveToDatabase() {
        System.out.println("Saving invoice to database...");
    }
}

public class WithSRP {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.calculateTotal();

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice();

        InvoiceRepository repository = new InvoiceRepository();
        repository.saveToDatabase();
    }
}

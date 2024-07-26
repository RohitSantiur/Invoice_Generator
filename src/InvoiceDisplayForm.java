import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class InvoiceDisplayForm extends JFrame {
    private JTable tblInvoice;
    private JLabel lblTotalAmount;

    public InvoiceDisplayForm(ArrayList<Item> items) {
        initComponents(items);
        setLocationRelativeTo(null);
    }

    private void initComponents(ArrayList<Item> items) {
        setTitle("Invoice");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tblInvoice = new JTable();
        tblInvoice.setBounds(20, 20, 450, 250);
        add(tblInvoice);

        lblTotalAmount = new JLabel("Total Payable Amount:");
        lblTotalAmount.setBounds(20, 290, 450, 30);
        add(lblTotalAmount);

        // Set table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Sr. No.");
        model.addColumn("Item Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Total Price");

        double totalAmount = 0;

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            model.addRow(new Object[]{i + 1, item.getName(), item.getQuantity(), item.getPrice(), item.getTotalPrice()});
            totalAmount += item.getTotalPrice();
        }

        tblInvoice.setModel(model);

        lblTotalAmount.setText("Total Payable Amount: " + totalAmount);
    }
}
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InvoiceEntryForm extends JFrame {
    private JTextField txtItemName, txtQuantity, txtPrice;
    private JTextArea txtAreaItems;
    private JButton btnAdd, btnGenerateInvoice;

    // To store the items
    private ArrayList<Item> items = new ArrayList<>();

    public InvoiceEntryForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Invoice Entry");
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(20, 20, 100, 30);
        add(lblItemName);

        txtItemName = new JTextField();
        txtItemName.setBounds(130, 20, 200, 30);
        add(txtItemName);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(20, 70, 100, 30);
        add(lblQuantity);

        txtQuantity = new JTextField();
        txtQuantity.setBounds(130, 70, 200, 30);
        add(txtQuantity);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 120, 100, 30);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(130, 120, 200, 30);
        add(txtPrice);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(50, 170, 100, 30);
        add(btnAdd);

        btnGenerateInvoice = new JButton("Generate Invoice");
        btnGenerateInvoice.setBounds(160, 170, 150, 30);
        add(btnGenerateInvoice);

        txtAreaItems = new JTextArea();
        txtAreaItems.setBounds(20, 210, 350, 130);
        add(txtAreaItems);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        btnGenerateInvoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateInvoice();
            }
        });
    }

    private void addItem() {
        String itemName = txtItemName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());
        double price = Double.parseDouble(txtPrice.getText());

        Item item = new Item(itemName, quantity, price);
        items.add(item);

        txtAreaItems.append(item.toString() + "\n");

        txtItemName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }

    private void generateInvoice() {
        InvoiceDisplayForm displayForm = new InvoiceDisplayForm(items);
        displayForm.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        new InvoiceEntryForm().setVisible(true);
    }
}

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + " - " + quantity + " x " + price;
    }
}

package Pert.Catalin.Lab11.Ex2;

import javax.swing.*;

public class Interface {
    private JTextField NameField;
    private JTextField QtyField;
    private JTextField PriceField;
    private JLabel NewProduct;
    private JLabel Name;
    private JLabel Qty;
    private JLabel Price;
    private JButton AddProductButton;
    private JButton DeleteProductButton;
    private JTextField newQtyField;
    private JButton UpdateQtyButton;
    private JLabel NewQty;
    public JPanel Window;
    private JList ProductList;

    public JTextField getNameField() {
        return NameField;
    }

    public JTextField getQtyField() {
        return QtyField;
    }

    public JTextField getPriceField() {
        return PriceField;
    }

    public JButton getAddProductButton() {
        return AddProductButton;
    }

    public JButton getDeleteProductButton() {
        return DeleteProductButton;
    }

    public JTextField getNewQtyField() {
        return newQtyField;
    }

    public JButton getUpdateQtyButton() {
        return UpdateQtyButton;
    }

    public JList getProductList() {
        return ProductList;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface");
        frame.setContentPane(new Interface().Window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

package Pert.Catalin.Lab11.Ex2;

import javax.swing.*;
import java.util.Vector;

public class Controller {
    private static final Vector<Product> products = new Vector<>(0);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stock Management");
        Interface I1 = new Interface();
        I1.getAddProductButton().addActionListener(e -> {
            String PName = I1.getNameField().getText();
            int PQty = Integer.parseInt(I1.getQtyField().getText());
            double PPrice = Double.parseDouble(I1.getPriceField().getText());

            products.add(new Product(PName, PQty, PPrice));

            I1.getProductList().setListData(products);
        });

        I1.getDeleteProductButton().addActionListener(e -> {
            products.remove(I1.getProductList().getSelectedIndex());

            I1.getProductList().setListData(products);
        });

        I1.getUpdateQtyButton().addActionListener(e -> {
            products.get(I1.getProductList().getSelectedIndex()).setQuantity(Integer.parseInt(I1.getNewQtyField().getText()));

            I1.getProductList().setListData(products);
        });

        frame.setContentPane(I1.Window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

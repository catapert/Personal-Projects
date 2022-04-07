package Pert.Catalin.Lab4.Ex4;

import Pert.Catalin.Lab4.Ex2.Author;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qtyInStock;

    public Book(String name,Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name,Author[] authors, double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int newQtyInStock) {
        this.qtyInStock = newQtyInStock;
    }

    public String toString() {
        return name + " by "+authors.length + " authors";
    }
    public void printAuthors(){
        int i;
        for(i=0; i<authors.length;i++){
            if(authors[i]!=null)
                System.out.println(authors[i].getName());
        }
    }
}
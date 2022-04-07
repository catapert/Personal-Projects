package Pert.Catalin.Lab4.Ex3;

import Pert.Catalin.Lab4.Ex2.Author;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    public Book(String name,Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name,Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
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
        return name + " by " + author.toString();
    }
}

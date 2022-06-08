package model;

public class Product {
    //    public int write;
    private int id;
    private String name;
    private double price;
    private int amount;
    private String describe;

    public Product(int id, String name, int amount, String describe) {
    }

    public Product(int id, String name, double price, int amount, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return
                ANSI_BLUE + "Mã sản phẩm: " + id + " \n " + ANSI_RESET +
                        "Tên sản phẩm: " + name +
                        ", Giá sản phẩm: " + price +
                        ", Số lượng sản phẩm: " + amount +
                        ", Mô tả về sản phẩm: " + describe;
    }

    public String write() {
        return id + "," + name + "," + price + "," + amount + "," + describe;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
}

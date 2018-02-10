public class Product {
    public double price;
    public String type;
    public String name;
    private double tax;

    public Product (double price, String type, String name, double tax){
        this.price = price;
        this.type = type;
        this.name = name;
        this.tax = tax;
    }
}

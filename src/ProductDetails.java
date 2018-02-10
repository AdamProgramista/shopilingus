public class ProductDetails {
    private static int nextId = 0;

    int id;
    public Product product;
    public int quantity;

    public ProductDetails (Product product,int quantity){
        this.id = ProductDetails.nextId++;
        this.product = product;
        this.quantity = quantity;
    }
}

public class Service {
    private static int nextId = 0;

    int id;
    public double price;
    public String name;
    public int durationInMin;
    private double tax;

    public Service(double price, String name, int durationInMin, double tax){
        this.id = Service.nextId++;
        this.price = price;
        this.name = name;
        this.durationInMin = durationInMin;
        this.tax = tax;
    }
}



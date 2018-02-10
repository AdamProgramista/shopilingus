import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shop {
    private static int nextId = 0;

    int id;
    String name;
    int floor;
    int stand;
    List<ProductDetails> productsList;
    List<String> types;
    List<Service> servicesList;
    List<Employee> employeesList;

    public Shop (String name,int floor,int stand,List<String> types){
        this.id = Shop.nextId++;
        this.name = name;
        this.floor = floor;
        this.stand = stand;
        this.productsList = new LinkedList<>();
        this.types = types;
        this.servicesList = new LinkedList<>();
        this.employeesList = new LinkedList<>();
    }
    public Shop(String name, int floor,int stand, String[] strings){
        this(name,floor,stand,Arrays.asList(strings));
    }
    // constructor overloading, create shop with empty list (przeładowanie konstruktora)

    void addProduct(Product product, int quantity){

        for (int i = 0; i<this.productsList.size(); i++){
            if(this.productsList.get(i).product.equals(product)){
                this.productsList.get(i).quantity += quantity;
                return;
            }
        }
        this.productsList.add(new ProductDetails(product, quantity));
        return;
    }

    public ProductDetails getProduct(int productId) {
        return productsList.stream()
                .filter(productDetails -> productDetails.id == productId)
                .findFirst()
                .orElse(null);
    }

    void deleteProduct(int productId){
        productsList.remove(getProduct(productId));
    }

    void updateProduct(int productId, ProductDetails modifiedProduct, int quantity){
        deleteProduct(productId);
        modifiedProduct.id = productId;
        addProduct(modifiedProduct.product, quantity);
    }

    void addService (Service newService){
        boolean added = false;
        for(int i = 0; i<this.servicesList.size(); i++){
            if(this.servicesList.get(i).equals(newService)){
                added = true;
            }
        }
        if (!added){
            this.servicesList.add(newService);
        }
    }

    public Service getService(int serviceId) {
        return servicesList.stream()
                .filter(service -> service.id == serviceId)
                .findFirst()
                .orElse(null);
    }

    void deleteService(int serviceId){
        servicesList.remove(getService(serviceId));
    }

    void updateService(int serviceId, Service modifiedService){
        deleteService(serviceId);
        modifiedService.id = serviceId;
        addService(modifiedService);
    }



    void printAllProducts(){
        for (int i = 0; i<this.productsList.size(); i++){
            ProductDetails current;
            current = productsList.get(i);
            System.out.println("name " + current.product.name + " price " + current.product.price + " quantity " + current.quantity);
       }
    }

    void printAllServices(){
        for (int i = 0; i<this.servicesList.size(); i++){
            Service current;
            current = servicesList.get(i);
            System.out.println("name " + current.name + " price " + current.price + " quantity " + current.durationInMin);
        }
    }

    void printAllEmployees(){
        for (int i = 0; i<this.employeesList.size(); i++){
            Employee current;
            current = employeesList.get(i);
            String temp = Arrays.toString(current.skills);
            System.out.println("name " + current.name + " skills " + temp + " isAvaliable " + current.isAvailable);
        }
    }

    void hire(List<Employee>candidates){
        for (int i=0; i<candidates.size(); i++){
            Employee current = candidates.get(i);
            this.employeesList.add(current);
        }
    }

    void hire(Employee candidate) {
        this.employeesList.add(candidate);
    }

    void dismiss(int employeeId) {
        this.employeesList.remove(getEmployee(employeeId));
    }

    public Employee getEmployee(int employeeId) {
        return employeesList.stream()
                .filter(service -> service.id == employeeId)
                .findFirst()
                .orElse(null);
    }

    void updateEmployee(int employeeId, Employee modifiedEmployee){
        dismiss(employeeId);
        modifiedEmployee.id = employeeId;
        hire(modifiedEmployee);
    }


    public int getNumberOfEmployees(){
        int numberOfEmployees = this.employeesList.size();
        return numberOfEmployees;
    }

}

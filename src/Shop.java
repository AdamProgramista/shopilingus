import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shop {
    String name;
    String address;
    List<ProductDetails> productsList;
    String type;
    List<Service> servicesList;
    List<Employee> employeesList;

    public Shop (String name,String address,String type){
        this.name = name;
        this.address = address;
        this.productsList = new LinkedList<>();
        this.type = type;
        this.servicesList = new LinkedList<>();
        this.employeesList = new LinkedList<>();
    }

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

    void hire(Employee candidate) {
        this.employeesList.add(candidate);
    }

    void dismiss(Employee candidate) {
        this.employeesList.remove(candidate);
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ShoppingCenter galeriaRz = new ShoppingCenter("Galeria Rzeszowska", "Rzeszów");

        Shop carrefour = new Shop("Carrefour", 2,3, new String[]{"food"});
        Shop newyorker = new Shop("NewYorker", 1,1, new String[]{"clothes"});
        Shop laundry = new Shop("Perfekt", 1,2,new String[]{"service"});
        Shop beauty = new Shop("Twoj Styl",2,1,new String[]{"beauty","hairdressing"});
        Shop carrefour2 = new Shop("Carrefour", 2,4, new String[]{"food"});
        galeriaRz.updateShop(0, carrefour2);


        galeriaRz.addShop(carrefour);
        galeriaRz.addShop(newyorker);
        galeriaRz.addShop(laundry);
        galeriaRz.addShop(beauty);
        List<Shop> newyorkers = galeriaRz.findShopsByName("NewYorker");

//        galeriaRz.deleteShop(1);

        galeriaRz.printAllShops();

        Product bananasCF = new Product(1,"food","banana",23);
        Product applesCF = new Product(0.3,"food","apple",23);
        Product blackPantiesSNY = new Product(15,"clothes", "black panties S", 23);
        Product blackPantiesMNY = new Product(15,"clothes", "black panties M", 23);
        Product blackPantiesLNY = new Product(15,"clothes", "black panties L", 23);
        Service suit = new Service(25,"washing the suit", 60, 23);
        Service panties = new Service(5,"washing panties", 10, 23);
        Service mensHaircut = new Service(20,"Men's haircut",30, 8);
        Service womensHaircut = new Service(40,"Women's haircut",60, 8);
        Service pedicure = new Service(30,"Pedicure", 75, 23);
        Service manicure = new Service(40,"Manicure", 90,23);

        carrefour.addProduct(bananasCF,100);
        carrefour.addProduct(bananasCF,20);
        carrefour.addProduct(applesCF,20);
        newyorker.addProduct(blackPantiesSNY,3);
        newyorker.addProduct(blackPantiesMNY,3);
        newyorker.addProduct(blackPantiesLNY,2);
        laundry.addService(suit);
        laundry.addService(panties);
        beauty.addService(mensHaircut);
        beauty.addService(womensHaircut);
        beauty.addService(pedicure);
        beauty.addService(manicure);

        List<Product> listWithProducts = galeriaRz.getAllProducts();
        List<Service> listWithServices = galeriaRz.getAllServices();
        List<String> listWithTypes = galeriaRz.getAllShopTypes();
        Set<String> listWithTypes2 = galeriaRz.getAllShopTypes2();
        List<String> listWithProductTypes = galeriaRz.getAllProductTypes();
        Set<String> listWithProductTypes2 = galeriaRz.getAllProductTypes2();

        Employee adam = new Employee("Adam",new String[]{"laundry service"});
        Employee alek = new Employee("Alek",new String[]{"laundry service"});
        Employee monika = new Employee("Monika",new String[]{"hairdresser","beautician"});
        Employee ewelina = new Employee("Ewelina",new String[]{"hairdresser"});
        Employee joanna = new Employee("Joanna",new String[]{"beautician"});
        List<Employee> beautyEmployees = Arrays.asList(monika,ewelina,joanna);
        laundry.hire(adam);
        laundry.hire(alek);
        laundry.dismiss(2);
        beauty.hire(beautyEmployees);
        //        beauty.hire(ewelina);
//        beauty.hire(joanna);


//        carrefour.printAllProducts();
//        newyorker.printAllProducts();
//        laundry.printAllServices();
//        laundry.printAllEmployees();
        beauty.printAllEmployees();
        beauty.getNumberOfEmployees();

    }
}

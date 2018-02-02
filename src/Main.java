public class Main {
    public static void main(String[] args) {
        Shop carrefour = new Shop("Carrefour","floor 2 stand 1","food");
        Shop newyorker = new Shop("NewYorker","floor 1 stand 1","clothes");
        Shop laundry = new Shop("Perfekt","floor 1 stand 2","service");
        Shop beauty = new Shop("Twoj Styl","floor 2 stand 1","beauty");
        Product bananasCF = new Product(1,"food","banana",23);
        Product applesCF = new Product(0.3,"food","apple",23);
        Product blackPantiesSNY = new Product(15,"clothes", "black panties S", 23);
        Product blackPantiesMNY = new Product(15,"clothes", "black panties M", 23);
        Product blackPantiesLNY = new Product(15,"clothes", "black panties L", 23);
        Service suit = new Service(25,"washing the suit", 60);
        Service panties = new Service(5,"washing panties", 10);
        Service mensHaircut = new Service(20,"Men's haircut",30);
        Service womensHaircut = new Service(40,"Women's haircut",60);
        Service pedicure = new Service(30,"Pedicure", 75);
        Service manicure = new Service(40,"Manicure", 90);

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

        Employee adam = new Employee("Adam",new String[]{"laundry service"});
        Employee alek = new Employee("Alek",new String[]{"laundry service"});
        Employee monika = new Employee("Monika",new String[]{"hairdresser","beautician"});
        Employee ewelina = new Employee("Ewelina",new String[]{"hairdresser"});
        Employee joanna = new Employee("Joanna",new String[]{"beautician"});
        laundry.hire(adam);
        laundry.hire(alek);
        laundry.dismiss(alek);

//        carrefour.printAllProducts();
//        newyorker.printAllProducts();
//        laundry.printAllServices();
        laundry.printAllEmployees();

    }
}

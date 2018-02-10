import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCenter {
    String name;
    String address;
    List<Shop> shopList;

    public ShoppingCenter(String name, String address) {
        this.name = name;
        this.address = address;
        this.shopList = new LinkedList<>();
    }

    void addShop(Shop newShop) {
        this.shopList.add(newShop);
    }

    public Shop getShop(int shopId) {
        return shopList.stream()
                .filter(shop -> shop.id == shopId)
                .findFirst()
                .orElse(null);
    }

    void deleteShop(int shopId) {
        shopList.remove(getShop(shopId));
    }

    void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.id = shopId;
        addShop(modifiedShop);

    }

    public List<Shop> findShopsByName(String name) {
        return shopList.stream()
                .filter(shop -> shop.name.equals(name))
                .collect(Collectors.toList());
    }

    void printAllShops(){
        for (int i = 0; i<this.shopList.size(); i++){
            Shop current;
            current = shopList.get(i);
            System.out.println(current.name);
        }
    }


    public List<Product> getAllProducts(){
        List allProducts = new LinkedList();
        for (int i = 0; i<this.shopList.size(); i++){
            Shop current = shopList.get(i);
            for (int j = 0; j<current.productsList.size(); j++){
                ProductDetails currentProduct = current.productsList.get(j);
                allProducts.add(currentProduct.product);
            }
        }
        return allProducts;
    }

    public List<Service> getAllServices(){
        List allServices = new LinkedList();
        for (int i = 0; i<this.shopList.size(); i++){
            Shop current = shopList.get(i);
            for (int j = 0; j<current.servicesList.size(); j++){
                Service currentService = current.servicesList.get(j);
                allServices.add(currentService);
            }
        }
        return allServices;
    }

    public List<String> getAllShopTypes(){
        List allTypes = new LinkedList();
        for (int i = 0; i<this.shopList.size(); i++){
            Shop current = shopList.get(i);
            for (int j = 0; j<current.types.size(); j++){
                String currentType = current.types.get(j);
                allTypes.add(currentType);
            }
        }
        return allTypes;
    }

    public Set<String> getAllShopTypes2() {
        return this.shopList.stream()
                .flatMap(shop -> shop.types.stream())
                .collect(Collectors.toSet());
    }

    public List<String> getAllProductTypes() {
        List allProductTypes = new LinkedList();
        for (int i = 0; i < this.shopList.size(); i++) {
            Shop current = shopList.get(i);
            for (int j = 0; j < current.productsList.size(); j++) {
                ProductDetails currentProduct = current.productsList.get(j);
                allProductTypes.add(currentProduct.product.type);
            }
        }
        return  allProductTypes;
    }

    public Set<String> getAllProductTypes2() {
        return getAllProducts().stream()
                .map(product -> product.type)
                .collect(Collectors.toSet());
    }
}


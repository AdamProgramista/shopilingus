import java.util.LinkedList;
import java.util.List;
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

    void deleteShop(int shopId) {
        for (int i = 0; i < shopList.size(); i++) {
            if (shopList.get(i).id == shopId) {
                shopList.remove(shopList.get(i));
            }
        }
    }

    void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.id = shopId;
        addShop(modifiedShop);

    }

    public List<Shop> findShopsByName(String name) {
        return shopList.stream()
                .filter(shop -> shop.name.equals(name))
                .collect(Collectors.toList())
    }

}


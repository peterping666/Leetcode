package OOD;

import java.util.List;
import java.util.Map;

public class Restaurant {
    List<Table> tables;
    List<item> menu;
    Map<Table, Order> tableToOrder;

    public Table findTable() {
        for(Table t : tables) {
            if(t.isAvailable()) {
                return t;
            }
        }
        return null;
    }
    void takeOrder(Table t, Order o) {
        tableToOrder.put(t, o);
        t.occupy();
    }
    void checkout(Table t, Order o) {
        float price = o.getPrice();
        t.unoccupy();
        tableToOrder.remove(t);
    }
}

class Table {
    boolean available;

    boolean isAvailable() {
        return available;
    }
    void occupy() {
        available = false;
    }

    void unoccupy() {
        available = true;
    }
}

class Order {
    List<item> items;
    Table t;
    float price;

    float getPrice() {
        for(item item : items) {
            price += item.getPrice();
        }
        return price;
    }
}

class item {
    private float price;

    float getPrice() {
        return price;
    }
}

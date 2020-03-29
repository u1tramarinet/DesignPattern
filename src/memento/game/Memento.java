package memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {
    private static final long serialVersionUID = 1L;
    int money;
    ArrayList<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    @SuppressWarnings("unchecked")
    List<String> getFruits() {
        return (List<String>) fruits.clone();
    }

    @Override
    public String toString() {
        return "Memento{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }
}

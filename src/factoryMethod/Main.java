package factoryMethod;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;
import factoryMethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("owner1");
        Product card2 = factory.create("owner2");
        Product card3 = factory.create("owner3");
        card1.use();
        card2.use();
        card3.use();
    }
}

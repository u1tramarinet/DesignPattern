package prototype;

import prototype.framework.Product;

public class UnderlinePen extends Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int lenght = s.getBytes().length;

        System.out.println("\"" + s + "\"");

        System.out.print(" ");
        for (int i = 0; i < lenght; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }
}

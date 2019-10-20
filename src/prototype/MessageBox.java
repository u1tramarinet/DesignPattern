package prototype;

import prototype.framework.*;

public class MessageBox extends Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;

        printLine(length);
        System.out.println(decochar + " " + s + " " + decochar);
        printLine(length);
    }

    private void printLine(int contentLength) {
        for (int i = 0; i < contentLength + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }
}

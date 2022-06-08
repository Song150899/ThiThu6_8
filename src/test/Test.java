package test;

import controller.ManagerProduct;

public class Test {
    public static void main(String[] args) {
        ManagerProduct managerProduct = new ManagerProduct();

        while (true) {
            managerProduct.menu();
        }
    }
}

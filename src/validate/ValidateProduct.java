package validate;

import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateProduct {
    Scanner scanner = new Scanner(System.in);
//    ArrayList<Product> products = new ArrayList<>();

    public int getIndexId(int id, ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int ValidateId(ArrayList<Product> products) {

        while (true) {

            try {

                System.out.println("Nhập mã sản phẩm");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id, products) != -1) {
                    throw new Exception();
                }

                return id;

            } catch (Exception e) {
                System.err.println("Nhập lại ID");


            }
        }
    }

    public String validateString(String name) {

        while (true) {

            System.out.println("Nhập " + name);
            String str = scanner.nextLine();

            if (str.equals("")) {
                System.err.println("Không được để trống nha!");
                continue;

            } else {
                return str;
            }
        }
    }

    public double validatePrice() {

        while (true) {

            try {

                System.out.println("Nhập giá sản phẩm:");
                double price = Double.parseDouble(scanner.nextLine());
                return price;

            } catch (Exception e) {
                System.out.println("Nhập lại giá sản phẩm");
            }
        }
    }

    public int validateAmount() {

        while (true) {

            try {
                System.out.println("Nhập số lượng sản phẩm");
                int amount = Integer.parseInt(scanner.nextLine());
                return amount;

            } catch (Exception e) {
                System.err.println("Nhập lại số lượng sản phẩm");
            }
        }
    }
}

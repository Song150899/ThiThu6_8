package controller;

import file.ReaderAndWriter;
import model.Product;
import sort.SortDown;
import sort.SortUp;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct extends ValidateProduct {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();

    public void menu() {
        while (true) {
            System.out.println(ANSI_BLUE + "---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----" + ANSI_RESET);
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println(ANSI_BLUE + "Chọn chức năng" + ANSI_RESET);

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1: // Xem danh sách
                        show();
                        break;

                    case 2: // Thêm mới
                        addProduct(creatProduct());
                        break;

                    case 3: // Cập nhât
                        editProduct();
                        break;

                    case 4: // Xóa
                        delete();
                        break;

                    case 5: // Sắp xếp
                        sort();
                        break;

                    case 6: //Tìm sp đắt nhất
                        findMaxProduct(products);
                        break;

                    case 7:// Đọc file
                        products = readerAndWriter.reader();
                        System.out.println(ANSI_BLUE + "đọc thành công" + ANSI_RESET);
                        break;

                    case 8: // Ghi file
                        readerAndWriter.write(products);
                        System.out.println(ANSI_BLUE + "Ghi file thành công" + ANSI_RESET);
                        break;

                    case 9:// Thoát
                        System.exit(0);
                        break;
                    default:
                        throw new NumberFormatException("");
                }
            } catch (NumberFormatException e) {
                System.err.printf("Nhập chức năng từ 1 đến 9 để chọ lựa");
            }
        }
    }

    public void show() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public Product creatProduct() {
        int id = validateProduct.ValidateId(products);
        String name = validateProduct.validateString("Tên sản phẩm: ");
        double price = validateProduct.validatePrice();
        int amount = validateProduct.validateAmount();
        String describe = validateProduct.validateString("Mô tả: ");
        return new Product(id, name, price, amount, describe);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct() {

        System.out.println("Nhập mã sản phẩm cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);

        if (index != -1) {

            products.set(index, creatProduct());

        } else {

            System.err.println("Mã sản phẩm bạn nhập không tồn tại");
        }
    }

    public void delete() {

        System.out.println("Nhập mã sản phẩm bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);

        if (index != -1) {

            products.remove(index);

        } else

            System.err.println("Mã sản phẩm bạn nhập không có");
    }

    public void sort() {
//        while (true) {
        System.out.println(ANSI_BLUE + "---- Sắp xếp sản phẩm ----" + ANSI_RESET);
        System.out.println("1. Sắp xếp theo tăng dần");
        System.out.println("2. Sắp xếp theo giảm dần");
        System.out.println("3. Thoát");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            do {


                switch (choice) {
                    case 1: //Sắp xếp tăng dần
                        products.sort(new SortUp());
                        System.out.println(ANSI_BLUE + "Sắp xếp thành công " + ANSI_RESET);
                        break;
                    case 2: // Sắp xếp giảm dần
                        products.sort(new SortDown());
                        System.out.println(ANSI_BLUE + "Sắp xếp thành công" + ANSI_RESET);
                        break;
                    case 3: // thoát về menu
                        menu();
                    default:
                        throw new NumberFormatException();
                }
            } while (choice == 0);

        } catch (NumberFormatException e) {
            System.err.println("Nhập lựa chọn theo chức năng từ 1 đến 3 ");
        }

    }

    public void findMaxProduct(ArrayList<Product> products) {
        double max = products.get(0).getPrice();
        for (int i = 0; i < products.size(); i++) {
            if (max < products.get(i).getPrice()) {
                max = products.get(i).getPrice();
            }
        }
        System.out.println(max);
    }

}






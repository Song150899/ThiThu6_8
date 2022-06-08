package file;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReaderAndWriter {
    File file = new File("Song.csv");

    public void write(ArrayList<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,price,amount,describe");
            bufferedWriter.newLine();

            for (Product p : products) {
                bufferedWriter.write(p.write());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> reader() {

        ArrayList<Product> products = new ArrayList<Product>();

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();

            while ((str = bufferedReader.readLine()) != null) {

                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                double price = Double.parseDouble(arr[2]);
                int amount = Integer.parseInt(arr[3]);
                String describe = arr[4];

                products.add(new Product(id,name,price,amount,describe));
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return products;
    }
}

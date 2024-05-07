package com.company;
import java.util.*;

public class Input_Sample {
    public static void main(String[] args) {
        // Case 1: [1,2,3,4,5]
        ArrayList<Integer> arr1 = inputArrayFormat();
        System.out.println(arr1);

//         Input: [["Apple",10.5,2],["Mango",2.2,4],["Grapes",3.5,4]]
        funApple();

        matrix();
    }

    public static ArrayList<Integer> inputArrayFormat() {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] values = input.substring(1, input.length() - 1).split(",");

        // Convert each value to integer and print
        System.out.println("Elements in the array:");
        for (String value : values) {
            arr.add(Integer.parseInt(value.trim()));
        }
        return arr;
    }

    public static void funApple(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] fruitData = input.substring(2, input.length() - 2).split("\\],\\[");

        System.out.println("Cost of each fruit:");
        System.out.println(Arrays.toString(fruitData));

        // Process each fruit data
        for (String fruitDatum : fruitData) {
            // Split each fruit data by commas
            String[] values = fruitDatum.split(",");

            // Extract fruit name, price, and quantity
            String fruitName = values[0];
            double price = Double.parseDouble(values[1]);
            int quantity = Integer.parseInt(values[2]);

            // Calculate total cost for the fruit
            double totalCost = price * quantity;

            // Print fruit name and total cost
            System.out.println(fruitName + ": $" + totalCost);
        }

//          Output

//        Cost of each fruit:
//        [Apple,10.5,2, Mango,2.2,4, Grape,3.5,4]
//        Apple: $21.0
//        Mango: $8.8
//        Grape: $14.0
    }

    public static void matrix(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] rows = input.substring(2, input.length()-2).split("\\],\\[");

        List<List<Integer>> list = new ArrayList<>();
        for(String row : rows){
            List<Integer> inner = new ArrayList<>();
            String[] values = row.split(",");
            for(String val : values) inner.add(Integer.parseInt(val));
            list.add(inner);
        }

        System.out.println(list);
    }
}

//-----------------------------------------------------
// Title: Main/tester class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: This class contains the main method.
// -----------------------------------------------------
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String operation = "";
        BST bst = new BST();

        while (!operation.equals("6")){
            System.out.println("Enter operation code:");
            operation = scan.next();
            switch(operation) {
                case "1":
                    System.out.println("Enter information:");
                    int a = scan.nextInt();
                    String b = scan.next();
                    String c = scan.next();
                    bst.put(a, b, c);

                    break;
                case "2":
                    System.out.println("Enter ID to be deleted:");
                    int del = scan.nextInt();
                    bst.delete(del);
                    break;
                case "3":
                    System.out.println("Enter ID to be searched:");
                    int search=scan.nextInt();
                    bst.search(search);
                    break;
                case "4":
                    bst.list();
                    break;
                case "5":
                    System.out.println("Enter bounds of range:");
                    int r1 = scan.nextInt();
                    int r2 = scan.nextInt();
                    bst.listWRange(r1,r2);
                    break;
                case "6":
                    System.out.println("Stopped!");
                    System.out.println();
                    break;

                default:
                    System.out.println("Please enter valid operation!");
            }
        }


    }
}
package Package1;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    private String name;
    private Scanner scanner;
    private ShoppingList s1 = new ShoppingList("List 1");

    public Menu(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    public void launchMenu() {
        boolean exit = false;
        printOptions();
        while (!exit) {
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    printOptions();
                    break;
                case 2:
                    unitConverter();
                    printOptions();
                    break;

                case 3:
                    palindrome();
                    printOptions();
                    break;
                case 4:
                    BinDecConverter();
                    printOptions();
                    break;
                case 5:
                    randomizeNumber();
                    printOptions();
                    break;
                case 6:
                    shoppingList();
                    printOptions();
                    break;
                case 7:
                    System.out.println("\n Shuting down "+ getName());
                    exit = true;
                    break;


            }
        }
    }

    private void printOptions() {
        System.out.println("Choose the option: \n" +
                "1.Show options\n" +
                "2.Unit Converter\n" +
                "3.Palindrome\n" +
                "4.Bin to Dec converter\n" +
                "5.Randomize number\n" +
                "6.Shopping list \n" +
                "7.Exit");
    }

    private void unitConverter() {
        boolean exitUnitConv = false;
        while (!exitUnitConv) {
            System.out.println("Choose unit: \n" +
                    "1. weight \n" +
                    "2. lenght \n" +
                    "3. time \n" +
                    "4. Exit");
            int unitOption = scanner.nextInt();
            scanner.nextLine();

            switch (unitOption) {
                case 1:
                    System.out.println("enter weight in kg");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(weight + "kg (kilograms) = \n" + (weight * 2.20462262d) + " lb (pounds)\n" +
                            "" + (weight * 35.2739619d) + " oz (ounces)\n" +
                            "" + (weight * 0.001d) + " t (tons)");
                    break;
                case 2:
                    System.out.println("enter length in m (metres)");
                    double length = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(length + "m (metres) = \n" + (length * 0.337d) + " ft (feets)\n" +
                            "" + (length * 1.09d) + " yd (yards)\n" +
                            "" + (length * 39.37d) + " in (inches)");
                    break;
                case 3:
                    System.out.println("enter time in minutes)");
                    int time = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(time + "m (minutes) = \n" + (time * 60) + "s (seconds)\n" +
                            "" + (time / 60) + "h (hours)\n" +
                            "" + ((time /60) / 24 ) + " days");
                    break;
                case 4:
                    System.out.println("Exiting unit converter ...");
                    exitUnitConv = true;
                    break;

            }
        }
    }

    private void palindrome(){
        System.out.println("Enter word to reverse");
        String word = scanner.nextLine();
        char[] c = word.toCharArray();
        int lastChar =c.length -1;
        for(int i=0; i<c.length /2; i++){
            char temp = c[i];
            c[i]=c[lastChar - i];
            c[lastChar - i] = temp;
        }
        String newWord = new String(c);

        if(newWord.equals(word)){
            System.out.println("The word is a palindrome");
        }else{
            System.out.println("The word is not a palindrome, reverse of word is: "+ newWord);
        }
        System.out.println("Back to main menu...");
    }

    private void BinDecConverter(){
        System.out.println("Enter binary number: ");
        String bin = scanner.nextLine();
        char[] c = bin.toCharArray();
        int basis = 1;
        int sum =0;
        for(int i=c.length-1; i>=0; i--){
            sum += (c[i]-48)*basis;
            basis *=2;
        }
        System.out.println("Binary number: " +bin+" = "+ sum+ " in Decimal");
    }

    private void randomizeNumber(){
        System.out.println("Enter beginning of range: ");
        int start = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter end of range: ");
        int end = scanner.nextInt();
        scanner.nextLine();
        if (start >= end) {
            throw new IllegalArgumentException("end must be greater than beginning");
        }
        System.out.print("Random number is: ");
        System.out.println((int)(Math.random() * ((end - start) + 1)) + start);
    }

    private void shoppingList(){
        boolean exitShoppingList = false;
        while (!exitShoppingList) {
            System.out.println("Choose action: \n" +
                    "1. Add item to list \n" +
                    "2. Print items from list \n" +
                    "3. Update item on list \n" +
                    "4. Delete item from list \n" +
                    "5. Exit");
            int listOption = scanner.nextInt();
            scanner.nextLine();

            switch (listOption) {
                case 1:
                    s1.addNewItem();
                    break;
                case 2:
                    s1.printItems();
                    break;
                case 3:
                    s1.updateItem();
                    break;
                case 4:
                    s1.deleteItem();
                    break;
                case 5:
                    System.out.println("Exiting shopping list ...");
                    exitShoppingList = true;
                    break;

            }
        }
    }


    public String getName() {
        return name;
    }
}

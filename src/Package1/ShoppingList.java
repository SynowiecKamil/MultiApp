package Package1;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    private String name;
    private ArrayList<Item> items;

    private Scanner scanner;

    public ShoppingList(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
        this.scanner = new Scanner(System.in);
    }

    public void printItems(){
        System.out.println("YOu have "+ items.size() + " items in your Shopping list: " + getName());
        for(int i=0; i<this.items.size(); i++){
            System.out.println((i+1)+". "+ this.items.get(i).getName()+ " : "+ this.items.get(i).getPrice());
        }
    }

    public void addNewItem(){
        System.out.println("Enter item name:");
        String name = scanner.nextLine();
        System.out.println("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Item newItem = Item.createItem(name, price);
        items.add(newItem);
        System.out.println("Item added...");
    }

    public void updateItem() {
        System.out.println("Enter item name to update:");
        String name = scanner.nextLine();
        Item existingItem = queryItem(name);
        if(existingItem == null){
            System.out.println("Item not found");
            return;
    }

        System.out.println("Enter new item name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Item newItem = Item.createItem(newName, price);
        int position = items.indexOf(existingItem);
        if(position >=0){
            this.items.set(position, newItem);
            System.out.println(existingItem.getName()+" updated to: "+ newItem.getName());
        }else{
            System.out.println("Item not found");
        }
    }

    public void deleteItem(){
        System.out.println("Enter item name to delete:");
        String name = scanner.nextLine();
        Item existingItem = queryItem(name);
        if(existingItem == null){
            System.out.println("Item not found");
            return;
        }
        int position = findItem(existingItem);
        if(position>=0){
            System.out.println(existingItem.getName()+" deleted");
            this.items.remove(position);
        }else{
            System.out.println("Item not deleted");
        }

    }

    private Item queryItem(String name){
        int position = findItem(name);
        if(position >= 0 ){
            return this.items.get(position);
        }
        return null;
    }

    public int findItem(Item searchItem){
        return items.indexOf(searchItem);
    }
    public int findItem(String itemName){
        for(int i=0; i<this.items.size(); i++){
            Item item = this.items.get(i);
            if(item.getName().equals(itemName)){
                return i;
            }
        }
        return -1;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

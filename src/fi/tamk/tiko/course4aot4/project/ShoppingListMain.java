package fi.tamk.tiko.course4aot4.project;

import fi.tamk.tiko.course4aot4.util.MyArrayList;
import fi.tamk.tiko.course4aot4.util.MyLinkedList;

import java.util.Scanner;

/**
 * Created by Eetu Kallio on 20.11.2016
 *
 * @author Eetu Kallio
 * @version 1.0
 */

public class ShoppingListMain {

    public static void main(String[] args){

        System.out.println("SHOPPING LIST\r\n" +
                "Tampere University of Applied Sciences\r\n");

        run();

    }

    private static void run(){

        boolean RUN = true;
        MyLinkedList<ShoppingListItem> shoppingList = new MyLinkedList<>();
        String items = "";
        Scanner scan = new Scanner(System.in);

        while (RUN){

            MyArrayList<String> itemList = new MyArrayList<>();


            System.out.println("Give shopping list (example: 1 milk;2 tomato;3 carrot;)");

            if (scan.hasNextLine()){
                items = scan.nextLine();
            }


            if (items.equals("exit")){
                RUN = false;
            }else {

                for (int i = 0; i < items.split(";").length; i++) {
                    itemList.add(items.split(";")[i]);
                }


                for (int i = 0; i < itemList.size(); i++) {

                    String[] item = itemList.get(i).split(" ");
                    String itemName = item[1];
                    int itemAmount = Integer.parseInt(item[0]);
                    boolean exixsts = false;

                    for (int j = 0; j < shoppingList.size(); j++) {
                        if (shoppingList.get(j).getItemName().equals(itemName)){
                            shoppingList.get(j).setItemAmount(shoppingList.get(j).getItemAmount()+itemAmount);
                            exixsts = true;
                        }
                    }

                    if (!exixsts){
                        ShoppingListItem addedItem = new ShoppingListItem(itemAmount, itemName);
                        shoppingList.add(addedItem);
                    }



                }

                System.out.println("Your Shopping List Now:");

                for (int i = 0; i < shoppingList.size(); i++) {
                    System.out.print(shoppingList.get(i).getItemAmount() + " " + shoppingList.get(i).getItemName() +"\r\n");
                }

                System.out.println();

            }



        }

    }



}

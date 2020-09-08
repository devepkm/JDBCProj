package com.devepkm.utils;


import java.util.Scanner;

public class KeyboardUtils {

    static Scanner sc = new Scanner(System.in);

    public static int readOption() {


        int parseInt = 0;
        System.out.print("Option: ");
        while (sc.hasNext()) {
            String s = sc.next();
            try {
                parseInt = Integer.parseInt(s);
                if (parseInt <= 4 && parseInt > 0) {
                    break;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Invalid Input!");
            System.out.print("Option: ");
        }



        return parseInt;


    }


    public static int selectUser() {


        int i = 0;
        while (true) {
            i = readOption();
            if (i <= 3){
                break;
            }
            System.out.println("Invalid Input!");
        }
        return i;
    }


    public static String readString(){
        String next = sc.next();
        return next;

    }
}

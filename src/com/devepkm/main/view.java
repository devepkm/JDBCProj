package com.devepkm.main;

import com.devepkm.utils.JDBCUtils;
import com.devepkm.utils.KeyboardUtils;

import java.sql.Connection;

public class view {

    static Connection conn = JDBCUtils.getConnection();


    public static void main(String[] args) {
        run();

    }

    private static void run() {

        while (true){
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");
            

        }

    }

}

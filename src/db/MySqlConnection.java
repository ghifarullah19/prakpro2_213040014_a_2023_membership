/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ghifarullah19
 */

// MySqlConnection adalah class yang bertugas untuk menghubungkan aplikasi dengan database
public class MySqlConnection {
    // DB_URL adalah alamat database yang akan dihubungkan
    private final static String DB_URL = "jdbc:mysql://localhost:3306/pp2_membership";
    // DB_USER adalah username database
    private final static String DB_USER = "root";
    // DB_PASS adalah password database
    private final static String DB_PASS = "";
    
    // instance adalah variabel yang digunakan untuk menyimpan instance dari MySqlConnection
    private static MySqlConnection instance;
    
    // getInstance adalah method yang digunakan untuk mengambil instance dari MySqlConnection
    public static MySqlConnection getInstance() {
        // jika instance bernilai null, maka akan dibuat instance baru
        if (instance == null) {
            instance = new MySqlConnection();
        }
        // mengembalikan instance
        return instance;
    }
    
    // getConnection adalah method yang digunakan untuk mengambil koneksi dari database
    public Connection getConnection() {
        // connection adalah variabel yang digunakan untuk menyimpan koneksi dari database
        Connection connection = null;

        // try catch digunakan untuk menangkap error yang terjadi
        try {
            // Class.forName digunakan untuk memuat class yang akan digunakan
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.getConnection digunakan untuk mengambil koneksi dari database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan koneksi
        return connection;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import jenis_member.JenisMember;

/**
 *
 * @author ghifarullah19
 */

// JenisMemberDao adalah class yang digunakan untuk mengakses data jenis member dari database
public class JenisMemberDao {
    // insert digunakan untuk menyimpan data jenis member ke database
    public int insert(JenisMember jenisMember) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("Insert into jenis_member(id, nama) values (?, ?)");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter jenisMember
            statement.setString(1, jenisMember.getId());
            statement.setString(2, jenisMember.getNama());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // update digunakan untuk mengubah data jenis member di database
    public int update(JenisMember jenisMember) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("update jenis_member set nama = ? where id = ?");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter jenisMember
            statement.setString(1, jenisMember.getNama());
            statement.setString(2, jenisMember.getId());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // delete digunakan untuk menghapus data jenis member di database
    public int delete(JenisMember jenisMember) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("delete from jenis_member where id = ?");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter jenisMember
            statement.setString(1, jenisMember.getId());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // findAll digunakan untuk mengambil semua data jenis member di database
    public List<JenisMember> findAll() {
        // list adalah variabel yang digunakan untuk menyimpan semua data jenis member
        List<JenisMember> list = new ArrayList<>();

        // try with resources digunakan untuk mengambil koneksi dari database dan membuat statement untuk mengeksekusi query
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {

            // ResultSet digunakan untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from jenis_member");) {
                
                // while digunakan untuk mengambil semua data jenis member dari ResultSet
                while(resultSet.next()) {
                    // Instansiasi JenisMember dengan nama jenisMember
                    JenisMember jenisMember = new JenisMember();

                    // jenisMember.setId digunakan untuk mengubah nilai dari variabel id dengan nilai dari ResultSet berdasarkan kolom id
                    jenisMember.setId(resultSet.getString("id"));
                    // jenisMember.setNama digunakan untuk mengubah nilai dari variabel nama dengan nilai dari ResultSet berdasarkan kolom nama
                    jenisMember.setNama(resultSet.getString("nama"));

                    // list.add digunakan untuk menambahkan data jenis member ke list
                    list.add(jenisMember);
                }
            } catch (SQLException e) {
                // jika terjadi error, maka akan ditampilkan errornya
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai list
        return list;
    }
}

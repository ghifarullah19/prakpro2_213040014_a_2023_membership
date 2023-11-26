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
import member.Member;
import jenis_member.JenisMember;

/**
 *
 * @author ghifarullah19
 */

// MemberDao adalah class yang digunakan untuk mengakses data member dari database
public class MemberDao {
    // insert digunakan untuk menyimpan data member ke database
    public int insert(Member member) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("Insert into member(id, nama, jenis_member_id) values (?, ?, ?)");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter member
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getJenisMember().getId());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // update digunakan untuk mengubah data member di database
    public int update(Member member) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("update member set nama = ?, jenis_member_id = ? where id = ?");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter member
            statement.setString(1, member.getNama());
            statement.setString(2, member.getJenisMember().getId());
            statement.setString(3, member.getId());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // delete digunakan untuk menghapus data member di database
    public int delete(Member member) {
        // result adalah variabel yang digunakan untuk menyimpan nilai apakah eksekusi query berhasil dilakukan atau tidak
        int result = -1;

        // try with resources digunakan untuk mengambil koneksi dari database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // PreparedStatement digunakan untuk menyiapkan query yang akan dijalankan
            PreparedStatement statement = connection.prepareStatement("delete from member where id = ?");

            // statement.setString digunakan untuk mengisi parameter query dengan nilai dari parameter member
            statement.setString(1, member.getId());

            // result diberikan nilai dari eksekusi query (Berisi jumlah row dari statement berarti berhasil, Berisi 0 berarti gagal)
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // jika terjadi error, maka akan ditampilkan errornya
            e.printStackTrace();
        }

        // mengembalikan nilai result
        return result;
    }
    
    // findAll digunakan untuk mengambil semua data member dari database
    public List<Member> findAll() {
        // list adalah variabel yang digunakan untuk menyimpan semua data member
        List<Member> list = new ArrayList<>();

        // try with resources digunakan untuk mengambil koneksi dari database dan membuat statement untuk mengeksekusi query
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            // ResultSet digunakan untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from member join jenis_member on jenis_member.id = member.jenis_member_id")) {

                // resultSet.next digunakan untuk mengecek apakah masih ada data atau tidak
                while(resultSet.next()) {
                    // membuat instance dari Member
                    Member member = new Member();

                    // memberikan nilai dari hasil eksekusi query ke instance member
                    member.setId(resultSet.getString("id"));
                    member.setNama(resultSet.getString("nama"));
                    
                    // membuat instance dari JenisMember
                    JenisMember jenisMember = new JenisMember();

                    // memberikan nilai dari hasil eksekusi query ke instance jenisMember
                    jenisMember.setId(resultSet.getString("jenis_member_id"));
                    jenisMember.setNama(resultSet.getString("nama"));
                    
                    // memberikan nilai instance jenisMember ke instance member
                    member.setJenisMember(jenisMember);
                    
                    // menambahkan instance member ke list
                    list.add(member);
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

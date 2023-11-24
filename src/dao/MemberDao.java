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
import member.MemberFrame;
import jenis_member.JenisMember;

/**
 *
 * @author ghifarullah19
 */
public class MemberDao {
    public int insert(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("Insert into member(id, nama, jenis_member_id) values (?, ?, ?)");
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getJenisMember().getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int update(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update member set nama = ?, jenis_member_id = ? where id = ?");
            statement.setString(1, member.getNama());
            statement.setString(2, member.getJenisMember().getId());
            statement.setString(3, member.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int delete(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from member where id = ?");
            statement.setString(1, member.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            try (ResultSet resultSet = statement.executeQuery("select * from member join jenis_member on jenis_member.id = member.jenis_member_id")) {
                while(resultSet.next()) {
                    Member member = new Member();
                    member.setId(resultSet.getString("id"));
                    member.setNama(resultSet.getString("nama"));
                    
                    JenisMember jenisMember = new JenisMember();
                    jenisMember.setId(resultSet.getString("jenis_member_id"));
                    jenisMember.setNama(resultSet.getString("nama"));
                    
                    member.setJenisMember(jenisMember);
                    
                    list.add(member);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

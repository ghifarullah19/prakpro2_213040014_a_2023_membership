/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisMemberDao;
import java.awt.HeadlessException;

/**
 *
 * @author ghifarullah19
 */
public class JenisMemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = this.jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,
                60,
                350,
                30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 
                100, 
                100, 
                40);
        
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                150,
                350,
                200);
        
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);
        
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this,
                        jenisMemberDao);
        
        button.addActionListener(actionListener);
        
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    public String getNama() {
        return textFieldNama.getText();
    }
    
    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}

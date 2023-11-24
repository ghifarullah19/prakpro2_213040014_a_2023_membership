/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import jenis_member.JenisMember;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisMemberDao;
import dao.MemberDao;

/**
 *
 * @author ghifarullah19
 */
public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private JComboBox comboJenis;
    private MemberTableModel tableModel;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.memberDao = memberDao;
        this.memberList = memberDao.findAll();
        
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 
                40, 
                350, 
                10);
        
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,
                60,
                350,
                30);
        
        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15, 
                100, 
                350, 
                10);
        
        comboJenis = new JComboBox();
        comboJenis.setBounds(15,
                120,
                150,
                30);
        
        JButton button = new JButton("Simpan");
        button.setBounds(15, 
                160, 
                100, 
                40);
        
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                220,
                350,
                200);
        
        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);
        
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this,
                        memberDao);
        
        button.addActionListener(actionListener);
        
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);
        
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }
    
    public String getNama() {
        return textFieldNama.getText();
    }
    
    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }
    
    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }
    
    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this,
                message);
    }
}

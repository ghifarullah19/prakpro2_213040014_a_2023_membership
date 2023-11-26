/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;

import javax.swing.*;
import java.util.*;
import dao.JenisMemberDao;

/**
 *
 * @author ghifarullah19
 */

//  JenisMemberFrame adalah class yang digunakan untuk menampilkan frame jenis member
public class JenisMemberFrame extends JFrame {
    // jenisMemberList adalah variabel yang digunakan untuk menyimpan data jenis member
    private List<JenisMember> jenisMemberList;

    // textFieldNama adalah variabel yang digunakan untuk menyimpan inputan nama jenis member
    private JTextField textFieldNama;
    
    // tableModel adalah variabel yang digunakan untuk menjadi model tabel dari tabel jenis member
    private JenisMemberTableModel tableModel;
    
    // jenisMemberDao adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private JenisMemberDao jenisMemberDao;

    // constructor JenisMemberFrame 
    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        // this.jenisMemberDao diberikan nilai dari parameter jenisMemberDao
        this.jenisMemberDao = jenisMemberDao;
        // this.jenisMemberList diberikan nilai dari data jenis member yang didapat dari database
        this.jenisMemberList = this.jenisMemberDao.findAll();

        // Frame ini akan ditutup jika tombol close diklik
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // labelInput adalah variabel yang digunakan untuk menampilkan label inputan nama jenis member
        JLabel labelInput = new JLabel("Nama: ");
        // labelInput diberikan posisi dan ukuran
        labelInput.setBounds(15, 40, 350, 10);
        
        // textFieldNama diinstansiasi dan diberikan posisi dan ukuran
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,
                60,
                350,
                30);
        
        // button diinstansiasi dengan text "Simpan" dan diberikan posisi dan ukuran
        JButton button = new JButton("Simpan");
        button.setBounds(15, 
                100, 
                100, 
                40);
        
        // table diinstansiasi
        JTable table = new JTable();
        // scrollableTable diinstansiasi dan diberikan posisi dan ukuran, serta diberikan ke tabel
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                150,
                350,
                200);
        
        // tableModel diinstansiasi dengan data jenis member yang didapat dari database
        tableModel = new JenisMemberTableModel(jenisMemberList);
        // tableModel diberikan ke tabel
        table.setModel(tableModel);
        
        // JenisMemberButtonSimpanActionListener diinstansiasi dengan actionListener untuk frame ini dan akses database dengan jenisMemberDao
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this,
                        jenisMemberDao);
        
        // button diberikan event listener dari actionListener
        button.addActionListener(actionListener);
        
        // frame ini diberikan komponen-komponen berikut
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        
        // frame ini diberikan posisi dan ukuran
        this.setSize(400, 500);
        // frame ini diberikan layout null
        this.setLayout(null);
    }
    
    // getNama digunakan untuk mengambil nilai dari inputan nama jenis member
    public String getNama() {
        // mengembalikan nilai dari inputan nama jenis member
        return textFieldNama.getText();
    }
    
    // addJenisMember digunakan untuk menambahkan data jenis member ke dalam tabel
    public void addJenisMember(JenisMember jenisMember) {
        // tableModel diberikan data jenis member
        tableModel.add(jenisMember);
        // textFieldNama diberikan nilai kosong
        textFieldNama.setText("");
    }
}

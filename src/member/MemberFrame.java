/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import jenis_member.JenisMember;
import javax.swing.*;
import java.util.*;
import dao.JenisMemberDao;
import dao.MemberDao;

/**
 *
 * @author ghifarullah19
 */

// MemberFrame adalah class yang digunakan untuk menampilkan frame member
public class MemberFrame extends JFrame {
    // jenisMemberList adalah variabel yang digunakan untuk menyimpan data jenis member
    private List<JenisMember> jenisMemberList;

    // memberList adalah variabel yang digunakan untuk menyimpan data member
    private List<Member> memberList;

    // textFieldNama adalah variabel yang digunakan untuk menyimpan inputan nama member
    private JTextField textFieldNama;

    // comboJenis adalah variabel yang digunakan untuk menyimpan inputan jenis member
    private JComboBox comboJenis;

    // tableModel adalah variabel yang digunakan untuk menjadi model tabel dari tabel member
    private MemberTableModel tableModel;

    // memberDao adalah variabel yang digunakan untuk menyimpan data member yang didapat dari database
    private MemberDao memberDao;

    // jenisMemberDao adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private JenisMemberDao jenisMemberDao;

    // constructor MemberFrame
    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        // Frame ini akan ditutup jika tombol close diklik
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // this.memberDao diberikan nilai dari parameter memberDao
        this.memberDao = memberDao;
        // this.memberList diberikan nilai dari data member yang didapat dari database
        this.memberList = memberDao.findAll();
        
        // this.jenisMemberDao diberikan nilai dari parameter jenisMemberDao
        this.jenisMemberDao = jenisMemberDao;
        // this.jenisMemberList diberikan nilai dari data jenis member yang didapat dari database
        this.jenisMemberList = jenisMemberDao.findAll();
        
        // labelInput adalah variabel yang digunakan untuk menampilkan label inputan nama member
        JLabel labelInput = new JLabel("Nama: ");
        // labelInput diberikan posisi dan ukuran
        labelInput.setBounds(15, 
                40, 
                350, 
                10);
        
        // textFieldNama diinstansiasi dan diberikan posisi dan ukuran
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15,
                60,
                350,
                30);
        
        // labelJenis adalah variabel yang digunakan untuk menampilkan label inputan jenis member
        JLabel labelJenis = new JLabel("Jenis Member: ");
        // labelJenis diberikan posisi dan ukuran
        labelJenis.setBounds(15, 
                100, 
                350, 
                10);
        
        // comboJenis diinstansiasi dan diberikan posisi dan ukuran
        comboJenis = new JComboBox();
        comboJenis.setBounds(15,
                120,
                150,
                30);
        
        // button diinstansiasi dengan text "Simpan" dan diberikan posisi dan ukuran
        JButton button = new JButton("Simpan");
        button.setBounds(15, 
                160, 
                100, 
                40);
        
        // table diinstansiasi
        JTable table = new JTable();
        // scrollableTable diinstansiasi dan diberikan posisi dan ukuran, serta diberikan ke tabel
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,
                220,
                350,
                200);
        
        // tableModel diinstansiasi dengan data member yang didapat dari database
        tableModel = new MemberTableModel(memberList);
        // tableModel diberikan ke tabel
        table.setModel(tableModel);
        
        // MemberButtonSimpanActionListener adalah variabel yang digunakan untuk menangani event klik tombol simpan untuk frame ini dan akses database dengan memberDao
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this,
                        memberDao);
        
        // button diberikan event listener dari actionListener
        button.addActionListener(actionListener);
        
        // Frame ini diberikan komponen-komponen berikut
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);

        // Frame ini diberikan posisi dan ukuran
        this.setSize(400, 500);
        // Frame ini diberikan layout null
        this.setLayout(null);
    }
    
    // populateComboJenis digunakan untuk mengisi comboJenis dengan data jenis member
    public void populateComboJenis() {
        // jenisMemberList diberikan nilai dari data jenis member yang didapat dari database
        this.jenisMemberList = this.jenisMemberDao.findAll();

        // comboJenis dihapus semua itemnya
        comboJenis.removeAllItems();
        
        // comboJenis diberikan item-item dari jenisMemberList
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }
    
    // getNama digunakan untuk mengambil nilai dari inputan nama member
    public String getNama() {
        // mengembalikan nilai dari inputan nama member
        return textFieldNama.getText();
    }
    
    // getJenisMember digunakan untuk mengambil nilai dari inputan jenis member
    public JenisMember getJenisMember() {
        // mengembalikan nilai dari jenis member yang dipilih
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }
    
    // addMember digunakan untuk menambahkan data member ke dalam tabel
    public void addMember(Member member) {
        // tableModel diberikan data member
        tableModel.add(member);
        // textFieldNama direset
        textFieldNama.setText("");
    }
    
    // showAlert digunakan untuk menampilkan alert
    public void showAlert(String message) {
        // menampilkan alert dengan message
        JOptionPane.showMessageDialog(this,
                message);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import member.MemberFrame;
import jenis_member.JenisMemberFrame;
import java.awt.FlowLayout;
import javax.swing.*;
import dao.*;

/**
 *
 * @author ghifarullah19
 */

// MainFrame adalah class yang digunakan untuk menampilkan frame main
public class MainFrame extends JFrame {
    // jenisMemberFrame adalah variabel yang digunakan untuk menyimpan frame jenis member
    private JenisMemberFrame jenisMemberFrame;
    
    // memberFrame adalah variabel yang digunakan untuk menyimpan frame member
    private MemberFrame memberFrame;
    
    // buttonJenisMember adalah variabel yang digunakan untuk menyimpan tombol jenis member
    private JButton buttonJenisMember;
    
    // buttonMember adalah variabel yang digunakan untuk menyimpan tombol member
    private JButton buttonMember;
    
    // memberDao adalah variabel yang digunakan untuk menyimpan data member yang didapat dari database
    private MemberDao memberDao;
    
    // jenisMemberDao adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private JenisMemberDao jenisMemberDao;

    // constructor MainFrame
    public MainFrame() {
        // Frame ini akan ditutup jika tombol close diklik
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Frame dibuat dengan ukuran 400x500
        this.setSize(400,500);
        
        // this.jenisMemberDao diberikan nilai dari data jenis member yang didapat dari database
        this.jenisMemberDao = new JenisMemberDao();
        // this.memberDao diberikan nilai dari data member yang didapat dari database
        this.memberDao = new MemberDao();
        
        // this.jenisMemberFrame diberikan nilai dari frame jenisMemberDao
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        // this.memberFrame diberikan nilai dari frame memberDao dan jenisMemberDao
        this.memberFrame = new MemberFrame(memberDao,
                        jenisMemberDao);
        
        // Frame diberikan layout FlowLayout
        this.setLayout(new FlowLayout());

        // MainButtonActionListener diinstansiasi dengan parameter this
        MainButtonActionListener actionListener = new MainButtonActionListener(this);
        
        // buttonJenisMember diinstansiasi dengan text "Jenis Member"
        this.buttonJenisMember = new JButton("Jenis Member");
        // buttonMember diinstansiasi dengan text "Member"
        this.buttonMember = new JButton("Member");
        
        // buttonJenisMember diberikan actionListener
        this.buttonJenisMember.addActionListener(actionListener);
        // buttonMember diberikan actionListener
        this.buttonMember.addActionListener(actionListener);
        
        // Frame ini diberikan komponen buttonJenisMember
        this.add(buttonJenisMember);
        // Frame ini diberikan komponen buttonMember
        this.add(buttonMember);
    }
    
    // method getButtonJenisMember digunakan untuk mengembalikan nilai buttonJenisMember
    public JButton getButtonJenisMember() {
        // mengembalikan nilai buttonJenisMember
        return buttonJenisMember;
    }
    
    // method getButtonMember digunakan untuk mengembalikan nilai buttonMember
    public JButton getButtonMember() {
        // mengembalikan nilai buttonMember
        return buttonMember;
    }
    
    // method showJenisMemberFrame digunakan untuk menampilkan frame jenis member
    public void showJenisMemberFrame() {
        // jika frame jenis member belum ditampilkan,
        if (jenisMemberFrame == null) {
            // maka akan menampilkan frame jenis member dengan parameter jenisMemberDao
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        // frame jenis member akan ditampilkan
        jenisMemberFrame.setVisible(true);
    }
    
    // method showMemberFrame digunakan untuk menampilkan frame member
    public void showMemberFrame() {
        // jika frame member belum ditampilkan,
        if (memberFrame == null) {
            // maka akan menampilkan frame member dengan parameter memberDao dan jenisMemberDao
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        
        // frame member akan diisi comboJenis dengan data jenis member
        memberFrame.populateComboJenis();
        // frame member akan ditampilkan
        memberFrame.setVisible(true);
    }
    
    // method main digunakan untuk menjalankan program
    public static void main(String[] args) {
        // menjalankan program dengan thread
        SwingUtilities.invokeLater(new Runnable() {
            // method run digunakan untuk menjalankan program
            public void run() {
                // MainFrame diinstansiasi
                MainFrame f = new MainFrame();
                // MainFrame ditampilkan
                f.setVisible(true);
            }
        });
    }
    
}

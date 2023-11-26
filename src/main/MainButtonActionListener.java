/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.*;

/**
 *
 * @author ghifarullah19
 */

// MainButtonActionListener adalah class yang digunakan untuk menangani event klik tombol jenis member dan member pada frame main
public class MainButtonActionListener implements ActionListener {
    // mainFrame adalah variabel yang digunakan untuk menyimpan frame main
    private MainFrame mainFrame;
    
    // constructor MainButtonActionListener
    public MainButtonActionListener(MainFrame mainFrame) {
        // this.mainFrame diberikan nilai dari parameter mainFrame
        this.mainFrame = mainFrame;
    }
    
    // actionPerformed digunakan untuk menangani event klik tombol pada frame main
    public void actionPerformed(ActionEvent e) {
        // jika tombol yang diklik adalah tombol jenis member, 
        if (e.getSource() == mainFrame.getButtonJenisMember()) {
            // maka akan menampilkan frame jenis member
            mainFrame.showJenisMemberFrame();
        }
        // jika tombol yang diklik adalah tombol member, 
        else {
            // maka akan menampilkan frame member
            mainFrame.showMemberFrame();
        }
    }
}

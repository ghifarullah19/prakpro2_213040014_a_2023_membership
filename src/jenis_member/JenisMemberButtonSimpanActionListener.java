/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;

import java.awt.event.*;
import java.util.UUID;
import dao.JenisMemberDao;

/**
 *
 * @author ghifarullah19
 */

// JenisMemberButtonSimpanActionListener adalah class yang digunakan untuk menangani event klik tombol simpan pada frame jenis member
public class JenisMemberButtonSimpanActionListener implements ActionListener {
    // jenisMemberFrame adalah variabel yang digunakan untuk menyimpan frame jenis member
    private JenisMemberFrame jenisMemberFrame;
    // jenisMemberDao adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private JenisMemberDao jenisMemberDao;
    
    // constructor JenisMemberButtonSimpanActionListener
    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        // this.jenisMemberFrame diberikan nilai dari parameter jenisMemberFrame
        this.jenisMemberFrame = jenisMemberFrame;
        // this.jenisMemberDao diberikan nilai dari parameter jenisMemberDao
        this.jenisMemberDao = jenisMemberDao;
    }
    
    // actionPerformed digunakan untuk menangani event klik tombol simpan
    public void actionPerformed(ActionEvent e) {
        // nama adalah variabel yang digunakan untuk menyimpan inputan nama jenis member dari method getNama pada frame jenis member
        String nama = this.jenisMemberFrame.getNama();

        // jenisMember adalah variabel yang digunakan untuk menyimpan data jenis member
        JenisMember jenisMember = new JenisMember();

        // id jenis member diisi dengan UUID
        jenisMember.setId(UUID.randomUUID().toString());
        // nama jenis member diisi dengan inputan nama jenis member
        jenisMember.setNama(nama);
        
        // jenisMemberFrame diisi dengan data jenis member
        this.jenisMemberFrame.addJenisMember(jenisMember);
        // jenisMemberDao diisi dengan data jenis member
        this.jenisMemberDao.insert(jenisMember);
    }
}

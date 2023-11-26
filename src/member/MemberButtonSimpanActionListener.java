/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import jenis_member.*;
import java.awt.event.*;
import java.util.UUID;
import dao.MemberDao;

/**
 *
 * @author ghifarullah19
 */

// MemberButtonSimpanActionListener adalah class yang digunakan untuk menangani event klik tombol simpan pada frame member
public class MemberButtonSimpanActionListener implements ActionListener {
    // memberFrame adalah variabel yang digunakan untuk menyimpan frame member
    private MemberFrame memberFrame;
    // memberDao adalah variabel yang digunakan untuk menyimpan data member yang didapat dari database
    private MemberDao memberDao;
    
    // constructor MemberButtonSimpanActionListener
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        // this.memberFrame diberikan nilai dari parameter memberFrame
        this.memberFrame = memberFrame;
        // this.memberDao diberikan nilai dari parameter memberDao
        this.memberDao = memberDao;
    }
    
    // actionPerformed digunakan untuk menangani event klik tombol simpan
    public void actionPerformed(ActionEvent e) {
        // nama adalah variabel yang digunakan untuk menyimpan inputan nama member dari method getNama pada frame member
        String nama = this.memberFrame.getNama();

        // jika nama kosong, 
        if (nama.isEmpty()) {
            // maka akan menampilkan alert
            this.memberFrame.showAlert("Nama Tidak Boleh Kosong");
        } 
        // jika nama tidak kosong, maka akan menyimpan data member
        else {
            // jenisMember adalah variabel yang digunakan untuk menyimpan data jenis member
            JenisMember jenisMember = this.memberFrame.getJenisMember();

            // member adalah variabel yang digunakan untuk menyimpan data member
            Member member = new Member();
            
            // id member diisi dengan UUID
            member.setId(UUID.randomUUID().toString());
            // nama member diisi dengan inputan nama member
            member.setNama(nama);
            // jenis member diisi dengan data jenis member
            member.setJenisMember(jenisMember);

            // memberFrame diisi dengan data member
            this.memberFrame.addMember(member);
            // memberDao diisi dengan data member
            this.memberDao.insert(member);
        }
        
    }
}

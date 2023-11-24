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
public class JenisMemberButtonSimpanActionListener implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;
    
    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }
    
    public void actionPerformed(ActionEvent e) {
        String nama = this.jenisMemberFrame.getNama();
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString());
        jenisMember.setNama(nama);
        
        this.jenisMemberFrame.addJenisMember(jenisMember);
        this.jenisMemberDao.insert(jenisMember);
    }
}

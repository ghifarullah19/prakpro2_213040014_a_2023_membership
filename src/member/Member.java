/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package member;

import jenis_member.JenisMember;

/**
 *
 * @author ghifarullah19
 */
public class Member {
    private String id;
    private String nama;
    private JenisMember jenisMember;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    } 
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return this.nama;
    }   
    
    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }
    
    public JenisMember getJenisMember() {
        return this.jenisMember;
    }   
}

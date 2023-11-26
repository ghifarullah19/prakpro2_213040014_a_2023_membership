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

// Member adalah class yang digunakan untuk menyimpan data member
public class Member {
    // id adalah variabel yang digunakan untuk menyimpan id dari member
    private String id;
    // nama adalah variabel yang digunakan untuk menyimpan nama dari member
    private String nama;
    // jenisMember adalah variabel yang digunakan untuk menyimpan jenis member dari member
    private JenisMember jenisMember;
    
    // setter id digunakan untuk mengubah nilai dari variabel id
    public void setId(String id) {
        // this.id diberikan nilai dari parameter id
        this.id = id;
    }
    
    // getter id digunakan untuk mengambil nilai dari variabel id
    public String getId() {
        // mengembalikan nilai dari variabel id
        return this.id;
    } 
    
    // setter nama digunakan untuk mengubah nilai dari variabel nama
    public void setNama(String nama) {
        // this.nama diberikan nilai dari parameter nama
        this.nama = nama;
    }
    
    // getter nama digunakan untuk mengambil nilai dari variabel nama
    public String getNama() {
        // mengembalikan nilai dari variabel nama
        return this.nama;
    }   
    
    // setter jenisMember digunakan untuk mengubah nilai dari variabel jenisMember
    public void setJenisMember(JenisMember jenisMember) {
        // this.jenisMember diberikan nilai dari parameter jenisMember
        this.jenisMember = jenisMember;
    }
    
    // getter jenisMember digunakan untuk mengambil nilai dari variabel jenisMember
    public JenisMember getJenisMember() {
        // mengembalikan nilai dari variabel jenisMember
        return this.jenisMember;
    }   
}

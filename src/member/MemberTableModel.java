/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import dao.JenisMemberDao;
import javax.swing.table.*;
import java.util.List;
import jenis_member.JenisMember;

/**
 *
 * @author ghifarullah19
 */

// MemberTableModel adalah class yang digunakan untuk menampilkan data member ke dalam tabel
public class MemberTableModel extends AbstractTableModel {
    // columnNames adalah variabel yang digunakan untuk menyimpan nama kolom dari tabel
    private String[] columnNames = {"Nama", "Jenis Member"};

    // data adalah variabel yang digunakan untuk menyimpan data member
    private List<Member> data;

    // jenisMember adalah variabel yang digunakan untuk menyimpan data jenis member
    private JenisMemberDao jenisMember = new JenisMemberDao();

    // dataJenisMember adalah variabel yang digunakan untuk menyimpan data jenis member yang didapat dari database
    private List<JenisMember> dataJenisMember = jenisMember.findAll();
    
    // constructor MemberTableModel digunakan untuk mengisi nilai dari parameter data
    public MemberTableModel(List<Member> data) {
        // this.data diberikan nilai dari parameter data
        this.data = data;
    }
    
    // getColumnCount digunakan untuk mengambil jumlah kolom dari tabel
    public int getColumnCount() {
        // mengembalikan nilai dari panjang array columnNames
        return columnNames.length;
    }
    
    // getRowCount digunakan untuk mengambil jumlah baris dari tabel
    public int getRowCount() {
        // mengembalikan nilai dari panjang array data
        return data.size();
    }
    
    // getColumnName digunakan untuk mengambil nama kolom dari tabel
    public String getColumnName(int col) {
        // mengembalikan nilai dari array columnNames pada index col
        return columnNames[col];
    }
    
    // getValueAt digunakan untuk mengambil nilai dari tabel pada baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // rowItem adalah variabel yang digunakan untuk menyimpan data member pada baris tertentu
        Member rowItem = data.get(row);
        // value adalah variabel yang digunakan untuk menyimpan nilai dari tabel pada baris dan kolom tertentu
        String value = "";
        
        // switch case digunakan untuk menentukan nilai dari variabel value
        switch (col) {
            // jika col bernilai 0,
            case 0:
                // maka value diberikan nilai dari nama member
                value = rowItem.getNama();
                break;
            // jika col bernilai 1,
            case 1:
                // maka value diberikan nilai dari nama jenis member, dengan cara mencari nama jenis member berdasarkan id jenis member
                for (JenisMember jenis : this.dataJenisMember) {
                    // jika id jenis member sama dengan id jenis member dari member,
                    if (jenis.getId().equals(rowItem.getJenisMember().getId())) {
                        // maka value diberikan nilai dari nama jenis member
                        value = jenis.getNama();
                    }
                }
                break;
        }
        
        // mengembalikan nilai dari variabel value
        return value;
    }
    
    // isCellEditable digunakan untuk menentukan apakah sel pada tabel dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        // mengembalikan nilai false
        return false;
    }
    
    // add digunakan untuk menambahkan data member ke dalam tabel
    public void add(Member value) {
        // data ditambahkan dengan value
        data.add(value);
        // fireTableRowsInserted digunakan untuk memberitahu bahwa data telah ditambahkan
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
}

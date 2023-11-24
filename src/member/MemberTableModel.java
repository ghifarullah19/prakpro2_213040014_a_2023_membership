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
public class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Jenis Member"};
    private List<Member> data;
    private JenisMemberDao jenisMember = new JenisMemberDao();
    private List<JenisMember> dataJenisMember = jenisMember.findAll();
    
    public MemberTableModel(List<Member> data) {
        this.data = data;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        String value = "";
        
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                for (JenisMember jenis : this.dataJenisMember) {
                    if (jenis.getId().equals(rowItem.getJenisMember().getId())) {
                        System.out.println(rowItem.getJenisMember().getNama());
                        value = jenis.getNama();
                    }
                }
                break;
        }
        
        return value;
    }
    
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
}

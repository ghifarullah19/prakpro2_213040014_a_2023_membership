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
public class MainButtonActionListener implements ActionListener {
    private MainFrame mainFrame;
    
    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainFrame.getButtonJenisMember()) {
            mainFrame.showJenisMemberFrame();
        } else {
            mainFrame.showMemberFrame();
        }
    }
}

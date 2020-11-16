/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import vista.frmMain;
/**
 * 
 * @author Josue Emmanuel Medina Garcia
 */
public class EventsController implements MouseListener{

    private final frmMain menu;
    
    public EventsController(frmMain menu) {
        this.menu = menu;
        events();
    }
    
    public final void events() {
       menu.getPanelDetalle().addMouseListener(this);
       menu.getPanelInspeccion().addMouseListener(this);
       menu.getPanelListadoUsuarios().addMouseListener(this);
       menu.getPanelProveedores().addMouseListener(this);
       menu.getPanelRegistro().addMouseListener(this);
       menu.getPanelSalida().addMouseListener(this);
    }
    
    void closeActivePanels() {
        menu.getFrmRegistro().setVisible(false);
        menu.getFrmSalida().setVisible(false);
        menu.getFrmProveedores().setVisible(false);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object evt = me.getSource();
        
        if(evt.equals(menu.getPanelDetalle())) {
            System.out.println("Panel detalle");
        }
        else if(evt.equals(menu.getPanelInspeccion())){
            System.out.println("Panel inspeccion");
        }
        else if(evt.equals(menu.getPanelListadoUsuarios())){
            System.out.println("Panel listado de usuarios");
        }
        else if(evt.equals(menu.getPanelProveedores())){
            System.out.println("Panel proveedores");
            closeActivePanels();
            menu.getFrmProveedores().setVisible(true);
            menu.setActiveFrame(menu.getFrmProveedores());
        }
        else if(evt.equals(menu.getPanelRegistro())){
            System.out.println("Panel registro");
            closeActivePanels();
            menu.getFrmRegistro().setVisible(true);
            menu.setActiveFrame(menu.getFrmRegistro());
        }
        else if(evt.equals(menu.getPanelSalida())){
            System.out.println("Panel salida");
            closeActivePanels();
            menu.getFrmSalida().setVisible(true);
            menu.setActiveFrame(menu.getFrmSalida());
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        Object evt = me.getSource();
        
        if(evt.equals(menu.getPanelDetalle())) {
            changePanelColor(menu.getPanelDetalle(), new Color(53,162,107));
        }
        else if(evt.equals(menu.getPanelInspeccion())){
            changePanelColor(menu.getPanelInspeccion(), new Color(53,162,107));
        }
        else if(evt.equals(menu.getPanelListadoUsuarios())){
            changePanelColor(menu.getPanelListadoUsuarios(), new Color(53,162,107));
        }
        else if(evt.equals(menu.getPanelProveedores())){
            changePanelColor(menu.getPanelProveedores(), new Color(53,162,107));
        }
        else if(evt.equals(menu.getPanelRegistro())){
            changePanelColor(menu.getPanelRegistro(), new Color(53,162,107));
        }
        else if(evt.equals(menu.getPanelSalida())){
            changePanelColor(menu.getPanelSalida(), new Color(53,162,107));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        Object evt = me.getSource();
        
        if(evt.equals(menu.getPanelDetalle())) {
            changePanelColor(menu.getPanelDetalle(), new Color(54,70,78));
        }
        else if(evt.equals(menu.getPanelInspeccion())){
            changePanelColor(menu.getPanelInspeccion(), new Color(54,70,78));
        }
        else if(evt.equals(menu.getPanelListadoUsuarios())){
            changePanelColor(menu.getPanelListadoUsuarios(), new Color(54,70,78));
        }
        else if(evt.equals(menu.getPanelProveedores())){
            changePanelColor(menu.getPanelProveedores(), new Color(54,70,78));
        }
        else if(evt.equals(menu.getPanelRegistro())){
            changePanelColor(menu.getPanelRegistro(), new Color(54,70,78));
        }
        else if(evt.equals(menu.getPanelSalida())){
            changePanelColor(menu.getPanelSalida(), new Color(54,70,78));
        }
    }
    
    private void changePanelColor(JPanel panel, Color color) {
        panel.setBackground(color);
    }

}

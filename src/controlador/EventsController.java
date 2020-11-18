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
       menu.getPanelClasificacion().addMouseListener(this);
       menu.getPanelListadoUsuarios().addMouseListener(this);
       menu.getPanelProveedores().addMouseListener(this);
       menu.getPanelRegistro().addMouseListener(this);
       menu.getPanelSalida().addMouseListener(this);
    }
    
    public void closeActiveFrames() {
        menu.getFrmRegistro().setVisible(false);
        menu.getFrmSalida().setVisible(false);
        menu.getFrmProveedores().setVisible(false);
        menu.getFrmHistorial().setVisible(false);
        menu.getFrmClasificacion().setVisible(false);
        menu.getFrmListadoUsuarios().setVisible(false);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object evt = me.getSource();
        
        if(evt.equals(menu.getPanelDetalle())) {
            closeActiveFrames();
            menu.getFrmHistorial().setVisible(true);
            menu.setActiveFrame(menu.getFrmHistorial());
        }
        else if(evt.equals(menu.getPanelClasificacion())){
            closeActiveFrames();
            menu.getFrmClasificacion().setVisible(true);
            menu.setActiveFrame(menu.getFrmListadoUsuarios());
        }
        else if(evt.equals(menu.getPanelListadoUsuarios())){
            closeActiveFrames();
            menu.getFrmListadoUsuarios().setVisible(true);
            menu.setActiveFrame(menu.getFrmListadoUsuarios());
        }
        else if(evt.equals(menu.getPanelProveedores())){
            
            closeActiveFrames();
            menu.getFrmProveedores().setVisible(true);
            menu.setActiveFrame(menu.getFrmProveedores());
        }
        else if(evt.equals(menu.getPanelRegistro())){
            
            closeActiveFrames();
            menu.getFrmRegistro().setVisible(true);
            menu.setActiveFrame(menu.getFrmRegistro());
        }
        else if(evt.equals(menu.getPanelSalida())){
            
            closeActiveFrames();
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
        else if(evt.equals(menu.getPanelClasificacion())){
            changePanelColor(menu.getPanelClasificacion(), new Color(53,162,107));
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
        else if(evt.equals(menu.getPanelClasificacion())){
            changePanelColor(menu.getPanelClasificacion(), new Color(54,70,78));
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

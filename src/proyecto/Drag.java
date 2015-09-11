/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dany
 */
public class Drag extends JLabel implements MouseMotionListener, MouseListener, Serializable, Cloneable {

    private Dimension d = new Dimension(70, 70);
    private Point punto = new Point(250, 20);
    private Point comienzo; //el comienzo del label
    private Point dra;      //comienzo de drag
    private Point off;      
    private int nx = 1;
    private int ny = 1;
    int textloc = JLabel.CENTER;
    private String name = "";
    String path;
    JLabel x = new JLabel();

    public Drag() {
        super();
    }

    public Drag(String path, String name) {
        this.path = path;
        this.setHorizontalTextPosition(0);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(d);
        this.setPreferredSize(d);
        ImageIcon ii = new ImageIcon(path);
        Icon icono = new ImageIcon(ii.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
        this.setIcon(icono);
        this.setText(name);
        this.setVisible(true);
        this.setLocation(punto);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public void paste(Icon icon ,String name,int x,int y,int ancho,int alto,String text,Font f,Color c,Color t){
        this.setHorizontalTextPosition(0);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(ancho,alto);
        this.setIcon(icon);
        this.setText(text);
        this.setFont(f);
        this.setOpaque(true);
        this.setBackground(c);
        this.setForeground(t);
        this.setVisible(true);
        this.setLocation(punto);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Dimension getD() {
        return d;
    }

    public void setD(Dimension d) {
        this.d = d;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //conseguir punto
    public Point getPunto(MouseEvent e) {
        Point mouse = e.getPoint();
        Point fin_mouse = this.getLocationOnScreen();
        return new Point((int) (fin_mouse.getX() + mouse.getX()), (int) (fin_mouse.getY() + mouse.getY()));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        x = x;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.dra = getPunto(me);
        this.comienzo = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        nx = (this.getLocation().x);
        ny = (this.getLocation().y);
        this.setLocation(nx, ny);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        this.setBorder(BorderFactory.createCompoundBorder());
    }

    @Override
    public void mouseExited(MouseEvent me) {
        this.setBorder(null);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.isMetaDown()) {

        } else {
            Point pp = this.getPunto(me);
            off = new Point((int) pp.getX() - (int) dra.getX(), (int) pp.getY() - (int) dra.getY());
            Point fin = new Point((int) (off.getX() + this.comienzo.getX()), (int) (off.getY() + this.comienzo.getY()));
            this.setLocation(fin);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}

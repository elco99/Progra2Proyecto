/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Dany
 */
public class Pane_temp implements Serializable {
    private JLabel label;
    private String name;

    public Pane_temp() {
    }

    public Pane_temp(JLabel label) {
        this.label = label;

    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

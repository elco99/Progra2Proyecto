/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static javax.print.attribute.standard.MediaPrintableArea.INCH;
import javax.swing.JPanel;

/**
 *
 * @author Dany
 */
public class Imprimir implements Printable {

    JPanel imprimir_este;

    public Imprimir() {
    }

    public Imprimir(JPanel imprimir_este) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        this.imprimir_este = imprimir_este;
        printJob.setPrintable(this);
        if (printJob.printDialog() == true) {
            try {
                printJob.print();
            } catch (Exception PrintException) {
                PrintException.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            imprimir_este.printAll(graphics);
            return (PAGE_EXISTS);
        } else {
            return (NO_SUCH_PAGE);
        }
    }

}

package org.japo.java.libraries;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 *
 * @author JAPO Labs - japolabs@gmail.com
 */
public final class UtilesPortapapeles {

    // Portapapeles del Sistema
    public static final Clipboard CLB = Toolkit.getDefaultToolkit().getSystemClipboard();

    // Constructor Inaccesible
    private UtilesPortapapeles() {
    }

    // Texto > Portapapeles
    public static final void escribir(String txt) {
//        try {
            // Codificación Binaria - Esto hay que mejorarlo!
            byte[] bytes = txt.getBytes();
//            System.out.println(new String(bytes, "UTF-8"));
//            System.out.println(new String(bytes, "ISO-8859-1"));
//            System.out.println(new String(bytes, "ISO-8859-15"));
//            System.out.println(new String(bytes, "Windows-1252"));
//            txt = new String(bytes, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            System.out.println(e.getMessage());
//        }

        // Implementación de Transferable
        StringSelection dato = new StringSelection(txt);

        // Inserta en el Portapapeles
        CLB.setContents(dato, null);
    }

    // Portapapeles > Pegar Salida
    public static final void pegar() {
        Robot robot = UtilesRobot.ROBOT;
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static final void inyectar(String txt) {
        escribir(txt);
        pegar();
    }
}

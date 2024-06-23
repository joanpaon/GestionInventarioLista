package org.japo.java.libraries;

import java.awt.AWTException;
import java.awt.Robot;

/**
 *
 * @author JAPO Labs - japolabs@gmail.com
 */
public final class UtilesRobot {
    // Instancia del Robot
    public static final Robot ROBOT = generar();

    // Constructor Inaccesible
    private UtilesRobot() {
    }

    private static Robot generar() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
}

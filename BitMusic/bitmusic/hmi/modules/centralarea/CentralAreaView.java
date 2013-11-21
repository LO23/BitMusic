/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaView extends AbstractView<CentralAreaController> {

    private static final String type = "CENTER";

    public CentralAreaView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- CentralAreaView.initPanel()");
        
        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CentralAreaView.update()");
    }
}

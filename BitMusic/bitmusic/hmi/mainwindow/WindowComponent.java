/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

import hmi.others.AbstractComponent;
import hmi.others.AbstractModel;


/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowComponent {
    private WindowModel model;
    private WindowView view;
    private WindowController controller;
    
    private AbstractComponent connectionComponent;
    
    
    public WindowComponent() {
        this.model = new WindowModel();
        this.controller = new WindowController(this.model);
        this.view = new WindowView(this.controller);
        this.model.addObserver(this.view);
    }

    private static class WindowModel extends AbstractModel {

        public WindowModel() {
        }
    }
}

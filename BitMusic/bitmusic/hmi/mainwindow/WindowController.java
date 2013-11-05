/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.mainwindow;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class WindowController {

    protected WindowModel windowModel;
    protected WindowView windowView;

    public WindowController(WindowModel model, WindowView view) {
        this.windowModel = windowModel;
        this.windowView = windowView;
    }

    public WindowModel getWindowModel() {
        return this.windowModel;
    }

    public void setWindowModel(WindowModel windowModel) {
        this.windowModel = windowModel;
    }

    public WindowView getWindowView() {
        return this.windowView;
    }

    public void setWindowView(WindowView windowView) {
        this.windowView = windowView;
    }


}

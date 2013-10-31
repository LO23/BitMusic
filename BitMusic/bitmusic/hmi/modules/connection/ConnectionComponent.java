/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmi.modules.connection;

import java.awt.Dimension;
import hmi.others.AbstractComponent;

/**
 *
 * @author hebergui, unkedeuxke
 */
public class ConnectionComponent extends AbstractComponent {
    private ConnectionModel connectionModel;
    private ConnectionView connectionView;
    private ConnectionController connectionController;
    
    public ConnectionComponent(Dimension dim) {
        connectionModel = new ConnectionModel();
        connectionController = new ConnectionController(connectionModel);
        connectionView = new ConnectionView(connectionController);
        connectionModel.addObserver(connectionView);
        connectionView.setVisible(true);
    }

    public ConnectionModel getConnectionModel() {
        return connectionModel;
    }

    public void setConnectionModel(ConnectionModel connectionModel) {
        this.connectionModel = connectionModel;
    }

    public ConnectionView getConnectionView() {
        return connectionView;
    }

    public void setConnectionView(ConnectionView connectionView) {
        this.connectionView = connectionView;
    }

    public ConnectionController getConnectionController() {
        return connectionController;
    }

    public void setConnectionController(ConnectionController connectionController) {
        this.connectionController = connectionController;
    }
    
}

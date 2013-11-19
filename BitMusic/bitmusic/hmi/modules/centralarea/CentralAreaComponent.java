/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractComponent;
import java.util.ArrayList;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaComponent extends AbstractComponent<CentralAreaModel, CentralAreaView, CentralAreaController> {

    private ArrayList<TabComponent> listTabComponent = new ArrayList<>();

    public CentralAreaComponent() {
        this.model = new CentralAreaModel();
        this.view = new CentralAreaView();
        this.controller = new CentralAreaController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);

        this.listTabComponent.add(new TabComponent());
    }
}

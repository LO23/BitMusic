/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.myprofile;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class MyProfileComponent extends AbstractComponent<MyProfileModel, MyProfileView, MyProfileController> {

    /**
     *
     */
    public MyProfileComponent() {
        this.model = new MyProfileModel();
        this.view = new MyProfileView();
        this.controller = new MyProfileController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersView extends AbstractView<OnlineUsersController> {

    private static final String type = "WEST";

    public OnlineUsersView() {
        super();
        this.initPanel();
    }

    @Override
    public void initPanel() {
        System.out.println("--- OnlineUsersView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
       return type;
    }
}

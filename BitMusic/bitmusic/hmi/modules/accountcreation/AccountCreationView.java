/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationView extends AbstractView<AccountCreationController> {

    private final String type = "ACCOUNTCREATION";

    public AccountCreationView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- AccountCreationView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- AccountCreation.update()");
    }
}

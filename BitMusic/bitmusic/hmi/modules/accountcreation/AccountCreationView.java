/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationView extends AbstractView<AccountCreationController> {

    private static final String type = "ACCOUNTCREATION";

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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationComponent extends AbstractComponent<AccountCreationModel, AccountCreationView, AccountCreationController> {

    public AccountCreationComponent() {
        this.model = new AccountCreationModel();
        this.view = new AccountCreationView();
        this.controller = new AccountCreationController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}

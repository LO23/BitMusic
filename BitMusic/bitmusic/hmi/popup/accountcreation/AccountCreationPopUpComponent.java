/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.accountcreation;

import bitmusic.hmi.patterns.AbstractComponent;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationPopUpComponent extends AbstractComponent<AccountCreationPopUpModel, AccountCreationPopUpView, AccountCreationPopUpController> {

    public AccountCreationPopUpComponent() {
        this.model = new AccountCreationPopUpModel();
        this.view = new AccountCreationPopUpView();
        this.controller = new AccountCreationPopUpController(this.model, this.view);
        this.view.setController(this.controller);
        this.view.initPanel();
        this.model.addObserver(this.view);
    }
}

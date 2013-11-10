/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.patterns.AbstractView;

/**
 *
 * @author unkedeuxke
 */
public final class SearchBarView extends AbstractView<SearchBarController> {

    private static final String type = "NORTH";
    
    public SearchBarView() {
        super();
        this.initPanel();
    }

    @Override
    public void initPanel() {
        System.out.println("--- SearchBarView.initPanel()");

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.patterns.AbstractController;

/**
 *
 * @author unkedeuxke
 */
public final class TabController extends AbstractController<TabModel, TabView> {

    public TabController(final TabModel model, final TabView view) {
        super(model, view);
    }
}

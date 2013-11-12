/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractController;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarController extends AbstractController<PlayBarModel, PlayBarView> {

    public PlayBarController(final PlayBarModel model, final PlayBarView view) {
        super(model, view);
    }
}

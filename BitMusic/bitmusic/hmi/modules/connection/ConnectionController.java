/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.connection;

import bitmusic.hmi.patterns.AbstractController;
import bitmusic.hmi.patterns.AbstractModel;
import bitmusic.hmi.patterns.AbstractView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hebergui, unkedeuxke
 */
public final class ConnectionController extends AbstractController {

    public ConnectionController(final AbstractModel abstractModel, final AbstractView abstractView) {
        super(abstractModel, abstractView);
    }

    public class ConnectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class CreateNewUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}

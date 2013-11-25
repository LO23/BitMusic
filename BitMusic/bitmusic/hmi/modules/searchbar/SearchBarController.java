/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.centralarea.CentralAreaView;
import bitmusic.hmi.modules.tab.TabComponent;
import bitmusic.hmi.patterns.AbstractController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author unkedeuxke
 */
public final class SearchBarController extends AbstractController<SearchBarModel, SearchBarView> {

    public SearchBarController(final SearchBarModel model, final SearchBarView view) {
        super(model, view);
    }

    public class ResearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Rechercher");

            //SearchBarModel model =  SearchBarController.this.getModel();

            CentralAreaView centralAreaView = WindowComponent.getInstance().getCentralAreaComponent().getView();
            centralAreaView.addTab(new TabComponent().getView());
        }
    }
}

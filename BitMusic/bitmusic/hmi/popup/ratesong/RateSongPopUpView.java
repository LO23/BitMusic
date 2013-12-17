/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.music.data.Grade;
import bitmusic.music.data.Song;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpView extends AbstractView<RateSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;
    private final JLabel rateSongLabel = new JLabel("Noter un morceau");
    private final JButton validateButton = new JButton("Valider");
    private final JButton cancelButton = new JButton("Annuler");
    private ButtonGroup groupRadio = new ButtonGroup();
    private JRadioButton songRater0 = new JRadioButton("0", false);
    private JRadioButton songRater1 = new JRadioButton("1", false);
    private JRadioButton songRater2 = new JRadioButton("2", false);
    private JRadioButton songRater3 = new JRadioButton("3", false);
    private JRadioButton songRater4 = new JRadioButton("4", false);
    private JRadioButton songRater5 = new JRadioButton("5", false);

    /**
     *
     * @param parentTabId
     */
    public RateSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- RateSongPopUpView.initPanel()");

        final Dimension d = new Dimension(80, 20);

        this.rateSongLabel.setSize(d);
        this.validateButton.setSize(d);
        this.validateButton.addActionListener(this.getController().new ValiderListener());
        this.cancelButton.setSize(d);
        this.cancelButton.addActionListener(this.getController().new CancelListener());

        Song song = this.getController().getModel().getSong();
        String currentUserId = WindowComponent.getInstance().getApiProfile().getCurrentUser().getUserId();
        int rate = -1;
        HashMap<String,Grade> mapGrade = song.getGrades();
        if (mapGrade != null) {
            Grade grade = mapGrade.get(currentUserId);
            if (grade != null) {
                rate = grade.getGrade();
                System.out.println("note = " + rate);
            }
        }

        if (rate==0)
            songRater0.setSelected(true);
        if (rate==1)
            songRater1.setSelected(true);
        else if (rate==2)
            songRater2.setSelected(true);
        else if (rate==3)
            songRater3.setSelected(true);
        else if (rate==4)
            songRater4.setSelected(true);
        else if (rate==5)
            songRater5.setSelected(true);
        //Sinon on n'a pas encore noté la musique on n'affiche rien

        // ajout dans un group radio pour faire en sorte de ne pouvoir cliquer que sur un bouton radio
        this.groupRadio.add(songRater0);
        this.groupRadio.add(songRater1);
        this.groupRadio.add(songRater2);
        this.groupRadio.add(songRater3);
        this.groupRadio.add(songRater4);
        this.groupRadio.add(songRater5);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(this.rateSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater0)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater1)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater2)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater3)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater4)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater5)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.validateButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.cancelButton)
                )


        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(this.rateSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.songRater0)
                    .addComponent(this.songRater1)
                    .addComponent(this.songRater2)
                    .addComponent(this.songRater3)
                    .addComponent(this.songRater4)
                    .addComponent(this.songRater5)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.validateButton)
                    .addComponent(this.cancelButton)
                )



        );

        // TODO : étoiles de notation manquantes
    }

    /**
     *
     * @return
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- RateSongPopUpView.update() -> " + str);
    }

    /**
     *
     * @return
     */
    public ButtonGroup getGroupRadio() {
        return groupRadio;
    }

    /**
     *
     * @param groupRadio
     */
    public void setGroupRadio(ButtonGroup groupRadio) {
        this.groupRadio = groupRadio;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater0() {
        return songRater0;
    }

    /**
     *
     * @param songRater0
     */
    public void setSongRater0(JRadioButton songRater0) {
        this.songRater0 = songRater0;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater1() {
        return songRater1;
    }

    /**
     *
     * @param songRater1
     */
    public void setSongRater1(JRadioButton songRater1) {
        this.songRater1 = songRater1;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater2() {
        return songRater2;
    }

    /**
     *
     * @param songRater2
     */
    public void setSongRater2(JRadioButton songRater2) {
        this.songRater2 = songRater2;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater3() {
        return songRater3;
    }

    /**
     *
     * @param songRater3
     */
    public void setSongRater3(JRadioButton songRater3) {
        this.songRater3 = songRater3;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater4() {
        return songRater4;
    }

    /**
     *
     * @param songRater4
     */
    public void setSongRater4(JRadioButton songRater4) {
        this.songRater4 = songRater4;
    }

    /**
     *
     * @return
     */
    public JRadioButton getSongRater5() {
        return songRater5;
    }

    /**
     *
     * @param songRater5
     */
    public void setSongRater5(JRadioButton songRater5) {
        this.songRater5 = songRater5;
    }

    /**
     *
     * @return
     */
    public int getParentTabId() {
        return parentTabId;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.music.data.Song;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpView extends AbstractView<InfosSongPopUpController> {

    private final String type = "POPUP";
    private final JLabel titleLabel = new JLabel("Titre : ");
    private final JLabel artistLabel = new JLabel("Artiste : ");
    private final JLabel albumLabel = new JLabel("Album : ");

    private final JLabel songTitleLabel = new JLabel("Nom son");
    private final JLabel songArtistLabel = new JLabel("Artiste son");
    private final JLabel songAlbumLabel = new JLabel("Album son");

    public InfosSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- InfosSongPopUpView.initPanel()");


        Song song = this.getController().getModel().getSong();

        this.songTitleLabel.setText(song.getTitle());
        this.songArtistLabel.setText(song.getArtist());
        this.songAlbumLabel.setText(song.getAlbum());

        // TODO : ajouter à la vue songs tags, comments, rate

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.titleLabel)
                .addComponent(this.songTitleLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.artistLabel)
                .addComponent(this.songArtistLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.albumLabel)
                .addComponent(this.songAlbumLabel))

        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.titleLabel)
                .addComponent(this.artistLabel)
                .addComponent(this.albumLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.songTitleLabel)
                .addComponent(this.songArtistLabel)
                .addComponent(this.songAlbumLabel))
            );


        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- InfosSongPopUpView.update() -> " + str);
    }
}

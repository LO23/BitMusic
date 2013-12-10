/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Song;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author unkedeuxke
 */
public final class InfosSongPopUpView extends AbstractView<InfosSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;



    private final JLabel titleLabel = new JLabel("Titre : ");
    private final JLabel artistLabel = new JLabel("Artiste : ");
    private final JLabel albumLabel = new JLabel("Album : ");

    private final JLabel songTitleLabel = new JLabel("Nom son : ");
    private final JLabel songArtistLabel = new JLabel("Artiste son : ");
    private final JLabel songAlbumLabel = new JLabel("Album son : ");
    private final JLabel commentLabel = new JLabel("Commentaires : ");
    private JTextField commentField = new JTextField("");
    private final JButton commentButton = new JButton("Commenter");
    private JTable commentsTable ;
    private JScrollPane commentsScrollPane ;
    private Vector columnNames = new Vector<String>();

    // Conteneur des commentaires
    private JPanel commentsPanel;


    public InfosSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
        this.commentsPanel = new JPanel();

    }

    @Override
    public void initPanel() {
        System.out.println("--- InfosSongPopUpView.initPanel()");


        Song song = this.getController().getModel().getSong();

        this.songTitleLabel.setText(song.getTitle());
        this.songArtistLabel.setText(song.getArtist());
        this.songAlbumLabel.setText(song.getAlbum());

        //BorderLayout commentsLayout = new BorderLayout();

        this.updateCommentsPanel(commentsPanel, this.getController().getModel().getCommentsOnTheSong());
        //commentsPanel.setSize(100, 100);



        this.commentButton.addActionListener(this.getController().new CommentPopUpOpenListener());

        // TODO : ajouter à la vue songs tags, comments, rate

        this.getPanel().setSize(800, 800);
        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.titleLabel)
                .addComponent(this.songTitleLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.artistLabel)
                .addComponent(this.songArtistLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.albumLabel)
                .addComponent(this.songAlbumLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.commentLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.commentsPanel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.commentButton))


        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.titleLabel)
                .addComponent(this.artistLabel)
                .addComponent(this.albumLabel)
                .addComponent(this.commentLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.songTitleLabel)
                .addComponent(this.songArtistLabel)
                .addComponent(this.songAlbumLabel)
                .addComponent(this.commentButton)
                .addComponent(this.commentsPanel))
            );


        // TODO
    }

    public void updateCommentsPanel(JPanel panel, LinkedList<Comment> comments) {
        //SpringLayout commentsLayout = new SpringLayout();
        GridLayout commentsLayout = new GridLayout(comments.size(), 2); // rows, col, hgap, vgap

        panel.setSize(500,100);
        panel.setLayout(commentsLayout);
        panel.setBackground(Color.white);

        // pour chaque commentaire, on cree deux labels: author et commentValue
        if (comments.isEmpty()) {
            JLabel noComment = new JLabel("Aucun commentaire...");

            //commentsLayout.putConstraint(SpringLayout.WEST, noComment, 5, SpringLayout.WEST, panel);
            panel.add(noComment);
        }
        else {
            for (Comment c: comments) {
                JLabel author = new JLabel(c.getAuthor());
                JLabel commentValue = new JLabel(c.getComment());
                /*commentsLayout.putConstraint(SpringLayout.WEST, author, 5, SpringLayout.WEST, panel);
                commentsLayout.putConstraint(SpringLayout.NORTH, author, 5, SpringLayout.NORTH, panel);

                commentsLayout.putConstraint(SpringLayout.WEST, commentValue, 5, SpringLayout.EAST, author);
                commentsLayout.putConstraint(SpringLayout.NORTH, commentValue, 5, SpringLayout.NORTH, panel);*/
                panel.add(author);
                panel.add(commentValue);

            }
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- InfosSongPopUpView.update() -> " + str);
    }

    public int getParentTabId() {
        return parentTabId;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getArtistLabel() {
        return artistLabel;
    }

    public JLabel getAlbumLabel() {
        return albumLabel;
    }

    public JLabel getSongTitleLabel() {
        return songTitleLabel;
    }

    public JLabel getSongArtistLabel() {
        return songArtistLabel;
    }

    public JLabel getSongAlbumLabel() {
        return songAlbumLabel;
    }

    public JTextField getCommentField() {
        return commentField;
    }
}

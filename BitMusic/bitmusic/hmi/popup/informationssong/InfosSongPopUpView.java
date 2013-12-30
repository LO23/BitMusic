/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.informationssong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.playbar.PlayBarModel;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.music.data.Comment;
import bitmusic.music.data.Grade;
import bitmusic.music.data.Song;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * View class of InfosSongPopUp
 * @author IHM
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
    // mettre le nombre de notes ?
    private final JLabel rateLabel = new JLabel("Note moyenne: ");
    private JLabel rateValueLabel = new JLabel("0 (pas de note) ");


    private JTextField commentField = new JTextField("");
    private final JButton commentButton = new JButton("Commenter");
    private JTable commentsTable ;
    private JScrollPane commentsScrollPane ;
    private Vector columnNames = new Vector<String>();

    // Conteneur des commentaires
    private JPanel commentsPanel;
    /**
     * Constructor of InfosSongPopUpView
     * @param parentTabId
     */

    public InfosSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
        this.commentsPanel = new JPanel();

    }

    /**
     * Initializes the view of InfosSongPopUp
     */
    @Override
    public void initPanel() {
        System.out.println("--- InfosSongPopUpView.initPanel()");


        Song song = this.getController().getModel().getSong();

        this.songTitleLabel.setText(song.getTitle());
        this.songArtistLabel.setText(song.getArtist());
        this.songAlbumLabel.setText(song.getAlbum());
        //update rateLabel
        //this.rateLabel.setText(song.ge);
        this.updateRateLabel();

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
                .addComponent(this.rateLabel)
                .addComponent(this.rateValueLabel))
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
                .addComponent(this.rateLabel)
                .addComponent(this.commentLabel))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.songTitleLabel)
                .addComponent(this.songArtistLabel)
                .addComponent(this.songAlbumLabel)
                .addComponent(this.rateValueLabel)
                .addComponent(this.commentButton)
                .addComponent(this.commentsPanel))
            );


        // TODO
    }
/**
 * Updates the rate of a song
 */
    public void updateRateLabel() {
        String gradeAverage = "0";
        double grade = 0;
        Song song = this.getController().getModel().getSong();
        HashMap<String, Grade> hashMap = song.getGrades();

        // pour chaque entree de la table de hashage
        for(Entry<String, Grade> entry : hashMap.entrySet()) {
            //String author = entry.getKey();
            grade = entry.getValue().getGrade() + grade;
        }

        // on fait la moyenne des notes obtenus
        grade = (double) grade / (double) hashMap.size();
        gradeAverage = String.valueOf(grade).toString();

        // pour afficher note/nombre de notes
        this.rateValueLabel.setText(gradeAverage + "/" + String.valueOf(hashMap.size()));
    }

    // à mettre dans le model

    public void updateCommentsPanel(JPanel panel, LinkedList<Comment> comments) {
        //SpringLayout commentsLayout = new SpringLayout();
        GridLayout commentsLayout = new GridLayout(comments.size(), 3); // rows, col, hgap, vgap

        //panel.setSize(500,100);
        panel.setMaximumSize(new Dimension(500, 100));
        panel.setLayout(commentsLayout);
        panel.setBackground(Color.white);
        String songID = this.getController().getModel().getSong().getSongId();

        // pour chaque commentaire, on cree deux labels: author et commentValue
        if (comments.isEmpty()) {
            JLabel noComment = new JLabel("Aucun commentaire...");

            //commentsLayout.putConstraint(SpringLayout.WEST, noComment, 5, SpringLayout.WEST, panel);
            panel.add(noComment);
        }
        else {
            for (Comment c: comments) {
                JLabel author = new JLabel(c.getAuthor());
                int numberOfRows = c.getComment().length() % 25;
                JTextArea commentValue = new JTextArea("Commentaire vide...");
                commentValue.setColumns(numberOfRows);
                //commentValue.setRows(numberOfRows);


                if (c.getComment().length() > 100) {
                    commentValue.setText(c.getComment().substring(1, 100)+ "...");
                    commentValue.setPreferredSize(new Dimension(100, 20));
                }
                else {
                    commentValue.setText(c.getComment());
                    commentValue.setPreferredSize(new Dimension(100, 20));
                }
                commentValue.setEditable(false);

                Dimension d = new Dimension(80,20);
                /// TODO : Gerer la longueur des commentaires
                commentValue.setMaximumSize(d);
                JButton deleteCommentButton = new JButton("X");
                deleteCommentButton.addActionListener(
                        this.getController().new DeleteCommentListener(songID, c.getAuthor(), c.getDate()));

                panel.add(author);
                panel.add(commentValue);
                panel.add(deleteCommentButton);

            }
        }
    }

    /**
     * Returns the type of the PopUp
     * The type of the PopUp refers to its location in the screen
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Updates the view
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- InfosSongPopUpView.update() -> " + str);

        InfosSongPopUpModel model = this.getController().getModel();
        String text = model.getSong().getArtist() + " - " + model.getSong().getTitle();

        // on effectue la mise à jour de la vue ici
        WindowComponent win = WindowComponent.getInstance();

        this.commentsPanel.removeAll();

        this.updateCommentsPanel(commentsPanel, model.getCommentsOnTheSong());
        //
        //this.getCommentsPanel().repaint();
        this.commentsPanel.validate();
        this.commentsPanel.repaint();

        win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().validate();
        win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().repaint();

        win.getCentralAreaComponent().getView().getTabComponent(parentTabId).getController().getPopUp().pack();
    }

    /**
     * Returns the parent id of the current tab
     * @return int parentTabId
     */
    public int getParentTabId() {
        return parentTabId;
    }

    /**
     * Returns the title label of a song
     * @return
     */
    public JLabel getTitleLabel() {
        return titleLabel;
    }

    /**
     * Returns the artist label of a song
     * @return JLabel artistLabel
     */
    public JLabel getArtistLabel() {
        return artistLabel;
    }

    /**
     * Returns the album label of a song
     * @return JLabel albumLabel
     */
    public JLabel getAlbumLabel() {
        return albumLabel;
    }

    /**
     * Returns the title label of a song
     * @return
     */
    public JLabel getSongTitleLabel() {
        return songTitleLabel;
    }

    /**
     * Returns the artist label of a song
     * @return
     */
    public JLabel getSongArtistLabel() {
        return songArtistLabel;
    }

    /**
     * Returns the album label of a song
     * @return
     */
    public JLabel getSongAlbumLabel() {
        return songAlbumLabel;
    }

    /**
     * Returns a comment
     * @return JTextField commentField
     */
    public JTextField getCommentField() {
        return commentField;
    }

    /**
     * @return JPanel commentsPanel
     */
    public JPanel getCommentsPanel() {
        return commentsPanel;
    }
}

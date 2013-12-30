/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.commentsong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * View class of CommentSongPopUp
 * @author IHM
 */
public final class CommentSongPopUpView extends AbstractView<CommentSongPopUpController> {

    private final String type = "POPUP";
    private int parentTabId;



    private final JLabel commentSongLabel = new JLabel("Commenter un morceau");
    private final JLabel commentLabel = new JLabel("Tapez votre commentaire ");
    private JTextField commentField = new JTextField("");
    private final JButton validateButton = new JButton("Valider");
    private final JButton resetButton = new JButton("Réinitialiser");

/**
 * Constructor of CommentSongPopUpView
 * @param parentTabId
 */

    public CommentSongPopUpView(int parentTabId) {

        super();
        this.parentTabId = parentTabId;

    }

    /**
     * Initializes the view
     */
    @Override
    public void initPanel() {
        System.out.println("--- CommentSongPopUpView.initPanel()");

        final Dimension d = new Dimension(80, 20);

        this.commentField.setSize(d);
        this.commentLabel.setSize(d);
        this.validateButton.setSize(d);
        this.resetButton.setSize(d);

        this.validateButton.addActionListener(this.getController().new ValidateListener());
        this.resetButton.addActionListener(this.getController().new ResetListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(commentSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(commentLabel)
                    .addComponent(validateButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(commentField)
                    .addComponent(resetButton)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(commentSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(commentLabel)
                    .addComponent(commentField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(resetButton)
                )
        );
                layout.linkSize(SwingConstants.HORIZONTAL, commentLabel, commentField);

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
     * Shows a message of update on the console
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CommentSongPopUpView.update() -> " + str);
    }

    /**
     * Returns a comment of a song
     * @return JTextField commentField
     */
    public JTextField getCommentField() {
        return commentField;
    }

    /**
     * Updates a comment of a song
     * @param comment
     */
    public void setCommentField(JTextField comment) {
        this.commentField = comment;
    }
    /**
     * Returns the parent id of the current tab
     * @return int parentTabId
     */
    public int getParentTabId() {
        return parentTabId;
    }
}

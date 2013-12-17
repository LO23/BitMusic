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
 * La classe de la vue de CommentSongPopUp
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
 * Constructeur CommentSongPopUpView
 * @param parentTabId
 */

    public CommentSongPopUpView(int parentTabId) {

        super();
        this.parentTabId = parentTabId;

    }

    /**
     *
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
     * Retourne le type de la PopUp qui correspend à son emplacement dans la fenêtre
     * @return le type de la PopUp
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
        System.out.println("----- CommentSongPopUpView.update() -> " + str);
    }

    /**
     * Retourne le commentaire saisi par l'utilisateur.
     * @return le commentaire saisi par l'utilisateur sous forme d'un JTextField.
     */
    public JTextField getCommentField() {
        return commentField;
    }

    /**
     * Met à jour le commentaire saisi par l'utilisateur.
     * @param comment
     *              Commentaire saisi par l'utilisateur.
     */
    public void setCommentField(JTextField comment) {
        this.commentField = comment;
    }
    /**
     *
     * @return
     */
    public int getParentTabId() {
        return parentTabId;
    }
}

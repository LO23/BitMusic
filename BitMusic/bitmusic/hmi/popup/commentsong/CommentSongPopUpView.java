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
 *
 * @author unkedeuxke
 */
public final class CommentSongPopUpView extends AbstractView<CommentSongPopUpController> {

    private final String type = "POPUP";
    private final JLabel commentSongLabel = new JLabel("Commenter un morceau");
    private final JLabel commentLabel = new JLabel("Tapez votre commentaire ");
    private JTextField commentField = new JTextField("");
    private final JButton validateButton = new JButton("Valider");
    private final JButton resetButton = new JButton("Réinitialiser");


    public CommentSongPopUpView() {
        super();
    }

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

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CommentSongPopUpView.update()");
    }

    public JTextField getCommentField() {
        return commentField;
    }

    public void setCommentField(JTextField comment) {
        this.commentField = comment;
    }
}

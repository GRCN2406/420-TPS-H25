package Item.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Une boîte de dialogue graphique affichant un message d'erreur à l'utilisateur.
 */
public class GUIErrorDialog extends JDialog
{
    /**
     * Crée une boîte de dialogue d'erreur avec un message personnalisé.
     *
     * @param frame   la fenêtre parente sur laquelle la boîte de dialogue est centrée
     * @param message le message d'erreur à afficher
     */
    public GUIErrorDialog(JFrame frame, String message) {
        super(frame, "Erreur", Dialog.ModalityType.DOCUMENT_MODAL);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        Container dialogContainer = getContentPane();
        dialogContainer.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(new JLabel(message));
        dialogContainer.add(labelPanel, BorderLayout.CENTER);

        JPanel okButtonPanel = new JPanel(new FlowLayout());
        okButtonPanel.add(okButton);
        dialogContainer.add(okButtonPanel, BorderLayout.SOUTH);

        pack();
    }

}

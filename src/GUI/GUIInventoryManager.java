package Item.GUI;

import Item.Exceptions.ExceptionInsufficientQuantityInStock;
import Item.Exceptions.ExceptionItemAlreadyExists;
import Item.Exceptions.ExceptionItemNotFound;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Item.Inventaire.*;
import Item.Item.* ;

public class GUIInventoryManager extends JFrame
{
    private InventoryManager inventoryManager;
    private DefaultListModel<Item> itemsListModel;
    private JList itemsList;
    private int nextID;

    public GUIInventoryManager(InventoryManager inventoryManager) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inventoryManager = inventoryManager;
        nextID = 100;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        add(createTitlePane(), BorderLayout.NORTH);
        add(createContentPane(), BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(border());
        contentPane.setLayout(new BorderLayout());

        contentPane.add(createItemActions(), BorderLayout.NORTH);
        contentPane.add(createItemsList(), BorderLayout.CENTER);
        contentPane.add(createNewButton(), BorderLayout.SOUTH);

        return contentPane;
    }

    private JPanel createTitlePane() {
        JPanel titlePane = new JPanel();
        titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.Y_AXIS));
        titlePane.setBorder(border());

        JLabel title = new JLabel("Gestionnaire d'inventaire", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(titleBorder());
        titlePane.add(title);
        titlePane.add(new JSeparator());

        return titlePane;
    }

    private JScrollPane createItemsList()
    {
        itemsListModel = new DefaultListModel<>();

        for (Item item : inventoryManager.getArrayOfItems()) {
            itemsListModel.addElement(item);
        }

        itemsList = new JList(itemsListModel);
        itemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(itemsList);

        return listScroller;
    }

    private JPanel createItemActions() {
        JPanel itemButtons = new JPanel();
        itemButtons.setLayout(new BoxLayout(itemButtons, BoxLayout.X_AXIS));

        itemButtons.add(createViewButton());
        itemButtons.add(createIncreaseButton());
        itemButtons.add(createDecreaseButton());
        itemButtons.add(createEditButton());
        itemButtons.add(createDeleteButton());

        return itemButtons;
    }

    private List<JLabel> createLabels(Item item){
        String motifAttributsItem = "\\](.*?)\\[";
        Pattern patternAtb = Pattern.compile(motifAttributsItem);
        Matcher matcherAtb = patternAtb.matcher(item.infoToString());
        List<JLabel> labels = new ArrayList<>();
        int compteur = 0;
        while (matcherAtb.find()){
            if (compteur == 3){
                labels.add(new JLabel("Quantité en stock"));
            }
            labels.add(new JLabel(matcherAtb.group(1).trim()));
            compteur++;
        }
        return labels;
    }

    private List<JTextField> createChamps(Item item){
        String motifValeursItem = "Catégorie\\s*\\[(.+?)\\]\\s*" +
                "ID\\s*\\[(.+?)\\]\\s*" +
                "Nom\\s*\\[(.+?)\\]\\s*" +
                "Prix\\s*\\[(.+?)\\]\\s*" +
                ".+?\\[(.+?)\\]\\s*" +
                ".+?\\[(.+?)\\]";

        Pattern patternVal = Pattern.compile(motifValeursItem);
        Matcher matcherVal = patternVal.matcher(item.infoToString());
        List<JTextField> champs = new ArrayList<>();
        if (matcherVal.find()) {
            for (int i = 1; i <= matcherVal.groupCount(); i++) {
                champs.add(new JTextField(matcherVal.group(i)));
                if (i==3){
                    champs.add(new JTextField("" + item.getQuantityInStock()));
                }
            }
        }
        return champs;
    }

    private void fenetreDeVisualisation(Item item){
        List<JTextField> champs = createChamps(item);
        List<JLabel> labels = createLabels(item);

        JFrame frame = new JFrame(champs.get(0).getText());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        for (int i=0 ; i<labels.size() ; i++){
            panel.add(labels.get(i));
            champs.get(i+1).setEditable(false);
            panel.add(champs.get(i+1));
        }

        JButton buttonOK = new JButton("OK");
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(buttonOK);
        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(350,350);
        frame.setVisible(true);

    }


    private JButton createViewButton() {
        JButton button = new JButton(new ImageIcon("icons/view.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //
                // TODO -- Ajoutez le code pour ouvrir le dialogue de visualisation d'un item
                //         ainsi que la gestion des erreurs possibles si nécessaire
                //
                 /* String motifValeursItem = "Catégorie\\s*\\[(.+?)\\]\\s*" +
                        "ID\\s*\\[(.+?)\\]\\s*" +
                        "Nom\\s*\\[(.+?)\\]\\s*" +
                        "Prix\\s*\\[(.+?)\\]\\s*" +
                        ".+?\\[(.+?)\\]\\s*" +
                        ".+?\\[(.+?)\\]";

                String motifAttributsItem = "\\](.*?)\\[";

                Pattern patternVal = Pattern.compile(motifValeursItem);
                Matcher matcherVal = patternVal.matcher(item.infoToString());
                Pattern patternAtb = Pattern.compile(motifAttributsItem);
                Matcher matcherAtb = patternAtb.matcher(item.infoToString());

                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(0, 2, 10, 10));
                JTextField valeur1, valeur2, valeur3, valeur4, valeur5, valeur6 ;

                int compteur = 0 ;
                if ( matcherVal.find()){
                    while (matcherAtb.find()){
                        compteur++ ;
                        switch (compteur){
                            case 1:
                                frame.setTitle(matcherVal.group(1));
                                panel.add(new JLabel(matcherAtb.group(1).trim()));
                                valeur1 = new JTextField(matcherVal.group(2));
                                valeur1.setEditable(false);
                                panel.add(valeur1);
                                break;
                            case 2:
                                panel.add(new JLabel(matcherAtb.group(1).trim()));
                                valeur2 = new JTextField(matcherVal.group(3));
                                valeur2.setEditable(false);
                                panel.add(valeur2);
                                break;
                            case 3:
                                panel.add(new JLabel(matcherAtb.group(1).trim()));
                                valeur3 = new JTextField(matcherVal.group(4));
                                valeur3.setEditable(false);
                                panel.add(valeur3);
                                panel.add(new JLabel("Quantité en stock"));
                                valeur4 = new JTextField("" + item.getQuantityInStock());
                                valeur4.setEditable(false);
                                panel.add(valeur4);
                                break;
                            case 4:
                                panel.add(new JLabel(matcherAtb.group(1).trim()));
                                valeur5 = new JTextField(matcherVal.group(5));
                                valeur5.setEditable(false);
                                panel.add(valeur5);
                                break;
                            case 5:
                                panel.add(new JLabel(matcherAtb.group(1).trim()));
                                valeur6 = new JTextField(matcherVal.group(6));
                                valeur6.setEditable(false);
                                panel.add(valeur6);
                                break;
                        }
                    }
                }

                JButton buttonOK = new JButton("OK");
                buttonOK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                panel.add(buttonOK);
                frame.add(panel);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(350,350);
                frame.setVisible(true); */

                fenetreDeVisualisation(item);
            }

        });

        return button;
    }

    private JButton createIncreaseButton() {
        JButton button = new JButton(new ImageIcon("icons/increase.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //
                // TODO -- Ajoutez le code nécessaire pour augmenter la quantité d'un item
                //         ainsi que la gestion des erreurs possibles si nécessaire
                //
            }
        });

        return button;
    }

    private JButton createDecreaseButton() {
        JButton button = new JButton(new ImageIcon("icons/decrease.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //
                // TODO -- Ajoutez le code nécessaire pour réduire la quantité ainsi que la gestion des
                //  erreurs et afficher un dialogue d'erreur si jamais on essaye d'aller en dessous de zéro
                //

            }
        });

        return button;
    }

    private JButton createEditButton() {
        JButton button = new JButton(new ImageIcon("icons/edit.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //
                // TODO -- Ajoutez le code pour ouvrir le dialogue d'édition d'un item
                //         ainsi que la gestion des erreurs possibles si nécessaire
                //

            }
        });

        return button;
    }

    private JButton createDeleteButton() {
        JButton button = new JButton(new ImageIcon("icons/delete.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item)itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            }
            else {
                //
                // TODO -- Ajoutez le code nécessaire pour supprimer un item ainsi que la gestion des
                //         erreurs pour afficher un dialogue d'erreur si jamais on essaye d'effacer un
                //         item qui n'existe pas
                //

            }
        });

        return button;
    }

    private JPanel createNewButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton newItemButton = new JButton(new ImageIcon("icons/new.png"));
        newItemButton.addActionListener(event -> {
            GUIItemChoiceDialog guiItemChoiceDialog = new GUIItemChoiceDialog(this);

            guiItemChoiceDialog.addComponentListener(new ComponentListener() {
                @Override
                public void componentResized(ComponentEvent e) { }

                @Override
                public void componentMoved(ComponentEvent e) { }

                @Override
                public void componentShown(ComponentEvent e) { }

                @Override
                public void componentHidden(ComponentEvent e) {
                    Category category = guiItemChoiceDialog.getChosenCategory();
                    //
                    // TODO -- Ajoutez le code nécessaire pour la création d'un nouvel item
                    //         ainsi que la gestion des erreurs possibles si nécessaire
                    //
                    //         Conseil: Vous pourriez ajouter un item avec des valeurs temporaires puis demander
                    //         à l'utilisateur de les remplacer dans le dialogue de modification d'item.
                    //

                }
            });

            guiItemChoiceDialog.setVisible(true);
        });

        newItemButton.setBorder(buttonNewBorder());
        buttonPanel.add(newItemButton);

        return buttonPanel;
    }

    private void showSelectErrorDialog() {

        showErrorDialog("SVP choisir un item");
    }

    private void showErrorDialog(String message) {
        GUIErrorDialog dialog = new GUIErrorDialog(this, message);
        dialog.setVisible(true);
    }

    private Border border() {

        return BorderFactory.createEmptyBorder(5, 10, 10, 10);
    }

    private Border titleBorder() {

        return BorderFactory.createEmptyBorder(5, 0, 10, 10);
    }

    private Border buttonNewBorder() {
        return BorderFactory.createEmptyBorder(5, 0, 0, 0);
    }

    private Border buttonBorder() {

        return BorderFactory.createEmptyBorder(0, 5, 10 , 5);
    }


}

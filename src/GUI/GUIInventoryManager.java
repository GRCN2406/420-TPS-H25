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

/**
 * Classe représentant l'interface graphique principale pour la gestion d'un inventaire d'items.
 * Elle permet d'afficher, créer, modifier, supprimer et ajuster les quantités d'items.
 */
public class GUIInventoryManager extends JFrame {
    private InventoryManager inventoryManager;
    private DefaultListModel<Item> itemsListModel;
    private JList itemsList;
    private int nextID;

    /**
     * Constructeur
     *
     * @param inventoryManager le gestionnaire d'inventaire à utiliser
     */
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
                JFrame frame = new JFrame();
                GUIItemDialog fenetre = new GUIItemDialog(frame, item, false);
                fenetre.setVisible(true);
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
                item.setQuantityInStock(item.getQuantityInStock() + 1);
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
                if (item.getQuantityInStock() > 0)
                    item.setQuantityInStock(item.getQuantityInStock() - 1);
                else
                    showErrorDialog("Quantité en stock : " + item.getQuantityInStock());
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
                JFrame frame = new JFrame();
                GUIItemDialog fenetre = new GUIItemDialog(frame, item, true);
                fenetre.setVisible(true);

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

                int index = - 1 ;
                for (int i = 0; i < inventoryManager.getArrayOfItems().length; i++) {
                    if(inventoryManager.getArrayOfItems()[i].getID() == item.getID() ){
                        index = i ;
                        break;
                    }
                }
                if (index != -1){
                    itemsListModel.remove(index);
                    inventoryManager.removeItem(item.getID());
                }else{
                    showErrorDialog("Item " + item.getID() + " introuvable");
                }
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
                    Item item = null ;
                        switch (category){
                            case Eggs:
                                item = new ItemEggs(nextID,"nouvel item à éditer" ,0,null,0) ;
                                inventoryManager.addNewEggsItem(nextID,"nouvel item à éditer" ,0,null,0);
                                break;
                            case Milk:
                                item = new ItemMilk(nextID,"nouvel item à éditer" ,0,0,0) ;
                                inventoryManager.addNewMilkItem(nextID,"nouvel item à éditer" ,0,0,0);
                                break;
                            case Bread:
                                item = new ItemBread(nextID,"nouvel item à éditer" ,0,null,0) ;
                                inventoryManager.addNewBreadItem(nextID,"nouvel item à éditer" ,0,null,0);
                                break;
                            default:
                                break;
                        }

                        itemsListModel.addElement(item);
                        nextID = getNextID();

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

    private int getNextID(){
        boolean existe ;
       do{
           existe = false ;
           nextID = (int)(Math.random()*250 + 1);
           for (int i = 0; i < inventoryManager.getArrayOfItems().length && !existe ; i++) {
               if (inventoryManager.getArrayOfItems()[i].getID() == nextID){
                   existe = true ;
               }
           }
       } while (existe) ;
       return nextID ;
    }
}

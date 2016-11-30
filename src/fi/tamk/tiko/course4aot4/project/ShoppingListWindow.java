package fi.tamk.tiko.course4aot4.project;

import fi.tamk.tiko.course4aot4.util.MyLinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Creates a window for the shopping list GUI.
 *
 * @author Eetu Kallio
 * @version 2.0
 * @since 2.0
 */
public class ShoppingListWindow extends JFrame {

    /**
     * Visual table of the shopping list.
     */
    private JTable listTable;

    /**
     * Bar for the menu.
     */
    private JMenuBar menuBar;

    /**
     * Menu for file options.
     */
    private JMenu fileMenu;

    /**
     * Menu item that saves the file.
     */
    private JMenuItem saveItem;

    /**
     * Menu item that opens the file.
     */
    private JMenuItem openItem;

    /**
     * Button for adding items to the shopping list.
     */
    private JButton addButton;

    /**
     * A field for added item name.
     */
    private JTextField addNameField;

    /**
     * A field for added item amount.
     */
    private JTextField addAmountField;

    /**
     * A panel holding the bottom content.
     */
    private JPanel bottomPanel;

    /**
     * A scroll panel for the table.
     */
    private JPanel midPanel;

    /**
     * Model for the table.
     */
    private DefaultTableModel tModel;

    /**
     * List to be used.
     */
    private MyLinkedList<ShoppingListItem> shoppingList;

    /**
     * Constructor for the class.
     */
    public ShoppingListWindow() {

        setTitle("Shopping List");
        setSize(400, 800);
        setLayout(new BorderLayout());
        tModel = new DefaultTableModel();
        listTable = new JTable(tModel);
        tModel.addColumn("Item");
        tModel.addColumn("Amount");
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        saveItem = new JMenuItem("Save");
        openItem = new JMenuItem("Open");
        addButton = new JButton("Add");
        addNameField = new JTextField();
        addAmountField = new JTextField();
        bottomPanel = new JPanel(new GridLayout(2, 3));
        midPanel = new JPanel(new GridLayout());
        addComponentsToWindow();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        shoppingList = new MyLinkedList<>();
    }

    /**
     * Adds all the components to the window.
     */
    private void addComponentsToWindow() {

        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        bottomPanel.add(new JLabel("Amount:"));
        bottomPanel.add(new JLabel("Item name:"));
        bottomPanel.add(new JLabel(""));
        bottomPanel.add(addAmountField);
        bottomPanel.add(addNameField);
        bottomPanel.add(addButton);
        add(bottomPanel, BorderLayout.SOUTH);
        listTable.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        midPanel.add(new JScrollPane(listTable));
        add(midPanel, BorderLayout.CENTER);
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        addButton.addActionListener(e -> {

            if (addAmountField.getText().trim().equals("") ||
                    addNameField.getText().trim().equals("")) {

                JOptionPane.showMessageDialog(null,
                        "Insert item name and amount!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                try {

                    String itemName = addNameField.getText();
                    int itemAmount = Integer.parseInt(addAmountField.getText());
                    boolean exists = false;

                    for (int j = 0; j < shoppingList.size(); j++) {

                        if (shoppingList.get(j).getItemName()
                                .equals(itemName)) {

                            shoppingList.get(j)
                                    .setItemAmount(shoppingList.get(j)
                                            .getItemAmount()+itemAmount);
                            exists = true;
                        }
                    }

                    if (!exists) {

                        shoppingList.add(new ShoppingListItem(itemAmount, itemName));
                        System.out.println("Added " + itemAmount +" " + itemName);
                    }

                    Object[][] data = new Object[shoppingList.size()][2];
                    String[] colNames = {"Name", "Amount"};

                    for (int i = 0; i < shoppingList.size(); i++) {

                        data[i][0] = shoppingList.get(i).getItemName();
                        data[i][1] = shoppingList.get(i).getItemAmount();
                    }

                    tModel.setDataVector(data, colNames);
                    listTable.setModel(tModel);
                    tModel.fireTableDataChanged();

                } catch (NumberFormatException ex){

                    JOptionPane.showMessageDialog(null,
                            "Amount must be in numbers!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

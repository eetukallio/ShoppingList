package fi.tamk.tiko.course4aot4.project;

import javax.swing.*;
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
     * Area for the text.
     */
    JTextArea textArea;

    /**
     * Bar for the menu.
     */
    JMenuBar menuBar;

    /**
     * Menu for file options.
     */
    JMenu fileMenu;

    /**
     * Menu item that saves the file.
     */
    JMenuItem saveItem;

    /**
     * Menu item that opens the file.
     */
    JMenuItem openItem;

    /**
     * Button for adding items to the shopping list.
     */
    JButton addButton;

    /**
     * A field for added item name.
     */
    JTextField addNameField;

    /**
     * A field for added item amount.
     */
    JTextField addAmountField;

    /**
     * Constructor for the class.
     */
    public ShoppingListWindow() {

        setTitle("Shopping List");
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        saveItem = new JMenuItem("Save");
        openItem = new JMenuItem("Open");
        addButton = new JButton("Add");
        addNameField = new JTextField();
        addAmountField = new JTextField();
    }

    /**
     * Adds all the components to the window.
     */
    private void addComponentsToWindow() {

        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        add(menuBar, BorderLayout.PAGE_START);
        add(addNameField, BorderLayout.LINE_START);
        add(addAmountField, BorderLayout.LINE_END);
        add(textArea, BorderLayout.PAGE_END);
    }
}

package fi.tamk.tiko.course4aot4.project;

import com.dropbox.core.*;
import fi.tamk.tiko.course4aot4.util.MyLinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Locale;

/**
 * Creates a window for the shopping list GUI.
 *
 * @author Eetu Kallio
 * @version 2.0
 * @since 2.0
 */
public class ShoppingListWindow extends JFrame{

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
     * Menu item that saves the file to Dropbox.
     */
    private JMenuItem saveToDropboxItem;

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
     * Dropbox app key.
     */
    final String APP_KEY = "zitwkamwtpvgcdb";

    /**
     * Dropbox app secret.
     */
    final String APP_SECRET = "ymdictrhrvoh1ca";

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
        saveToDropboxItem = new JMenuItem("Save To Dropbox");
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
        fileMenu.add(saveToDropboxItem);
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

                        shoppingList.add(new ShoppingListItem(itemAmount,
                                itemName));
                        System.out.println("Added " + itemAmount + " " +
                                itemName);
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
        saveItem.addActionListener(e -> {

            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(ShoppingListWindow.this);

            try{
                PrintWriter pw =
                        new PrintWriter(new BufferedWriter(new FileWriter(
                                fc.getSelectedFile() + ".txt")));

                for (int i = 0; i < shoppingList.size(); i++) {
                    pw.println(shoppingList.get(i).getItemAmount() + " "
                            + shoppingList.get(i).getItemName());
                }

                pw.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        });
        openItem.addActionListener(e -> {

            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(ShoppingListWindow.this);

            try (FileInputStream src = new FileInputStream(
                    fc.getSelectedFile())) {

                StringBuilder builder = new StringBuilder();
                BufferedReader br =
                        new BufferedReader
                                (new InputStreamReader(src,"UTF-8"));
                int c;

                while ((c = br.read()) != -1) {

                    builder.append((char)c);
                }

                String[] s = builder.toString().split("\n");

                shoppingList.clear();

                for (int i = 0; i < s.length ; i++) {

                    String[] tmp = s[i].split(" ");

                    if (!s[i].isEmpty()) {

                        shoppingList.add(new ShoppingListItem(
                                Integer.parseInt(tmp[0]), tmp[1]));
                    }
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
            } catch (IOException er) {
                er.printStackTrace();
            }
        });
        saveToDropboxItem.addActionListener(e -> {
            try {

                DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

                DbxRequestConfig config = new DbxRequestConfig(
                        "Shopping List - Eetu Kallio",
                        Locale.getDefault().toString());
                DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(
                        config, appInfo);
                String authString = (String)JOptionPane.showInputDialog(null,
                        "Visit: ", "DropBox Auth",
                        JOptionPane.INFORMATION_MESSAGE, null, null,
                        webAuth.start());
                DbxClient client;
                DbxAuthFinish authFinish = webAuth.finish(authString);
                String accessToken = authFinish.accessToken;
                client = new DbxClient(config, accessToken);
                File inputFile = new File("shopping-list.txt");
                PrintWriter pw =
                        new PrintWriter(new BufferedWriter(new FileWriter(
                                inputFile)));

                for (int i = 0; i < shoppingList.size(); i++) {

                    pw.println(shoppingList.get(i).getItemAmount() + " "
                            + shoppingList.get(i).getItemName());
                }

                FileInputStream inputStream = new FileInputStream(inputFile);
                pw.close();

                try {

                    DbxEntry.File uploadedFile = client.uploadFile(
                            "/shopping-list.txt",
                            DbxWriteMode.add(), inputFile.length(),
                            inputStream);
                    System.out.println("Uploaded: " + uploadedFile.toString());
                    JOptionPane.showMessageDialog(null, "Uploaded");
                } finally {
                    inputStream.close();
                }
            } catch (IOException | DbxException ioe) {
                ioe.printStackTrace();
            }
        });
    }
}

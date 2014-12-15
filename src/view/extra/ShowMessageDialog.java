package view.extra;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * @author Lockland
 */
public class ShowMessageDialog extends JOptionPane implements Serializable{    

    public static void error(Object message, String title) {
        showMessageDialog(null, message, title, ERROR_MESSAGE);
    }

    public static void success(Object message, String title) {
        showMessageDialog(null, message, title, PLAIN_MESSAGE);
    }

    public static int questionDialog(Object message, String title) {
        return showConfirmDialog(null, message, title, YES_NO_OPTION);
    }

}

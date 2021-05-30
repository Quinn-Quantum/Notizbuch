/**
 * @autor Maria
 * @Datum 30.05.2021
 */

import View.Deckblatt;

import javax.swing.*;

public class Aufschlagen {
    public static void main (String [] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                Deckblatt Deckblatt = new Deckblatt(); //Frame implimentieren
                Deckblatt.setVisible(true); //Frame öffnen
            }
        });
    }
}

/**
 * @Autor Maria
 * @Datum 30.05.2021
 */
package View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Class für das erste Frame
 * Auswahl zwischen neue und alte Notiz
 */

public class Deckblatt extends JFrame {
    //Variablen
    private JPanel root;
    private JLabel LabelDeck;
    private JButton alt;
    private JButton neu;

    /**
     * @Class Deckblatt: die funktionen
     */

    public Deckblatt (){
        add(root); //Panel ins Frame fügen
        setTitle("Notizbuch"); //Wie soll das Frame heißen
        setSize(400,500); //Größe des Frames
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Exit Butten hinzufügen

        /**
         *@Methode neu.addActionListener ist da für das sich das Frame für NeuNotizen öffnent
         */

        neu.addActionListener(new ActionListener() { //was Pasiert wenn auf Neue Notiz geklickt wird
            @Override
            public void actionPerformed(ActionEvent e) { //Frame für Neue Notiz wird geöffnet

                    NeuNotiz NeuNotiz = new NeuNotiz();
                    NeuNotiz.setVisible(true);
                }
        });
        /**
         * @Methode alt.addActionListener ist da für da das sich der Fart zu den Abgelegten Notizen öffnet
         */

        alt.addActionListener(new ActionListener() { //was Passiert wenn auf Alte Notiz geklickt wird
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser openFileChooser = new JFileChooser();
                openFileChooser.setCurrentDirectory(new File ("D:\\Java\\EigeneNotizen")); //Verzeichnis in dem die Notizen ligen zu weisen
                int request = openFileChooser.showOpenDialog(null);
                /**
                 *  @Variable request 0 ist wird der File in file gespeichert
                 * @Variable file enthält den Pointer zu ausgewählten Datei
                 */
                if (request == JFileChooser.APPROVE_OPTION){ //Verzeichnis öffnen

                    File file = new File(openFileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println (file);


                    try {
                        /**
                         * Sollte file existieren wirt die Datei geöffnet
                         * Ansonsten wirt in Terminal 0 ausgegeben
                         */
                        if (file.exists()){

                            Desktop.getDesktop().open(file); //Datei öffnen
                        }
                        else System.out.println("0");


                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }



                }


            }
        });
    }
}

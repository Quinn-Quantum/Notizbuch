/**
 * @autor Maria
 * @Datum 30.05.2021
 */

package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Calasse vür NeuNotizen
public class NeuNotiz extends JFrame {
    private JTextField textTitel;
    private JButton ok;
    private JLabel LabelTitel;
    private JLabel LabelInhalt;
    private JPanel NeuNot;
    private JTextPane textPane;

    public NeuNotiz (){
        add(NeuNot); //Pannel einfügen
        setTitle("Eine neue Notiz"); //Name des Frames
        setSize(1000,800); //Größe des Frames
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Exitbutten

        /**
         * @Methode für Speichen der Notiz
         */

        ok.addActionListener(new ActionListener() {
            @Override
            /**
             * @Methode actionPerformed über prüft ob der Titel der Notiz schon existiet und speichrt dan
             * oder übeschreibt die notiz mit "Datei existiert schon"
             */
            public void actionPerformed(ActionEvent e) {
                FileWriter notiez;
                //Speicher ort und lesen des Textes
                File datei = new File ("D:\\Java\\EigeneNotizen\\"+ textTitel.getText()+".txt" );
                if (datei.exists()){


                        textPane.setText("Datei existiert schon");


                    //System.exit(0);
                }else { //abspeichern
                    try {
                        notiez = new FileWriter(datei,true);
                        notiez.write (textPane.getText());
                        notiez.write(System.getProperty("line.separator"));

                        notiez.flush();
                        notiez.close();


                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.exit(0);

                }






            }
        });
    }
}

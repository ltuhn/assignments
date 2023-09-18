import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    static int rows, columns;
    static JButton[][] buttons;
    static boolean pressedButton;
    static JLabel exits;

    public static void main(String[] args) {
        JFrame window = new JFrame("Labyrint");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        window.add(panel);
        File file = openFile();
        try {
            Labyrint labyrinth = new Labyrint(file);
            rows = labyrinth.getRows();
            columns = labyrinth.getColumns();

            buttons = new JButton[rows][columns];
            JPanel grid = new JPanel();
            grid.setLayout(new GridLayout(rows, columns));
            exits = new JLabel("Antall utganger som ble funnet: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    JButton button = new JButton("");
                    button.setPreferredSize(new Dimension(24, 24));
                    button.addActionListener(new ButtonAction(i, j, labyrinth));
                    buttons[i][j] = button;
                    grid.add(button);
                }
            }

            update(labyrinth);
            panel.add(grid);
            panel.add(exits);
            window.setVisible(true);
            window.pack();
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
    }

    public static File openFile() {
        JFileChooser fileOpener = new JFileChooser();
        int result = fileOpener.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) System.exit(1);
        File file = fileOpener.getSelectedFile();
        
        return file;
    }

    // oppdaterer labyrinten slik at den ser ut som hvordan den skal se ut fra forste oppstart
    static void update(Labyrint labyrinth) {
        rows = labyrinth.getRows();
        columns = labyrinth.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (labyrinth.setColor(i, j)) buttons[i][j].setBackground(Color.PINK);
                else buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].setIcon(null);
            }
        }
    }

    static class ButtonAction implements ActionListener {
        int i, j;
        Labyrint labyrinth; 

        public ButtonAction(int i, int j, Labyrint labyrinth) {
            this.i = i;
            this.j = j;
            this.labyrinth = labyrinth;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Rute[][] labyrinth2DArray = labyrinth.getLabyrinth();

            if (!pressedButton) { // hvis det er forste gang brukeren har trykket paa knappen
                try {
                    labyrinth.findExit(j, i);
                    int exitsCount = 0;
                    for (ArrayList<Tuppel> coordinates : labyrinth.fullRoute) {
                        if (coordinates.get(0).getX() == i && coordinates.get(0).getY() == j) {
                            exitsCount++;
                            for (Tuppel xY : coordinates) {
                                int row = xY.getX();
                                int column = xY.getY();
                                buttons[row][column].setIcon(new ImageIcon("Kitty.png")); // hver knapp som leder til en bestemt utvei faar dette ikonet
                            }
                        }
                    }

                    exits.setText("Antall utganger som ble funnet: " + exitsCount);
                    pressedButton = true;
                } catch (FileNotFoundException error) {
                    System.out.println(error);
                }
            } else {
                update(labyrinth); // oppdaterer slik at forrige knapp som ble trykket paa, og folgende utvei gaar tilbake til originalt utseende
                try {
                    labyrinth.findExit(j, i);
                    int exitsCount = 0;
                    for (ArrayList<Tuppel> coordinates : labyrinth.fullRoute) {
                        if (coordinates.get(0).getX() == i && coordinates.get(0).getY() == j) {
                            exitsCount++;
                            for (Tuppel xY : coordinates) {
                                int row = xY.getX();
                                int column = xY.getY();
                                buttons[row][column].setIcon(new ImageIcon("Kitty.png")); // hver knapp som leder til en bestemt utvei faar dette ikonet
                            }
                        }
                    }
                    exits.setText("Antall utganger som ble funnet: " + exitsCount);
                } catch (FileNotFoundException error) {
                    System.exit(1);
                }  
            }
        }
    }
}
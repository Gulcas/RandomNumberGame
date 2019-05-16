import javax.swing.*;
import java.util.Random;

/**
 * Gra okienkowa, z wykorzystaniem JFrame user podaje liczbę 0 - 10 i sprawdza czy trafił w randomową liczbę
 */
public class RandomNumberGame {
    static int inputNumber; //zadeklarowane zmienne dostępne w całej klasie
    static int randomNumber;

    public static void main(String args[]) {

        JFrame jFrame = new JFrame();
        jFrame.setSize(300, 200); //rozmiar okna
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //domyślna akcja po kliknięciu przysiku OK

        JOptionPane.showMessageDialog(null, "Enter your number", "Enter number window"
                , JOptionPane.INFORMATION_MESSAGE); //utworzone okienko z informację

        randomNumber = new Random().nextInt(10) + 1; //generuję liczbę randomową

        Doit(); //wywołanie metody
    }


    public static void Doit() { //metoda zajmująca się logiką zadania
        int tries = 0;
        for (int i = 0; i < 10; i++) {
            tries++;
            inputNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter number please")); //konwertuję wpis usera na int

            //pętla dająca 10 szans na zgadnięcie randomowej liczby
            if (inputNumber == randomNumber) {
                JOptionPane.showMessageDialog(null, "Lucky guess", "Win!", JOptionPane.WARNING_MESSAGE);
                break;
            } else if (inputNumber > 10 || inputNumber < 1) {
                JOptionPane.showMessageDialog(null, "Number out of bounds: 0-10" + "\n" + "Try one more time!" + "\n" + (9 - i) + " chances left",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nope" + "\n" + "Try one more time!" + "\n" + (9 - i) + " chances left", "Bad guess", JOptionPane.ERROR_MESSAGE);
            }
        }
        //sprawdzenie if'em jaka była ilość prób i ustaienie odpowiedniej formy liczby mnogiej
        String chances;
        if (tries == 1) {
            chances = " chance.";
        } else {
            chances = " chances.";
        }

        //informacja podsumowująca grę: przypomnienie liczby randomowej oraz ilości prób
        JOptionPane.showMessageDialog(null, "END GAME" + "\n" + "Random number was: " +
                        randomNumber + "\n" + "You have used: " + tries + chances,
                "THE END", JOptionPane.INFORMATION_MESSAGE);
    }
}


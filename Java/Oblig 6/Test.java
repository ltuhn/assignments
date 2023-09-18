import java.io.FileNotFoundException;
import java.io.File;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Labyrint testlabyrint;
        try {
            File fil = new File("1.in");
            testlabyrint = new Labyrint(fil);

            // testlabyrint.finnUtveiFra(7, 5); // 5 FUNKER
            // testlabyrint.finnUtveiFra(1, 2); // 7 FUNKER
            // testlabyrint.finnUtveiFra(11, 17); // 4
            // testlabyrint.finnUtveiFra(6, 3); // 6 FUNKER
            testlabyrint.finnUtveiFra(1, 1); // 1 FUNKER
            // testlabyrint.finnUtveiFra(11, 7); // 3 FUNKER
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner readFile = new Scanner(new File("INPUT.TXT"));
             PrintWriter writeFile = new PrintWriter(new File("OUTPUT.TXT"))) {

            if (!readFile.hasNextInt()) return; // если следующий токен не является целым числом или данные закончились

            int kolCross = readFile.nextInt(); // Количество перекрестков
            int kolTunnel = readFile.nextInt(); // Количество тоннелей

            // Массив для хранения количества светофоров (индексация от 1 до N)
            int[] trafficLights = new int[kolCross + 1];

            // Считываем все тоннели и увеличиваем счетчики для обоих концов
            for (int k = 0; k < kolTunnel; k++) {
                int beginTunnel = readFile.nextInt();
                int endTunnel = readFile.nextInt();
                trafficLights[beginTunnel]++;
                trafficLights[endTunnel]++;
            }

            // Выводим результат через пробел
            for (int i = 1; i <= kolCross; i++) {
                writeFile.print(trafficLights[i]);
                if (i < kolCross) {
                    writeFile.print(" ");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}

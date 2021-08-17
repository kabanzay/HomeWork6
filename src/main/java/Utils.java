import java.io.*;
import java.util.*;

public class Utils {
    public static void getStatistic() {

        ArrayList<String> result = sortArray(parseFile());
        Map<String, Integer> number = new HashMap<>();
        for (String key : result) {
            number.put(key, 0);
        }
        for (String key : result) {
            if (number.containsKey(key)) {
                number.put(key, number.get(key) + 1);
            }
        }
        printUnique(number);
        printMax(number);
    }

    private static void printUnique(Map<String, Integer> number) {
        System.out.println("Уникальные слова с количеством повторов");
        for (Map.Entry<String, Integer> entry : number.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void printMax(Map<String, Integer> number) {
        Iterator<Integer> iterator = number.values().iterator();
        int max = 0;
        while (iterator.hasNext()) {
            int a = iterator.next();
            if (a > max) {
                max = a;
            }
        }
        System.out.println("Самые частые слова");
        for (Map.Entry<String, Integer> entry : number.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

    }

    private static String[] parseFile() {
        System.out.println("Введите название файла (text.txt)");
        String data = "";

        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            fileName = reader.readLine();

        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }

        try {

            Scanner in = new Scanner(new File(fileName));

            while (in.hasNext())
                // data - строка с исходным текстом
                data += in.nextLine() + " ";

            in.close();

        } catch (FileNotFoundException e) {

            System.out.println("Путь к файлу неверен!");
            System.exit(1);

        }

        //return data.toLowerCase().replaceAll("[^A-Za-zА-Яа-я]", " ").split("\\s+");
        // вариант просто по заданию
       return data.toLowerCase().split("\\s+");

    }

    private static ArrayList<String> sortArray(String[] dataArray) {
        ArrayList<String> result = new ArrayList<>();
        for (String temp : dataArray) {
            if (!(temp.equals("") || temp.equals("–"))) {
                result.add(temp);
            }
        }
        Collections.sort(result);
        for (String temp : result) {
            System.out.println(temp);
        }
        return result;
    }
}

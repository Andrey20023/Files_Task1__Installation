import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringBuffer strBuffer = new StringBuffer("Start of log:\n");
        List<String> listPath = Arrays.asList(
                "C:\\Games\\src", "C:\\Games\\res",
                "C:\\Games\\savegames", "C:\\Games\\temp",
                "C:\\Games\\src\\main", "C:\\Games\\src\\test",
                "C:\\Games\\res\\drawables", "C:\\Games\\res\\vectors",
                "C:\\Games\\res\\icons");
        for (String arr : listPath) {
            File nameDir = new File(arr);
            strBuffer.append(nameDir.mkdir() ? "Каталог " + arr + " создан.\n" : "Каталог " + arr + " не создан.\n");
        }

        strBuffer.append(
                myCreateNewFile("C:\\Games\\src\\main\\", "Main.java") +
                        myCreateNewFile("C:\\Games\\src\\main\\", "Utils.java") +
                        myCreateNewFile("C:\\Games\\temp\\", "temp.txt"));

        try (
                FileWriter writer = new FileWriter("C:\\Games\\temp\\temp.txt", true)) {
            writer.write(String.valueOf(strBuffer));
            writer.append("Еnd of log.\n");
            writer.flush();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static String myCreateNewFile(String path, String name) {
        File myFile = new File(path, name);
        try {
            return myFile.createNewFile() ? "Файл " + path + name + " создан.\n" : "Файл " + path + name + " не создан.\n";
        } catch (IOException ex) {
            return "Файл не создан, ошибка IOException: " + ex.getMessage() + "\n";
        }
    }
}

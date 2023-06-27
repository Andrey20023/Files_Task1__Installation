import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringBuffer strBuffer = new StringBuffer("Start of log:\n");
        myMkDir(strBuffer, "C:\\Games\\", "src");
        myMkDir(strBuffer, "C:\\Games\\", "res");
        myMkDir(strBuffer, "C:\\Games\\", "savegames");
        myMkDir(strBuffer, "C:\\Games\\", "temp");
        myMkDir(strBuffer, "C:\\Games\\src", "main");
        myMkDir(strBuffer, "C:\\Games\\src", "test");
        myCreateNewFile(strBuffer, "C:\\Games\\src\\main\\", "Main.java");
        myCreateNewFile(strBuffer, "C:\\Games\\src\\main\\", "Utils.java");
        myMkDir(strBuffer, "C:\\Games\\res\\", "drawables");
        myMkDir(strBuffer, "C:\\Games\\res\\", "vectors");
        myMkDir(strBuffer, "C:\\Games\\res\\", "icons");
        myCreateNewFile(strBuffer, "C:\\Games\\temp\\", "temp.txt");
        try (FileWriter writer = new FileWriter("C:\\Games\\temp\\temp.txt", true)) {
            String text = "Hello Gold!";
            writer.write(String.valueOf(strBuffer));
            writer.append("Еnd of log.\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void myMkDir(StringBuffer strBuffer, String path, String name) {
        File nameDir = new File(path, name);
        if (nameDir.mkdir()) {
            strBuffer.append("Каталог " + name + " создан.\n");
        } else {
            strBuffer.append("Каталог " + name + " не создан.\n");
        }
    }

    public static void myCreateNewFile(StringBuffer strBuffer, String path, String name) {
        File myFile = new File(path, name);
        try {
            if (myFile.createNewFile()) {
                strBuffer.append("Файл " + name + " создан.\n");
            } else {
                strBuffer.append("Файл " + name + " не создан.\n");
            }
        } catch (IOException ex) {
            strBuffer.append("Файл не создан, ошибка IOException: " + ex.getMessage() + "\n");
        }
    }
}

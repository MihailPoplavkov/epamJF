package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class FileWalker {
    public void printFileTree(File file) {
        printFileTree(file, "");
    }

    public void printFileTree(String fileName) {
        printFileTree(new File(fileName));
    }

    private void printFileTree(File file, String indent) {
        System.out.printf("%s%s%n", indent, file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printFileTree(f, indent + "  ");
                }
            }
        }
    }

    public boolean createFile(String fileName) {
        try {
            return new File(fileName).createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public boolean deleteFile(String fileName) {
        return new File(fileName).delete();
    }

    public boolean writeToFile(String fileName, String text) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(text.getBytes());
            return true;
        } catch (FileNotFoundException fnfe) {
            System.err.println("File is directory!");
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}

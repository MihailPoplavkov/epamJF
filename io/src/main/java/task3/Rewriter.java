package task3;

import java.io.*;

@SuppressWarnings("WeakerAccess")
public class Rewriter {
    public void rewrite(File utf8, File utf16) {
        try(Reader reader = new InputStreamReader(new FileInputStream(utf8), "UTF-8");
        Writer writer = new OutputStreamWriter(new FileOutputStream(utf16), "UTF-16LE")) {
            int c;
            while ((c = reader.read()) > 0) {
                writer.write(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rewrite(String input, String output) {
        rewrite(new File(input), new File(output));
    }
}

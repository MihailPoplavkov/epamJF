package task3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class Finder {
    private String str;

    public Finder(String path, Charset charset) throws IOException {
        str = readFile(path, charset);
    }

    public Finder(String path) throws IOException {
        this(path, Charset.forName("windows-1251"));
    }

    public List<String> getImgs() {
        Pattern pattern = Pattern.compile(".*(<img[^>]*>).*");
        return extractAll(pattern, 1);
    }

    public List<String> getReferences() {
        Pattern pattern = Pattern.compile("[А-ЯA-Z](([^.!?]*?)(ис((\\.)|(ун)))([^.!?]+?))+[.!?]");
        return extractAll(pattern, 0);
    }

    private List<String> extractAll(Pattern pattern, int group) {
        List<String> res = new ArrayList<>();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            res.add(matcher.group(group));
        }
        return res;
    }

    private static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}

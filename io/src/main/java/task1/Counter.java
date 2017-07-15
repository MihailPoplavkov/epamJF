package task1;

import lombok.SneakyThrows;

import java.io.*;
import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Counter {
    private static Set<String> keySet = new HashSet<>();

    static {
        keySet.addAll(Arrays.asList(
                "abstract",
                "assert",
                "boolean",
                "break",
                "byte",
                "case",
                "catch",
                "char",
                "class",
                "const",
                "continue",
                "default",
                "double",
                "do",
                "else",
                "enum",
                "extends",
                "final",
                "finally",
                "float",
                "for",
                "goto",
                "if",
                "implements",
                "import",
                "instanceof",
                "int",
                "interface",
                "long",
                "native",
                "new",
                "package",
                "private",
                "protected",
                "public",
                "return",
                "short",
                "static",
                "strictfp",
                "super",
                "switch",
                "synchronized",
                "this",
                "throw",
                "throws",
                "transient",
                "try",
                "void",
                "volatile",
                "while"
        ));
    }

    private InputStream input;
    private OutputStream output;

    public Counter(File inputFile, File outputFile) throws FileNotFoundException {
        input = new FileInputStream(inputFile);
        output = new FileOutputStream(outputFile);
    }

    public Counter(String inputFile, String outputFile) throws FileNotFoundException {
        this(new File(inputFile), new File(outputFile));
    }

    @SneakyThrows
    public void count() {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = input.read()) > 0) {
            if (i == ' ' || i == '\n' || i == '(' || i == ')') {
                String word = stringBuilder.toString();
                if (keySet.contains(word)) {
                    if (map.containsKey(word)) {
                        map.replace(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append((char)i);
            }
        }
        input.close();
        String word = stringBuilder.toString();
        if (keySet.contains(word)) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            output.write(String.format("%s %d%n", entry.getKey(), entry.getValue()).getBytes());
        }
        output.close();
    }
}

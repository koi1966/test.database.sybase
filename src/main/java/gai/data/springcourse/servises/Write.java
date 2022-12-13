package gai.data.springcourse.servises;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//https://marina-marchenko.com/java/zapis-v-tekstovyj-fajl-na-java/
public class Write {

    private String path_to_file;
    private boolean append = true;

    public Write (String path) {
        path_to_file = path;
    }

    public Write (String path, boolean value) {
        path_to_file = path;
        append = value;
    }

    public void fileWrite (String text) throws IOException {
        FileWriter write_to_file = new FileWriter(path_to_file, append);
        PrintWriter print = new PrintWriter(write_to_file);

        print.printf("%s" + "%n", text);

        print.close();
    }
}

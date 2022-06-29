package tddmicroexercises.textconvertor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class HtmlFile {

    public static final String PAGE_BREAK = "PAGE_BREAK";
    public static final int NEW_LINE_LENGTH = 1;
    private File f;

    public HtmlFile(String fileName) throws FileNotFoundException {
        this.f = new File(fileName);
    }

    public Stream<String> read() throws IOException {
        return this.f.read();
    }

    public String nextLine() throws IOException {
        return this.f.nextLine();
    }

    public void jumpTo(int page) throws IOException {
        int charToJumpTo = 0;
        int nbPage = 0;
        String line;
        while (nbPage < page && (line = this.f.nextLine()) != null) {
            if (line.contains(PAGE_BREAK)) {
                nbPage++;
            }
            charToJumpTo += line.length() + NEW_LINE_LENGTH;
        }
        this.f.jumpTo(charToJumpTo);
    }


}

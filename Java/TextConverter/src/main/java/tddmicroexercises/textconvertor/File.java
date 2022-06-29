package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class File implements Readable {
    private final String filename;
    private long readPointer = 0;
    private final BufferedReader buff;

    public File(String filename) throws FileNotFoundException {
        Paths.get(filename);
        this.filename = filename;
        this.buff = new BufferedReader(new FileReader(this.filename));
    }

    public Stream<String> read() throws IOException {
        Stream<String> output;
        Paths.get(filename);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filename));
        output = bufferedReader.lines();
        bufferedReader.close();
        return output;
    }

    public String nextLine() throws IOException {
        String nextLine = "";
        nextLine = buff.readLine();
        this.readPointer += nextLine.length() + 1;
        return nextLine;
    }

    public void jumpTo(int to) throws IOException {
        this.readPointer +=to;
    }
}

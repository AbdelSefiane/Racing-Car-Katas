package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.stream.Stream;

public interface Readable {

    public Stream<String> read() throws IOException;

    public String nextLine() throws IOException;

    public void jumpTo(int page) throws IOException;
}

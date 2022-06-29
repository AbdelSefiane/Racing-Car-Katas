package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class HtmlPagesConverterTest {

    public static final HtmlFile FILE;

    static {
        try {
            FILE = new HtmlFile("src/test/resources/reader_input_html_page");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getHtmlPageShouldPresentTheContentOfTheNthPage() throws IOException {
        HtmlFile file = FILE;
        assertEquals("4<br />5<br />", HtmlPagesConverter.getHtmlPage(file, 1));
    }

    @Test
    public void getHtmlPageShouldThrowExceptionOnNegatifInput() throws IOException {
        HtmlFile file = FILE;
        assertThrows(IllegalArgumentException.class, () -> HtmlPagesConverter.getHtmlPage(file, -1));
    }
}

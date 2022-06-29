package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class HtmlTextConverterTest {

    @Test
    public void convertToHtmlShouldConvertHtmlToText() throws IOException {
        HtmlFile file = new HtmlFile("src/test/resources/text_input_html_page.html");
        assertEquals(readFile("src/test/resources/text_output_html_page.html"), HtmlTextConverter.convertToHtml(file));
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder("");
        BufferedReader buff = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = buff.readLine())!= null){
            sb.append(line);
        }
        return sb.toString();
    }



}

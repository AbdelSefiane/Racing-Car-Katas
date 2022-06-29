package tddmicroexercises.textconvertor;

import java.io.IOException;

public class HtmlTextConverter {
    public static String convertToHtml(HtmlFile readable) throws IOException {
        final StringBuilder html = new StringBuilder();
        readable.read()
                .forEach(line -> html.append(StringEscapeUtils.escapeHtml(line))
                        .append("<br />"));
        return html.toString();

    }
}

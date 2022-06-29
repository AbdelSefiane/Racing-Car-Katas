package tddmicroexercises.textconvertor;

import java.io.IOException;

public class HtmlPagesConverter {


    public HtmlPagesConverter() {

    }

    public static String getHtmlPage(HtmlFile file, final int page) throws IOException {
        StringBuilder htmlPage = new StringBuilder();
        if (page < 0) {
            throw new IllegalArgumentException("Negatif Page Number Asked");
        }
        String line;
        file.jumpTo(page);
        while ((line = file.nextLine()) != null) {
            if (line.contains(HtmlFile.PAGE_BREAK)) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");

        }
        return htmlPage.toString();
    }

}

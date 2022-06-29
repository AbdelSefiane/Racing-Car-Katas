package tddmicroexercises.textconvertor;

class StringEscapeUtils {

    public static String escapeHtml(String input) {
        String output = input;
        output = output.replace("&", "&amp;");
        output = output.replace("ê","&ecirc;");
        output = output.replace("é","&eacute;");
        output = output.replace("à","&agrave;");
        output = output.replace("î","&icirc;");
        output = output.replace("«","&laquo;");
        output = output.replace("â","&acirc;");
        output = output.replace("»","&raquo;");
        output = output.replace("<", "&lt;");
        output = output.replace(">", "&gt;");
        output = output.replace("\"", "&quot;");
        output = output.replace("'", "&prime;");
        return output;
    }

}

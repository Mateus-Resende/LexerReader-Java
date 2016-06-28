package core;

/**
 * Melhoria ao trabalho de teoria de computacão para usar expressões regulares
 *
 * @author Mateus Resende
 */

class TokenReaderRegex {

    TokenReaderRegex() {

    }

    String read(String s) {
        return null;
    }

    private int getIdOccurs(String s) {
        // /\$[a-z]{1,}[\_\d\w]+/
        return 0;
    }

    private int getIntOccurs(String s) {
        // /((?<=[\=\+\-\%\&\*]|\s|^)\d+(?=[\=\+\-\%\&\*]|\s|$))/
        return 0;
    }

    private int getRealOccurs(String s) {
        // /(?<=[\=\+\-\%\&\*]|\s|^)(/\d+,\d+/)(?=[\=\+\-\%\&\*]|\s|$))/
        return 0;
    }

    private int getHexOccurs(String s) {
        // /[0-9A-F]+/
        return 0;
    }

    private int getStringOccurs(String s) {
        // /\".+\"/
        return 0;
    }

    private int getOpOccurs(String s) {
        // /[\=\+\-\%\&]/
        // /(\*{1,2})/
        return 0;
    }


}

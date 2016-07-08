package core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Melhoria ao trabalho de teoria de computacão para usar expressões regulares
 *
 * @author Mateus Resende
 */

class TokenReaderRegex {


    private static List<String> result;
    private Matcher matcher;
    private List<String> tokens;

    TokenReaderRegex() {
        tokens = new ArrayList<>();
        result = new ArrayList<>();


    }

    String read(String s) {
        return null;
    }

    private int getIdOccurs(String s) {
        return 0;
    }

    private int getIntOccurs(String s) {
        return 0;
    }

    private int getRealOccurs(String s) {
        return 0;
    }

    private int getHexOccurs(String s) {
        return 0;
    }

    private int getStringOccurs(String s) {
        return 0;
    }

    private int getOpOccurs(String s) {
        return 0;
    }


}

package core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Trabalho Prático de Matemática Discreta e Teoria da Computacão
 * <p>
 * Projeto para leitura de possíveis tokens dentro de uma string.
 * A implementacão foi feita através de um autômato utilizando 12
 * 13 estados possíveis. O mesmo está descrito no arquivo automato.jff
 *
 * @author Mateus A. M. Resende
 * @author Matheus G. Silva
 * @author Wilson Q. Rocha
 */
public class Lexer {

    private static List<Token> lex(String input) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (TokenType tokenType : TokenType.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            if (matcher.group(TokenType.ID.name()) != null) {
                tokens.add(new Token(TokenType.ID, matcher.group(TokenType.ID.name())));
                continue;
            } else if (matcher.group(TokenType.OP.name()) != null) {
                tokens.add(new Token(TokenType.OP, matcher.group(TokenType.OP.name())));
                continue;
            } else if (matcher.group(TokenType.NUM_REAL.name()) != null) {
                tokens.add(new Token(TokenType.NUM_REAL, matcher.group(TokenType.NUM_REAL.name())));
                continue;
            } else if (matcher.group(TokenType.NUM_HEX.name()) != null) {
                tokens.add(new Token(TokenType.NUM_HEX, matcher.group(TokenType.NUM_HEX.name())));
                continue;
            } else if (matcher.group(TokenType.NUM_INT.name()) != null) {
                tokens.add(new Token(TokenType.NUM_INT, matcher.group(TokenType.NUM_INT.name())));
                continue;
            } else if (matcher.group(TokenType.STRING.name()) != null) {
                tokens.add(new Token(TokenType.STRING, matcher.group(TokenType.STRING.name())));
                continue;
            }

        }
        return tokens;
    }

    public static void main(String[] args) throws Exception {
        String input = "& $asdf= * *$bla* ";

        List<Token> tokens = lex(input);
        tokens.forEach(token -> System.out.println(token));
    }

    private enum TokenType {
        ID("(?<=[=+\\-%&*]|\\s|^)(\\$[a-z]+[_\\d\\w]+)(?=[=\\+\\-%&\\*]|\\s|$)"),
        NUM_INT("(?<=[=+\\-%&*]|\\s|^)(\\d+)(?=[=\\+\\-%&\\*]|\\s|$)"),
        NUM_REAL("(?<=[=+\\-%&*]|\\s|^)(/\\d+,\\d+/)(?=[=\\+\\-%&\\*]|\\s|$)"),
        NUM_HEX("(?<=[=+\\-%&*]|\\s|^)([0-9A-F]+/)(?=[=\\+\\-%&\\*]|\\s|$)"),
        STRING("(?<=[=+\\-%&*]|\\s|^)(\".*\"/)(?=[=\\+\\-%&\\*]|\\s|$)"),
        OP("(?<=.)([=\\+\\-%&]|(\\*{1,2}))(?=.)");
        public final String pattern;

        TokenType(String pattern) {
            this.pattern = pattern;
        }
    }

    private static class Token {
        TokenType type;
        String data;

        public Token(TokenType type, String data) {
            this.type = type;
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("(%s %s)", type.name(), data);
        }
    }


}

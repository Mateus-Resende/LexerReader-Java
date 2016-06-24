package core;

import Exceptions.CharacterNotMappedException;
import Exceptions.StringNotClosedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe com implementacão dos possíveis estados do autômato
 *
 * @author Mateus A. M. Resende
 * @author Matheus G. Silva
 * @author Wilson Q. Rocha
 */
public class TokenReader {

    /**
     * Variável para retorno dos resultados
     */
    private List<String> results = null;

    public TokenReader() {
        results = new ArrayList<>();
    }

    /**
     * Classe de leitura e identificacão dos possíveis tokens
     *
     * @param input, string do usuário
     * @return string contendo os tokens encontrados
     * @throws CharacterNotMappedException caso o caractere não tenha sido mapeado
     * @throws StringNotClosedException caso exista uma cadeia de caracteres não fechada
     */
    public String read(String input) throws CharacterNotMappedException, StringNotClosedException {
        int pos = 0;
        int state = 0;
        input += " ";

        while (input.length() > pos) {
            Character c = input.charAt(pos);

            switch (state) {
                // estado inicial de leitura
                case 0:
                    if (c.equals('$')) {
                        state = 1;
                    } else if ("0123456789".contains(c.toString())) {
                        state = 3;
                    } else if ("ABCDEF".contains(c.toString())) {
                        state = 6;
                    } else if (c.equals('"')) {
                        state = 7;
                    } else if (isOperator(c)) {
                        state = 9;
                    } else if (c.equals('*')) {
                        state = 10;
                    } else if (c.equals(' ')) {
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // após entrada de $, é necessário que o próximo caractere seja uma letra
                case 1:
                    if (Character.isLetter(c)) {
                        state = 2;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // estado final de ID
                case 2:
                    if (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
                        state = 2;
                    } else if (c.equals(' ')) {
                        results.add("ID");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // estado final de número inteiro ou estado temporário para número real/hexa
                case 3:
                    if (c.equals(',')) {
                        state = 4;
                    } else if ("ABCDEF".contains(c.toString())) {
                        state = 6;
                    } else if (Character.isDigit(c)) {
                        state = 3;
                    } else if (c.equals(' ')) {
                        results.add("NumInt");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // após a vírgula, é necessário vir um dígito para validacão de número real
                case 4:
                    if (Character.isDigit(c)) {
                        state = 5;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // estado final de número real
                case 5:
                    if (Character.isDigit(c)) {
                        state = 5;
                        pos++;
                    } else {
                        results.add("NumReal");
                        state = 0;
                    }
                    break;

                // estado final de número hexadecimal
                case 6:
                    if (isHexadecimal(c)) {
                        state = 6;
                    } else if (c.equals(' ')) {
                        results.add("NumHex");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                // processamento de cadeia de caracteres até aspas duplas
                case 7:
                    if (!c.equals('"') || c.equals(' ')) {
                        if (input.length() <= pos + 1) {
                            throw new StringNotClosedException(pos);
                        } else {
                            state = 7;
                            pos++;
                        }
                    } else {
                        state = 8;
                    }
                    break;

                // estado final da cadeia de caracteres
                case 8:
                    if (c.equals('"')) {
                        results.add("Cadeia");
                        state = 0;
                        pos++;
                    } else {
                        throw new StringNotClosedException(pos);
                    }
                    break;

                // estado final de operador, com excessão de * e **
                case 9:
                    results.add("Op");
                    state = 0;
                    break;

                // estado final de operador *
                case 10:
                    if (c.equals('*')) {
                        state = 11;
                    } else {
                        results.add("Op");
                        state = 0;
                    }
                    pos++;
                    break;

                // estado final de operador **
                case 11:
                    results.add("Op");
                    state = 0;
                    pos++;
                    break;

                default:
                    throw new CharacterNotMappedException(pos);
            }
        }

        return results.toString();
    }

    /**
     * Verificacão se o caractere é um operador
     * @param c char a ser avaliado
     * @return true em caso de operador, falso caso contrário
     */
    private boolean isOperator(Character c) {
        return ("+-/%&|=").contains(c.toString());
    }

    /**
     * Verificacão se o caractere pode ser um Hexadecimal
     * @param c char a ser avaliado
     * @return true em caso de hexadecimal, falso caso contrário
     */
    private boolean isHexadecimal(Character c) {
        return ("ABCDEF").contains(c.toString()) || Character.isDigit(c);
    }
}

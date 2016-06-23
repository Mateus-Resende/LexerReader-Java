package core;

import Exceptions.CharacterNotMappedException;
import Exceptions.StringNotClosedException;

import java.util.ArrayList;
import java.util.List;


public class TokenReader {

    private List<String> results = null;

    public TokenReader() {
        results = new ArrayList<>();
    }

    public String read(String input) throws CharacterNotMappedException, StringNotClosedException {
        int pos = 0;
        int state = 0;
        input += " ";

        while (input.length() > pos) {
            Character c = input.charAt(pos);

            switch (state) {

                case 0:
                    if (c.equals('$')) {
                        state = 1;
                    } else if ("0123456789".contains(c.toString())) {
                        state = 4;
                    } else if ("+=-&%/|".contains(c.toString())) {
                        state = 10;
                    } else if (c.equals('*')) {
                        state = 11;
                        pos++;
                    } else if (c.equals('"')) {
                        state = 8;
                        pos++;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                case 1:
                    if (Character.isLetter(c)) {
                        state = 2;
                        pos++;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                case 2:
                    if (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
                        state = 3;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;

                    break;

                case 3:
                    if (Character.isDigit(c) || Character.isLetter(c) || c.equals('_')) {
                        state = 3;
                    } else if (!("+=-&%/|".contains(c.toString()))) {
                        results.add("ID");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                case 4:
                    if (c.equals(',')) {
                        state = 5;
                    } else if ("ABCDEF".contains(c.toString())) {
                        state = 7;
                    } else if (Character.isDigit(c)) {
                        state = 4;
                    } else if (c.equals(' ')) {
                        results.add("NumInt");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                case 5:
                    if (Character.isDigit(c)) {
                        state = 6;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;

                    break;

                case 6:
                    if (Character.isDigit(c)) {
                        state = 6;
                    } else if (c.equals(' ')) {
                        results.add("NumReal");
                        state = 0;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    pos++;
                    break;

                case 7:
                    if ("ABCDEF".contains(c.toString()) || Character.isDigit(c)) {
                        state = 7;
                        pos++;
                    } else if (c.equals(' ')) {
                        results.add("NumHex");
                        state = 0;
                        pos++;
                    } else {
                        throw new CharacterNotMappedException(pos);
                    }
                    break;

                case 8:
                    if (!c.equals('"')) {
                        state = 8;
                        pos++;
                    } else {
                        state = 9;
                    }
                    break;

                case 9:
                    if (c.equals('"')) {
                        results.add("Cadeia");
                        state = 0;
                        pos++;
                    } else {
                        throw new StringNotClosedException(pos);
                    }
                    break;

                case 10:
                    results.add("Op");
                    state = 0;
                    pos++;
                    break;

                case 11:
                    if (pos + 1 < input.length()) {
                        Character cNext = input.charAt(pos + 1);
                        if (cNext.equals('*')) {
                            state = 0;
                            pos += 2;
                            results.add("Op");
                        } else {
                            state = 0;
                            pos++;
                        }
                    } else {
                        state = 0;
                        pos++;
                        results.add("Op");
                    }
                    break;

                default:
                    throw new CharacterNotMappedException(pos);
            }
        }

        return results.toString();
    }
}

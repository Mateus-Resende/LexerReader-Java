package core;

import java.util.ArrayList;
import java.util.List;

public class TokenReader {

    private List<String> results = null;

    public TokenReader() {
        results = new ArrayList<String>();
    }

    public String read(String input) {
        int pos = 0;
        int state = 0;
        input += " ";

        while(input.length() > pos ) {
            Character c = input.charAt(pos);
            System.out.println("Read input at " + pos + ": " + c);

            switch (state) {

                case 0:
                    System.out.println("state 0");
                    if (c.equals('$')) {
                        state = 1;
                        pos++;

                    } else if ("+=-&%/|".contains(c.toString())) {
                        state = 10;
                        pos++;
                	} else if (c.equals('*')) {
                        state = 11;
                        pos++;
                    } else {
                        pos++;
                    }
                	break;

                case 1:
                    if (Character.isLetter(c)) {
                        state = 2;
                        pos++;
                    } else {
                        state = 13;
                    }
                    break;

                case 2:
                    if (Character.isLetter(c) || Character.isDigit(c) || c.equals('_')) {
                        state = 3;
                        pos++;
                    } else {
                        state = 13;
                    }
                    break;

                case 3:
                    if (Character.isDigit(c) || Character.isLetter(c) || c.equals('_')) {
                        state = 3;
                        pos++;
                    } else {
                        results.add("ID");
                        state = 0;
                        pos++;
                    }
                    break;
                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
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
                        }
                    } else {
                        state = 0;
                        pos++;
                        results.add("Op");
                    }
                    break;

                case 12:
                    break;

                default:
                    return "Error on position: " + pos;
            }
        }

        return results.toString();
    }
}

package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mresende on 21/06/16.
 */
public class TokenReader {

    private List<Token> results = null;

    public TokenReader() {
        results = new ArrayList<Token>();
    }

    public String read(String input) {
        int pos = 0;
        int state = 0;
        
        while(input.length() < pos ) {
            Character c = input.charAt(pos);
            switch (state) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: 
                		if(Character.isDigit(c)){
                			state = 4;
                			//results.add(Token.NumInt);
                		} else if (c.equals("")){
                			state = 0;
                		}else if (c.equals(",")){
                			state = 5;
                		}
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
                		if(Character.)
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default:
                    break;
            }
            pos++;
        }
        return null;
    }
}

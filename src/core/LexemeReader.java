package core;

import Exceptions.CharacterNotMappedException;
import Exceptions.StringNotClosedException;


public class LexemeReader {

    public static void main(String[] args) throws Exception {
        TokenReader t = new TokenReader();

        try {
            System.out.println(t.read("'& $asdf = * ** \"tudo+/-0certo\""));
        } catch (CharacterNotMappedException e) {
            System.out.println(e.getMessage());

        } catch (StringNotClosedException a) {
            System.out.println(a.getMessage());
        }
    }

}

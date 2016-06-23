package core;

public class LexemeReader {

    public static void main(String[] args) {
        TokenReader t = new TokenReader();

        System.out.println(t.read("1234 14234AF FA12394BC *"));
    }

}

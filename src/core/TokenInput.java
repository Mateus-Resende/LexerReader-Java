package core;

import Exceptions.CharacterNotMappedException;
import Exceptions.StringNotClosedException;

/**
 * Trabalho Prático de Matemática Discreta e Teoria da Computacão
 *
 * Projeto para leitura de possíveis tokens dentro de uma string.
 * A implementacão foi feita através de um autômato utilizando 12
 * 13 estados possíveis. O mesmo está descrito no arquivo automato.jff
 *
 * @author Mateus A. M. Resende
 * @author Matheus G. Silva
 * @author Wilson Q. Rocha
 */
public class TokenInput {
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

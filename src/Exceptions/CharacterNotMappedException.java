package Exceptions;

/**
 * @author Mateus A. M. Resende
 * @author Matheus G. Silva
 * @author Wilson Q. Rocha
 */
public class CharacterNotMappedException extends Exception {
    private String msg = null;

    /**
     * Construtor da excecão de caractere não mapeado
     * @param Index, contendo a posicao do erro
     */
    public CharacterNotMappedException(int Index) {
        super();
        msg = "Erro encontrado na posicaoo [ " + Index + " ] Caractere Desconhecido!";
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

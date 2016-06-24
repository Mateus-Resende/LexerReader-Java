package Exceptions;

/**
 * @author Mateus A. M. Resende
 * @author Matheus G. Silva
 * @author Wilson Q. Rocha
 */
public class StringNotClosedException extends Exception {
    private String msg = null;

    /**
     * Construtor da excecão de cadeia incompleta
     * @param Index, contendo a posicao do erro
     */
    public StringNotClosedException(int Index) {
        super();
        msg = "Erro encontrado na posicao [ " + Index + " ] Cadeia Nao Fechada!";
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

package Exceptions;

public class StringNotClosedException extends Exception {
    private String msg = null;

    public StringNotClosedException(int Index) {
        super();
        msg = "Erro encontrado na posicao [ " + Index + " ] Cadeia Nao Fechada!";
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

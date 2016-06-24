package Exceptions;

public class CharacterNotMappedException extends Exception {
    private String msg = null;

    public CharacterNotMappedException(int Index) {
        super();
        msg = "Erro encontrado na posicaoo [ " + Index + " ] Caractere Desconhecido!";
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

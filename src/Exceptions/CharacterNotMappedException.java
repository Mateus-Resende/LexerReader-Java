package Exceptions;

public class CharacterNotMappedException extends Exception {
    private String CaractereDesconhecido = "Caractere Desconhecido!";
    private String msg = null;

    public CharacterNotMappedException(int Index) {
        super();
        msg = "Erro encontrado na posicaoo [ " + Index + " ] " + CaractereDesconhecido;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

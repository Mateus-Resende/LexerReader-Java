package Exceptions;

public class CharacterNotMappedException extends Exception {
	private String CaractereDesconhecido = "Caractere Desconhecido!";
	private String msg=null;
	
    public CharacterNotMappedException() {
        System.out.println("ERRO: ");
    }

    public CharacterNotMappedException(int Index) {
        super();
        msg = "Erro encontrado na posição [ " + Index + " ] " + CaractereDesconhecido;
    }
    
    public String getMessage(String mensagem){   	
    	return msg; 
    }
}

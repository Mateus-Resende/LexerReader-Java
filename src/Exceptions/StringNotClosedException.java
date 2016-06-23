package Exceptions;

public class StringNotClosedException extends Exception {
	private String CadeiaNaoFechada = "Cadeia Nao Fechada!";
	private String msg = null;

    public StringNotClosedException(int Index) {
        super();
        msg = "Erro encontrado na posicao [ " + Index + " ] " + CadeiaNaoFechada;
    }

    @Override
    public String getMessage(){
    	return msg; 
    }
	
}

package Exceptions;

public class StringNotClosedException extends Exception {
	private String CadeiaNaoFechada = "Cadeia Não Fechada!";
	private String msg = null;
	
	
    public StringNotClosedException() {
        System.out.println("ERRO: ");
        
    }
    

    public StringNotClosedException(int Index) {
        super();
        msg = "Erro encontrado na posição [ " + Index + " ] " + CadeiaNaoFechada;        
    }
    
    public String getMessage(String string){
    	
    	return msg; 
    }
	
}

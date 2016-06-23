package Exceptions;

public class StringNotClosedException extends Exception {
	private String CadeiaNaoFechada = "Cadeia N�o Fechada!";
	private String msg = null;
	
	
    public StringNotClosedException() {
        System.out.println("ERRO: ");
        
    }
    

    public StringNotClosedException(int Index) {
        super();
        msg = "Erro encontrado na posi��o [ " + Index + " ] " + CadeiaNaoFechada;        
    }
    
    public String getMessage(String string){
    	
    	return msg; 
    }
	
}

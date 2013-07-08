package aula8;

public class Factory {
	
	public static double soma(double op1, double op2){
		return new Adicao(op1,op2).doOp();
	}
	
	public static double subtraccao(double op1, double op2){
		return new Subtraccao(op1,op2).doOp();
	}
	
	public static double divisao(double op1, double op2){
		return new Divisao(op1,op2).doOp();
	}
	
	public static double multiplicacao(double op1, double op2){
		return new Multiplicacao(op1, op2).doOp();
	}
	
	public static double sqr(double op1){
		return new SQR(op1).doOp();
	}
	
	public static double sqrt(double op1){
		return new SQRT(op1).doOp();
	}
}

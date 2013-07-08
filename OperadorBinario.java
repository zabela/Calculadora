package aula8;

public abstract class OperadorBinario extends Operador {
	
	private double op1;
	private double op2;
	public abstract double doOp();
	
	public OperadorBinario(double op1, double op2){
		this.op1=op1;
		this.op2=op2;
	}

	public double getOp1(){
		return this.op1;
	}
	
	public double getOp2(){
		return this.op2;
	}
}

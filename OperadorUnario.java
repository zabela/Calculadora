package aula8;

public abstract class OperadorUnario extends Operador {
	
	private double op;
	public abstract double doOp();
	
	public OperadorUnario(double op){
		this.op=op;
	}

	public double getOp(){
		return op;
	}

}


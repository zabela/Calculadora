package aula8;

public class Divisao extends OperadorBinario {
	
	private double res=0;

	protected Divisao(double op1,double op2){
		super(op1,op2);
	}

	public double doOp(){
		this.res=super.getOp1()/super.getOp2();
		return this.res;
	}
}

package aula8;

public class Adicao extends OperadorBinario {
	
	private double res=0;

	public Adicao(double op1,double op2){
		super(op1,op2);
	}

	public double doOp(){
		this.res=super.getOp1()+super.getOp2();
		return this.res;
	}
}


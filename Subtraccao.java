package aula8;

public class Subtraccao extends OperadorBinario{

	private double res=0;

	public Subtraccao(double op1,double op2){
		super(op1,op2);
	}

	public double doOp(){
		this.res=super.getOp1()-super.getOp2();
		return this.res;
	}
}

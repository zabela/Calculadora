package aula8;

public class SQRT extends OperadorUnario {

	private double res=0;

	public SQRT(double op1){
		super(op1);
	}

	public double doOp(){
		this.res=Math.sqrt(super.getOp());
		return this.res;
	}
}

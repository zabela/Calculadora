package aula8;

public class SQR extends OperadorUnario{

	private double res=0;

	public SQR(double op1){
		super(op1);
	}

	public double doOp(){
		this.res=Math.pow(super.getOp(),2);
		return this.res;
	}
}

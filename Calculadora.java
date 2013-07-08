package aula8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora {
	
	private JFrame base;
	private JPanel painel1;
	private JPanel painel2;
	private JToggleButton botoes[];
	private JTextField visor;
	private double result;
	private double op1;
	private double op2;
	private boolean inicio;
	private boolean err;
	private boolean opSet;
	private int opVal;
	private String show;
	private boolean div0;

	public Calculadora(){
		start();
	}
	
	private void reset(){
		show="";
		result=0;
		op1=0;
		op2=0;
		opVal=0;
		inicio=true;
		err=false;
		opSet=false;
		div0=false;
	}

	private void start(){
		reset();
		
		base=new JFrame(" Calculadora ");
		base.setSize(400,250);
		base.setLocation(450,250);
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		visor=new JTextField("0");
		visor.setHorizontalAlignment(JTextField.RIGHT);
		visor.setBackground(Color.white);
		visor.setFont(new Font("Lucida Sans Unicode",Font.BOLD,22));
		visor.setEditable(false);
		
		painel1=new JPanel();
		painel1.setLayout(new BorderLayout());
		
		painel2=new JPanel();
		painel2.setLayout(new GridLayout(5,4));
		
		painel1.add(visor, java.awt.BorderLayout.NORTH);
		painel1.add(painel2, java.awt.BorderLayout.CENTER);

		botoes=new JToggleButton[20];
		botoes[0]=new JToggleButton("0");  	    // pos 12
		
		botoes[1]=new JToggleButton("1");		// pos 8
		botoes[2]=new JToggleButton("2");		// pos 9
		botoes[3]=new JToggleButton("3"); 		// pos 10
		
		botoes[4]=new JToggleButton("4");		// pos 4
		botoes[5]=new JToggleButton("5"); 		// pos 5
		botoes[6]=new JToggleButton("6"); 		// pos 6
		
		botoes[7]=new JToggleButton("7"); 		// pos 0
		botoes[8]=new JToggleButton("8");		// pos 1
		botoes[9]=new JToggleButton("9"); 		// pos 2
		botoes[10]=new JToggleButton("/"); 		// pos 3
		
		botoes[11]=new JToggleButton("-");      // pos 11
		
		botoes[12]=new JToggleButton("*");		// pos 7
		
		botoes[13]=new JToggleButton(".");		// pos 13
		botoes[14]=new JToggleButton("=");		// pos 14
		botoes[15]=new JToggleButton("+");		// pos 15
		botoes[16]=new JToggleButton("+/-");	// pos 16
		botoes[17]=new JToggleButton("SQR");	// pos 17
		botoes[18]=new JToggleButton("SQRT");	// pos 18
		botoes[19]=new JToggleButton("RESET");	// pos 19

		for(int i=0;i<20;i++){
			botoes[i].setFont(new Font("Lucida Sans Unicode",Font.BOLD,16));
			botoes[i].addActionListener(new EventoListener());
		}
		
		for(int i=7;i<11;i++)	
			painel2.add(botoes[i]);
			
		for(int i=4;i<7;i++)	
			painel2.add(botoes[i]);
		
		painel2.add(botoes[12]);
		
		for(int i=1;i<4;i++)	
			painel2.add(botoes[i]);
			
		painel2.add(botoes[11]);
		painel2.add(botoes[0]);
		
		for(int i=13;i<20;i++)	
			painel2.add(botoes[i]);
		
		base.getContentPane().add(painel1);
		base.setVisible(true);
	}
	
	class EventoListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JToggleButton)
				doOp((JToggleButton)e.getSource());
		}
	}

	private void doOp(JToggleButton botao){
		botao.setSelected(false);
		int pos=-1;

		for(int i=0;i<20 && pos==-1;i++){
			if(botoes[i]==botao)
				pos=i;
		}

		if(err!=true){
			
			for(int i=0;i<10;i++){
				if(pos==i){
					show=show+pos;
					visor.setText(show);
					if(inicio==true){
						op1=Double.parseDouble(show);
					}else{
						op2=Double.parseDouble(show);
					}
				}
			}
			
			if(pos!=0 && pos!=1 && pos!=2 && pos!=3 && pos!=4 && pos!=5 && pos!=6 && pos!=7 && pos!=8 && pos!=9 && pos!=13){
				if(opSet==true){ 
					result=trocaOp();
					op1=result;
					opSet=false;
				}
			}
			
			if(pos==10){ // /
				opVal=10;
				if(inicio==true){
					show=""+op1;
					visor.setText(show);
					show="";
				}else{
					show=""+result;
					visor.setText(show);
					show="";
				}
				opSet=true;
				inicio=false;
				op2=op1;
			}
			
			if(pos==12){ // *
				opVal=12;
				if(inicio==true){
					show=""+op1;
					visor.setText(show);
					show="";
				}else{
					show=""+result;
					visor.setText(show);
					show="";
				}
				opSet=true;
				inicio=false;
				op2=op1;
			}
			
			if(pos==11){ // -
				opVal=11;
				if(inicio==true){
					show=""+op1;
					visor.setText(show);
					show="";
				}else{
					show=""+result;
					visor.setText(show);
					show="";
				}
				opSet=true;
				inicio=false;
				op2=op1;
			}
			
			if(pos==15) { // +
				opVal=15;
				if(inicio==true){
					show=""+op1;
					visor.setText(show);
					show="";
				}else{
					show=""+result;
					visor.setText(show);
					show="";
				}
				opSet=true;
				inicio=false;
				op2=op1;
			}
			
			if(pos==17){ // SQT
				op1=Factory.sqr(op1);
				show=""+op1;
				visor.setText(show);
			}
			
			if(pos==18){ // SQRT
				op1=Factory.sqrt(op1);
				show=""+op1;
				if(Double.isNaN(op1)){
					visor.setText("ERRO: radicando negativo.");
					err=true;		
				}else{
					visor.setText(show);
				}
			}
			
			if(pos==16){ // +/-
				op1=-op1;
				show=""+op1;
				visor.setText(show);
			}
			
			if(pos==13){ // .
				show=show+".";
				visor.setText(show);
			}
			
			if(pos==14){ // =
				show=""+op1;
				visor.setText(show);
				show="";
				restart();
			}
		}
		
		if(div0==true){
			visor.setText("ERRO: divisor zero.");
		}	
		
		if (pos==19){ // RESET
			reset();
			visor.setText("0");
		}
	}
	
	private void restart(){
		show="";
		opVal=0;
		inicio=true;
		opSet=false;
	}
	
	public double trocaOp(){
		switch(opVal){
		case 10:
			if(Double.isInfinite(Factory.divisao(op1, op2))){
				err=true;
				div0=true;
			}
			return Factory.divisao(op1, op2);
		case 12: return Factory.multiplicacao(op1, op2);
		case 11: return Factory.subtraccao(op1, op2);
		case 15: return Factory.soma(op1, op2);
		}
		return 0;
	}

	public static void main(String[] args){
		new Calculadora();
	}
}		 
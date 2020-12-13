package main;

import java.util.Random;

public class Cromossomo {
    protected int pertinencia[];
    private double peso=0;
    private double valor=0;
    MochilaObjetos objeto;
    public Cromossomo(MochilaObjetos objeto1) {
    	Random x;
    	objeto = objeto1; 
    	pertinencia = new int[20];
  	    for (int i = 0; i < 20; i++) {
			x= new Random();                  //vetor do tipo inteiro pertinencia é preenchido aleatoriamente com 1 ou 0;
			pertinencia[i]=x.nextInt(2);
		}
    	peso = objeto.incrementaPeso(objeto.objetos, this);
    	valor = objeto.incrementaValor(objeto.objetos, this);
    	if(this.peso>15) {          //peso e valor de cromossomo são preenchidos com base nos metodos incrementaPeso e incrementaValor
    		this.valor = 0;      //caso o peso do cromossomo seja maior que 15 o valor do cromossomo será zerado
    	}
    	
    	
    }
    public double getPeso() {
		return peso;
	}
    public void setPeso(double peso) {
		this.peso = peso;
	}
	  public double getValor() {
			return valor;
		}
	  public void setValor(double valor) {
			this.valor = valor;
		}

}

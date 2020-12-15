package main;

import java.util.ArrayList;
import java.util.Random;

public class Main {
      public static void main (String[] args) {
    	  Objeto objeto;
    	  Random x,y;
    	  double c=0;
    	  ArrayList<Objeto> objetos = new ArrayList<Objeto>(); 
    	  ArrayList<Objeto> objetosfinal =  new ArrayList<Objeto>();
    	  for (int i = 0; i < 20; i++) {
    		x = new Random();
    		y = new Random();
			objeto = new Objeto((double)x.nextInt(6),(double)y.nextInt(6)); //Array de objetos � preenchido randomicamente com pesos e valores de 0 a 6;
			objetos.add(objeto);
		}
    	  System.out.println("Todos os Objetos disponiveis");
    	  for (int i = 0; i < objetos.size(); i++) {                             
    		  System.out.println("Peso: "+objetos.get(i).getPeso()+"Valor: "+objetos.get(i).getValor()); //todos os objetos gerados s�o printados em tela
		}
    	 System.out.println("O codigo est� selecionando, aguarde aproximadamente 25 segundos");
    	 MochilaObjetos mochila = new MochilaObjetos(objetos); //objeto do tipo MochilaObjetos � criado
    	 ArrayList<Cromossomo>populacao = mochila.getPopulacao(); //Array de cromossomos � criado sendo preenchido por um array na classe MochilaObjetos
    	 System.out.println("Objetos selecionados para a mochila");
    	 for (int i = 0; i < 20; i++) {
			if(populacao.get(0).pertinencia[i]==1) {
				if(objetos.get(i).getValor()!=0.0) { 
				     c += objetos.get(i).getPeso();       //os objetos da Array de objetos em MochilaObjetos s�o selecionados para o array de objetosfinal at� que o peso maximo seja 15
				
				 	 objetosfinal.add(objetos.get(i));
				   
				     
				
				}
				
			}
		
		}
    	 for (int i = 0; i < objetosfinal.size(); i++) {
    		 System.out.println("Peso: "+objetosfinal.get(i).getPeso()+"Valor: "+objetosfinal.get(i).getValor());  //os objetos em objetosfinal s�o exibidos em tela
		}
      }
}

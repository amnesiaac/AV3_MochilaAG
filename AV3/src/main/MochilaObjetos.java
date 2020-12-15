package main;

import java.util.ArrayList;
import java.util.Random;

public class MochilaObjetos {
private ArrayList<Cromossomo>populacao;
protected ArrayList<Objeto>objetos;
 public MochilaObjetos() {
	 
 }
 public MochilaObjetos(ArrayList<Objeto>objetos) {
     this.objetos = objetos; // Array de objetos é preenchido de acordo com os objetos instanciados no main
	 populacao = geraPopulacao();  //array populacao sendo gerado a partir do metodo geraPopulacao();
     Executar(); //chamada do metodo executar
      }
 
      private void Executar() {
    	  
    	 long t= System.currentTimeMillis();
          long end = t+25000;
          while(System.currentTimeMillis() < end) {
    	    		 crossover(populacao,6);
    	      	     mutacao(populacao,6);            //durabte 25 segundos o metodo executar irá chamar os metodos crossover,mutacao,avaliar e ordenarElite
    	      	     avaliar(populacao,objetos);
    	      	     ordenarElite(populacao);
      }
 
      }
      public ArrayList<Cromossomo> getPopulacao() {
	return populacao;
}
	public double incrementaValor(ArrayList<Objeto>objetos,Cromossomo cromossomo) {
    	float totalValor = 0;
    	  for (int i = 0; i <20; i++) {                       //O array de objetos é percorrido e seu valor é incrementado em totalValor
    		totalValor+=objetos.get(i).getValor();
			
		}
    	  return totalValor;
    	
      }
      public double incrementaPeso(ArrayList<Objeto>objetos,Cromossomo cromossomo) {
      	float totalPeso = 0;
    	for (int i = 0; i <20; i++) {                 //O array de objetos é percorrido e seu peso é incrementado em totalPeso
      		totalPeso+=objetos.get(i).getPeso();
  		}
    	return totalPeso;
      }
      public ArrayList<Cromossomo> geraPopulacao(){
    	  ArrayList<Cromossomo> populacao = new ArrayList<Cromossomo>();
    	    for(int i=0;i<20;i++) {                                      //array populacao é gerado com base na classe cromossomo
    	    	Cromossomo c = new Cromossomo(this);
    	    	populacao.add(c);
    	    }
    	    return populacao;
      }

      void ordenarElite(ArrayList<Cromossomo>populacao) {
    	  Cromossomo c;
    	  for(int i = 0;i<populacao.size();i++) {
    		  for(int j = 0;j<populacao.size();j++) {
    			  if(populacao.get(i).getValor()>populacao.get(j).getValor()) {  //populacao é ordenada no array de populacao com base no valor
    				  c = populacao.get(i);   
    				  populacao.set(i, populacao.get(j));  
    				  populacao.set(j, c);
    			  }
    			
    		  }
    	  }
      }
    
      void crossover(ArrayList<Cromossomo>populacao,int tamElite) {
     	 int pai,mae,rand;
     	 Random geradorPai,geradorMae,geradorRand;
     	 for (int i = tamElite; i < 20; i++) {
     		 geradorPai = new Random();
     		 pai = geradorPai.nextInt(6);  //no metodo crossover o pai e mãe são gerados aleatoriamente, é escolhido aleatoriamente também se o filho receberá as caracteristicas do pai ou da mãe;
     		 geradorMae = new Random();
     		 mae = geradorMae.nextInt(6);
     		 for (int j = 0; j < 20; j++) {
     			 geradorRand = new Random();
     			 rand = geradorRand.nextInt(2);
     			 if(rand == 1) {
     				 populacao.get(i).pertinencia[j] = populacao.get(pai).pertinencia[j];
     			 }else {
     				
     				populacao.get(i).pertinencia[j] = populacao.get(mae).pertinencia[j];
     			 }
 			}
 		}
      }
      void mutacao(ArrayList<Cromossomo>populacao,int tamElite) {
    	  int rand;
    	  Random geradorRand;
    	  for (int i = tamElite; i < tamElite+4; i++) {
    		  for(int j=0;j<20;j++) {
    			  geradorRand = new Random();
    			  rand = geradorRand.nextInt(2);     //no metodo mutacao os objetos que estejam fora da elite são escolhidos para se mutar de forma aleatoria de acordo com a propria pertinencia
    			  if(rand==0) {
    				  if(populacao.get(i).pertinencia[j]==1) {
    					  populacao.get(i).pertinencia[j]= 0;
    				  }else {
    					  populacao.get(i).pertinencia[j]=1;
    				  }
    			  }
    		  }
			
		}
      }
      void avaliar(ArrayList<Cromossomo>populacao,ArrayList<Objeto>objetos) {
    	  for (int i = 0; i < 20; i++) {
			populacao.get(i).setPeso(incrementaPeso(objetos,populacao.get(i)));
			populacao.get(i).setValor(incrementaValor(objetos,populacao.get(i)));	//no metodo de avaliar, ocorre uma avaliação da populacao atual do array, caso o peso exceda o maximo permitido seu valor é convertido para 0
            if(populacao.get(i).getPeso()>15) {
            	populacao.get(i).setValor(0);
            }
    	  }
      }
}

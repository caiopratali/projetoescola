package br.com.myindaia.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	   private String nome;
	   private double soma;  
	   public List<Integer> notas = new ArrayList<>();
	   	
	   public Aluno(){


	   }
	   	  
		public double mediaDoAluno(){
			for (double n: notas)   
			    soma = soma + n /3;
			return soma;
		}
		
	   public String getNome(){

	   return nome;
	   }

	   public void setNome(String name){

	   nome = name;
	   }
}

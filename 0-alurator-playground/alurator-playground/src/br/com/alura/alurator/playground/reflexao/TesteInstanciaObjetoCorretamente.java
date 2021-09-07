package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<SubControle> subControleClasse1 = SubControle.class;
		
        Class<?> subControleClasse2 =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 = 
                Class.forName("br.com.alura.alurator.playground.controle.Controle");
        
     // pegando metodos publicos
        Constructor<SubControle> constructorsSubControle = subControleClasse1.getConstructor(); 
        
     // pegando metodos privados
        Constructor<SubControle> constructorsSubControle1 = subControleClasse1.getDeclaredConstructor(String.class);
        
        constructorsSubControle.setAccessible(true);
        SubControle newInstance = constructorsSubControle.newInstance();
        
        System.out.println(constructorsSubControle);
        
        
        Constructor<SubControle>  subControleClasse4  = SubControle.class.getConstructor(); 
        
	}
	

}

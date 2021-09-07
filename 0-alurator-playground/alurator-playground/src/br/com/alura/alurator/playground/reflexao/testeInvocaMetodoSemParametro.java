package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testeInvocaMetodoSemParametro {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		Class<?> subControleClasse =
                Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
		 
	    construtorPadrao.setAccessible(true); 
	    Object subControle = construtorPadrao.newInstance();
		 
		for(Method m : subControleClasse.getMethods()){
			System.out.println(m);
		}
		
		System.out.println();
		
		for(Method m : subControleClasse.getDeclaredMethods()){
			System.out.println(m);
		}
		
		Method m = subControleClasse.getDeclaredMethod("metodoSubControle2");
		m.setAccessible(true);
		Object invoke = m.invoke(subControle);
	}
}

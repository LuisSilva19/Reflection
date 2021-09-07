package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorClasse {

	private Class<?> classe;

	public ManipuladorClasse(Class<?> classe) {
		this.classe = classe;
	}

	public ManipuladorConstrutor getConstrutorPadrao() {
		try {
			Constructor<?> contrutorPadrao = classe.getDeclaredConstructor();
			return new ManipuladorConstrutor(contrutorPadrao);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		 
	}

	public ManipuladorObjeto criaInstancia() {
		Object instancia = getConstrutorPadrao().invoca();
		return new ManipuladorObjeto(instancia);
	}

}

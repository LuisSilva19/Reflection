package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflexao.Reflexao;

public class Alurator {
	
	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) { 
		
		Request request = new Request(url);
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> params = request.getQueryParams();
	
		Object retorno = new Reflexao()
						.refleteClasse(pacoteBase + nomeControle)
						.criaInstancia()
						.getMetodo(nomeMetodo, params)
						.comTratamentoDeExcecao((metodo, ex) -> {
						    System.out.println("Erro no método " + metodo.getName() + " da classe " 
						    + metodo.getDeclaringClass().getName() + ".\n\n");
						    throw new RuntimeException("Erro no método!"); 
						})
						.invoca();

		System.out.println(retorno);
		return retorno;
		
		/*
		Object instanciaControle = new Reflexao()
				.refleteClasse(pacoteBase + nomeControle)
				.getConstrutorPadrao()
				.invoca();
				
		Reflexao r = new Reflexao();
		ManipuladorClasse refleteClasse = r.refleteClasse(nomeControle);
		ManipuladorConstrutor construtorPadrao = refleteClasse.getConstrutorPadrao();
		Object invoca = construtorPadrao.invoca();
		
			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);
			//Object intanciaControle = classeControle.newInstance();
			
			// Constructor<?> intanciaControle = classeControle.getConstructor();
			 Object newInstance = intanciaControle.newInstance();
			
			Object newInstance = classeControle.getDeclaredConstructor().newInstance();
		 */
		
	}
}

package br.com.contmatic.model.util.validacao;

import java.util.Collection;

public class CollectionValidacao {

	private CollectionValidacao() {
		
	}
	
	public static void checkCollectionNull(Collection<?> collection, String message) {
		if (collection == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkCollectionVazio(Collection<?> collection, String message) {
		if (collection.isEmpty()) {  
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void checkCollectionTamanhoMinimo(Collection<?> collection, int quantidade, String message) {
		if(collection.size() < quantidade) {
			throw new IllegalArgumentException(message);
		}
	} 

	public static void checkCollectionTamanhoMaximo(Collection<?> collection, int quantidade, String message) {
		if(collection.size() > quantidade) {
			throw new IllegalArgumentException(message);
		}
	}
	
	
}

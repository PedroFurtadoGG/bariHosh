package br.com.bariHosh.util;

import java.util.List;

public abstract class OrdenadorTemplateMethod<T> extends Thread {

	public abstract boolean ePrimeiro(T obj, T obj1);

	List<T> array;

	public OrdenadorTemplateMethod(List<T> array) {

		this.array = array;
	}

	public List<T> listagemEmOrdem()  {
		try {

			final int meio = array.size();

			for (int i = 0; i < meio; i++) {
				for (int j = i; j < array.size(); j++) {

					if (!ePrimeiro(array.get(i), array.get(j))) {
						T temp = array.get(j);
						array.set(j, array.get(i));
						array.set(i, temp);
					}
				}
			}

			return array;
		} catch (Exception erro) {
			throw erro;
		}
	}

}

package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import isi.died.tp.dominio.Insumo;

public class ArbolVacio<E extends Comparable<E>> extends Arbol<E> {

	public ArbolVacio(){
		this.valor=null;
	}
	
	@Override
	public List<E> preOrden() {
		return new ArrayList<E>();
	}

	@Override
	public List<E> inOrden() {
		return new ArrayList<E>();
	}

	@Override
	public List<E> posOrden() {
		return new ArrayList<E>();
	}

	@Override
	public boolean esVacio() {
		return true;
	}

	@Override
	public E valor() {
		return null;
	}

	@Override
	public Arbol<E> izquierdo() {
		return null;
	}

	@Override
	public Arbol<E> derecho() {
		return null;
	}

	@Override
	public boolean contiene(E unValor) {
		return false;
	}

	@Override
	public boolean equals(Arbol<E> unArbol) {
		return unArbol.esVacio();
	}

	@Override
	public void agregar(E a) {
		
	}
        @Override
	public int profundidad() {
		return 0;
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		return 0;
	}

	@Override
	public boolean esCompleto() {
		return false;
	}

	@Override
	public boolean esLleno() {
		return false;
	}

	@Override
	public Collection<? extends E> rangoAux(Insumo inicial, Insumo fin, ArrayList<E> resultado) {
		return null;
	}
	
	public List<E> mayores(E n) {
		List<E> aux = new ArrayList<E>();
		return aux;
	}

	@Override
	protected E obtener(E unValor) {
		return null;
	}



}

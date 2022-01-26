package api.tistech.model;

public class ArvoreBinaria {

	private int valor;
	private ArvoreBinaria esquerda;
	private ArvoreBinaria direita;
	
	

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public ArvoreBinaria getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(ArvoreBinaria esquerda) {
		this.esquerda = esquerda;
	}

	public ArvoreBinaria getDireita() {
		return direita;
	}

	public void setDireita(ArvoreBinaria direita) {
		this.esquerda = esquerda;
	}

	public void setRight(ArvoreBinaria right) {
		this.direita = direita;
	}
	
	 public static int somar(ArvoreBinaria arvoreBinaria) {
	        if (arvoreBinaria == null) {
	            return 0;
	        }

	        return arvoreBinaria.getValor()
	                + (arvoreBinaria.getDireita() == null ? 0 : somar(arvoreBinaria.getDireita()))
	                + (arvoreBinaria.getEsquerda() == null ? 0 : somar(arvoreBinaria.getEsquerda()));
	    }
	    
	    public static ArvoreBinaria percorrer(ArvoreBinaria arvoreBinaria, int valor) {

	        if (arvoreBinaria.getValor() == valor) {
	            return arvoreBinaria;
	        }

	        if (arvoreBinaria.getEsquerda() != null) {
	            ArvoreBinaria ret = percorrer(arvoreBinaria.getEsquerda(), valor);
	            if (ret != null) {
	                return ret;
	            }
	        }

	        if (arvoreBinaria.getEsquerda() != null) {
	            return percorrer(arvoreBinaria.getDireita(), valor);
	        }
	        return null;
	    }
}

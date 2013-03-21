package tcc.tcc1;

import java.util.ArrayList;

public abstract class GuardaInformacoes {
	private static ArrayList<Integer> respostas = new ArrayList<Integer>();
	
	public static void setResposta (int valor){
		respostas.add(new Integer(valor));
	}
	
	public static int getResposta (int indiceGrupo){
		return (respostas.get(indiceGrupo).intValue());
	}
	
	public static int getMediaIntLimiteSuperior (){
		int soma = 0;
		for (int i=0; i<respostas.size();i++){
			soma += respostas.get(i);
		}
		return Math.round(soma/respostas.size());
	}
}

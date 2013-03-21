package tcc.tcc1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends Activity{
	
	private TextView resultado, resultado_descricao;
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.resultado_activity);
	        
	        carregarVariaveis();    
	    }
	  
	public void carregarVariaveis (){
		
		resultado = (TextView)findViewById(R.id.resultado_textView);
		resultado_descricao = (TextView)findViewById(R.id.resultado_descricao_textView);
		switch (GuardaInformacoes.getMediaIntLimiteSuperior()){
			case 0:
				resultado.setText(R.string.resultado_0);
				resultado_descricao.setText(R.string.resultado_0_descricao);
				break;
			case 1:
				resultado.setText(R.string.resultado_1);
				resultado_descricao.setText(R.string.resultado_1_descricao);
				break;
			case 2:
				resultado.setText(R.string.resultado_2);
				resultado_descricao.setText(R.string.resultado_2_descricao);
				break;
			case 3:
				resultado.setText(R.string.resultado_3);
				resultado_descricao.setText(R.string.resultado_3_descricao);
				break;
			case 4:
				resultado.setText(R.string.resultado_4);
				resultado_descricao.setText(R.string.resultado_4_descricao);
				break;
			case 5:
				resultado.setText(R.string.resultado_5);
				resultado_descricao.setText(R.string.resultado_5_descricao);
				break;
			default:
				resultado.setText("Erro");
				resultado_descricao.setText("Erro");
		}		
	}
	    
}
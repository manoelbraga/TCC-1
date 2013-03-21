package tcc.tcc1;

import java.security.Guard;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TCC_1Activity extends Activity {
    
	private ImageButton responderButton, avancarButton, helpButton;
	private ImageView visualizadorImagens;
	private TextView entradaUsuario;
	
	private int idImagemCorrente = 0;
	
	private final int QUANTIDADE_TELAS_POR_GRUPO_DE_TESTE = 2;
	private final int QUANTIDADE_DE_GRUPOS_DE_TESTE = 3;
	private final int QUANTIDADE_TENTATIVAS_POR_IMAGEM = 40;
	
	private ArrayList<Imagem> imagens = new ArrayList<Imagem>();
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
        carregarVariaveis();
        configurarImagens();
        
        listeners();    
    }
    
    private void carregaImagem (){
    	
    	visualizadorImagens.setImageResource(imagens.get(idImagemCorrente).getResourceId());
    }
    
    private void novaActivity(){
		Intent i = new Intent(this, ResultadoActivity.class);
        startActivity(i);
	}
    
    private void avancaTeste (){
    	Toast.makeText(TCC_1Activity.this,"Resposta Correta!", Toast.LENGTH_SHORT).show();
    	Imagem imagemCorrente = imagens.get(idImagemCorrente);
    	GuardaInformacoes.setResposta(imagemCorrente.getValor());
    	if (!((imagemCorrente.getGrupoId()+1)==QUANTIDADE_DE_GRUPOS_DE_TESTE)){
    		//resultadoPorGrupo.add(imagemCorrente.getValor());
    		idImagemCorrente = (imagemCorrente.getGrupoId()+1)*QUANTIDADE_TELAS_POR_GRUPO_DE_TESTE ;
    		carregaImagem();
    		entradaUsuario.setText("");
    	}else{
    		novaActivity();
    	}
    	
    }
    
    private void continuaTeste(){
    	Toast.makeText(TCC_1Activity.this,"Resposta Incorreta!", Toast.LENGTH_SHORT).show();
    	entradaUsuario.setText("");
    }
    
    private void avancaImagem (){
    	Imagem imagemCorrente = imagens.get(idImagemCorrente);
    	if (imagemCorrente.getIndiceGrupo() == (QUANTIDADE_TELAS_POR_GRUPO_DE_TESTE-1) ){//se for a ultima tela do grupo
    		Toast.makeText(TCC_1Activity.this,"Necessário responder para avançar!", Toast.LENGTH_SHORT).show();
    		carregaImagem();
    	}else{
    		idImagemCorrente++;
    		carregaImagem();
    	}
    }
    private void listeners (){
    	avancarButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				avancaImagem();
			}
		});
    	
    	
       	helpButton.setOnClickListener(new View.OnClickListener() {	
    			public void onClick(View v) {
    				
    			}
    		});
    	
    	responderButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				String entrada = entradaUsuario.getText().toString().trim();
				Imagem imagemCorrente = imagens.get(idImagemCorrente);
				if (entrada.trim().length() !=0){
					if (imagemCorrente.isIgualId(entrada.charAt(0)+"")){
						avancaTeste();
					}else{
						continuaTeste();
					}
				}else{
					Toast.makeText(TCC_1Activity.this,"Digite o símbolo que voce ve!", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    
    private void configurarImagens(){
    	imagens.add(new Imagem(0,   0, 0, 0, R.drawable.imagem_1,"1"));
    	imagens.add(new Imagem(100, 1, 0, 1, R.drawable.imagem_2,"2"));
    	imagens.add(new Imagem(0,   2, 1, 0, R.drawable.imagem_3,"3"));
    	imagens.add(new Imagem(100, 3, 1, 1, R.drawable.imagem_4,"4"));
    	imagens.add(new Imagem(0,   4, 2, 0, R.drawable.imagem_5,"5"));
    	imagens.add(new Imagem(100, 5, 2, 1, R.drawable.imagem_6,"6")); 	
    	
    }
    private void carregarVariaveis (){
    	avancarButton       = (ImageButton)findViewById(R.id.avancar_imageButton);
    	responderButton           = (ImageButton)findViewById(R.id.responder_imageButton);
    	helpButton          = (ImageButton)findViewById(R.id.help_imageButton);
    	visualizadorImagens = (ImageView)findViewById(R.id.imagem_imageView);
    	entradaUsuario      = (TextView)findViewById(R.id.entrada_editText);
    	
    }
}
package tcc.tcc1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BoasVindasActivity extends Activity{
	
	

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boas_vindas_activity);
        
        ImageButton startButton = (ImageButton)findViewById(R.id.startButtonImageButton);
        
        
		
        startButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				novaActivity();
			}
		});
    	
        
        
	}
	
	private void novaActivity(){
		Intent i = new Intent(this, TCC_1Activity.class);
        startActivity(i);
	}

}

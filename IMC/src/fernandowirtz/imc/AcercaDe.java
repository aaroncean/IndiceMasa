package fernandowirtz.imc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AcercaDe extends Activity {

	Button boton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Apéndice de método generado automáticamente
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acercade);
		
		boton = (Button)findViewById(R.id.btnAcercaDe);
		
		boton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Apéndice de método generado automáticamente
				finalizar();			
			}
		} );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Apéndice de método generado automáticamente
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Apéndice de método generado automáticamente
		return super.onOptionsItemSelected(item);
	}

	
	public void finalizar() {
		this.finish();
	}
	
	
	
}

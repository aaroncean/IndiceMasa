package fernandowirtz.imc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOGTAG = "MainActivity";

	private IndiceMasaCorporal imc;
	EditText editPeso;
	EditText editAltura;
	TextView textViewResultado;
	TextView textViewClasificacion;
	Button btnImc;
	Button btnAcercaDe;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Establecer identificadores
		editPeso = (EditText) findViewById(R.id.editPeso);
		editAltura = (EditText) findViewById(R.id.editAltura);
		textViewResultado = (TextView) findViewById(R.id.txtResultadoIMC);
		textViewClasificacion = (TextView) findViewById(R.id.txtClasificacion);
		btnImc = (Button) findViewById(R.id.btnCalcular);
		btnAcercaDe = (Button) findViewById(R.id.btnAcercaDe);

		btnImc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				calcularImc();
			}
		});

		btnAcercaDe.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				acercaDe();
			}
		});
	}

	/**
	 * onButtonClickCalcularIMC
	 */
	public void calcularImc() {

		String peso;
		String altura;
		try {

			peso = editPeso.getText().toString();
			altura = editAltura.getText().toString();

			imc = new IndiceMasaCorporal(peso, altura);

			textViewResultado.setText(imc.calcularIndice().toString());
			textViewClasificacion.setText(imc.mostrarClasificacion());
			Log.e(LOGTAG, imc.toString());

		} catch (IndiceMasaCorporalException e) {
			if (e.isErrorPeso()) {
				editPeso.setBackgroundColor(Color.LTGRAY);
				Toast.makeText(getApplicationContext(), "Peso incorrecto",
						Toast.LENGTH_SHORT).show();
			}
			if (e.isErrorAltura()) {
				editAltura.setBackgroundColor(Color.LTGRAY);
				Toast.makeText(getApplicationContext(), "Altura incorrecta",
						Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			Log.e(LOGTAG, e.getMessage());
		}
	}

	public void acercaDe() {
		try {
			Intent i = new Intent(this, AcercaDe.class);
			startActivity(i);
		} catch (Exception e) {
			Log.e(LOGTAG, e.getMessage());
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

package net.androidbootcamp.conversion;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	double conversionRate = 2.2;
	double weightEntered;
	double convertedWeight;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText weight = (EditText)findViewById(R.id.txtWeight);
		final RadioButton lbToKilo = (RadioButton)findViewById(R.id.radLbToKilo);
		final RadioButton kiloToLb = (RadioButton)findViewById(R.id.radKiloToLb);
		final TextView result = (TextView) findViewById(R.id.txtResult);
		Button convert = (Button) findViewById(R.id.btnConvert);
		
		convert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				DecimalFormat tenth = new DecimalFormat("#.#");
				
				if (weight.getText().toString() == null || (weight.getText().toString()).trim().equals("")){
					result.setText("Enter a value to convert");
				}
					
				else{	
					weightEntered = Double.parseDouble(weight.getText().toString());
				
				
				
				if(weightEntered <= 0){	
					result.setText("Enter a number that is greater than zero");
				
				}
				else{
					if(lbToKilo.isChecked()){
						convertedWeight = weightEntered / conversionRate;
						result.setText(tenth.format(convertedWeight) + "kilograms");
					}
					if(kiloToLb.isChecked()){
						convertedWeight = weightEntered * conversionRate;
						result.setText(tenth.format(convertedWeight) + "pounds");
					}
				
				}
			}
				
				
			}
				
			
			
		});
	}
}

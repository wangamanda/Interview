package com.convert.package1;
import android.app.Activity;
import android.os.Bundle;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.Button;

public class MyActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EditText editText = (EditText)findViewById(R.id.editText);
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListenter(){
		@Override
		public void onClick(View v) {
			String s = editText.getText().toString();
			ConvertDec conDec = new ConvertDec();
			String res = conDec.convert(s);
			new AlertDialog.Builder(context)
				.setTitle("Result")
				.setMessage(res)
				.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) { 
						dialog.dismiss();
					}
				})
				.show();
			}
		})
	}
}


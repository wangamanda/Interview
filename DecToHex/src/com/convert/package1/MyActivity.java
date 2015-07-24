package com.convert.package1;
import android.app.Activity;
import android.os.Bundle;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.util.Log;

public class MyActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context context = this;
		setContentView(R.layout.activity_main);
		final EditText editText = (EditText)findViewById(R.id.editText);
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener(){
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
				Log.d("Result", res);
			}
		});
	}
}


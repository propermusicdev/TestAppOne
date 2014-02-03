package com.proper.testappone;

import com.proper.testappone.R;
import com.proper.testappone.data.Product;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ActDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyt_details);
		
		populateUiControls(savedInstanceState);
	}
	
	private void populateUiControls(Bundle form) {
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			//Yell, Blue murder !
			return;
		}
		//action = extras.getString("ACTION_EXTRA");
		Product prod = (Product) extras.getSerializable("PRODUCT_EXTRA");
		
		//Populate views
		TextView txtArtist = (TextView) findViewById(R.id.txtv_Artist);
		TextView txtTitle = (TextView) findViewById(R.id.txtv_Title);
		
		TextView lblShortDesc = (TextView) findViewById(R.id.lblShortDesc);
		TextView lblISBN = (TextView) findViewById(R.id.lblISBN);
		TextView lblFormat = (TextView) findViewById(R.id.lblFormat);
		TextView lblBinNo = (TextView) findViewById(R.id.lblBinNumber);
		TextView lblOutOfStock = (TextView) findViewById(R.id.lblOutOfStock);
		TextView lblOnHand = (TextView) findViewById(R.id.lblOnHand);
		TextView lblPrice = (TextView) findViewById(R.id.lblPrice);
		
		TextView txtShortDesc = (TextView) findViewById(R.id.txtvShortDesc);
		TextView txtISBN = (TextView) findViewById(R.id.txtvISBN);
		TextView txtFormat = (TextView) findViewById(R.id.txtvFormat);
		TextView txtBinNo = (TextView) findViewById(R.id.txtvBinNumber);
		TextView txtOutOfStock = (TextView) findViewById(R.id.txtvOutOfStock);
		TextView txtOnHand = (TextView) findViewById(R.id.txtvOnHand);
		TextView txtPrice = (TextView) findViewById(R.id.txtvPrice);
		
		txtArtist.setText(prod.getArtist()) ; txtTitle.setText(prod.getTitle());
		lblShortDesc.setText("Short Description:") ; lblISBN.setText("ISBN:");
		lblFormat.setText("Format:") ; lblBinNo.setText("Bin Number:");
		lblOutOfStock.setText("Out of Stock:") ; lblOnHand.setText("Stock On Hand:");
		lblPrice.setText("Price:");
		txtShortDesc.setText(prod.getShortDescription()) ; txtISBN.setText(prod.getBarcode());
		txtFormat.setText(prod.getFormat()) ; txtBinNo.setText(prod.getBinNo());
		txtOutOfStock.setText(String.format("%s", prod.getOutOfStock())); 
		txtOnHand.setText(String.format("%s", prod.getOnHand()));
		txtPrice.setText(String.format("�    %s", prod.getDealerPrice()));
	}

	@Override
	public void onBackPressed() {
		this.startActivity(new Intent(ActDetails.this,com.android.barcode.ActMain.class));
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mnu_details, menu);
		return true;
	}

}

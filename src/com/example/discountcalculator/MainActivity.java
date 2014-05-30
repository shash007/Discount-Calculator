 // Assignment 2
// MainActivity.java

// Team Members :
// Shashank G Hebbale (800773977)
// Sahana K Raj (800774871)

package com.example.discountcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  
{
	
TextView tvListedPrice,tvDiscount,tvCustom,tvSave,tvSaveAmount,tvPay,tvPayAmount;
   //TextView tvTest;
	EditText etListedPrice;
	SeekBar sbDiscount;
	RadioGroup rgDiscount;
	RadioButton rd10,rd25,rd50,rdCustom;
	Button btnExit;
	int iDiscount=0;
	protected int progress;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvListedPrice=(TextView)findViewById(R.id.tvListedPrice);
        tvDiscount=(TextView)findViewById(R.id.tvDiscount);
        tvCustom=(TextView)findViewById(R.id.tvCustom);
        //tvProgress=(TextView)findViewById(R.id.tvProgress);
        tvSave=(TextView)findViewById(R.id.tvProgress);
        tvSaveAmount=(TextView)findViewById(R.id.tvSaveAmount);
        tvPay=(TextView)findViewById(R.id.tvPay);
        tvPayAmount=(TextView)findViewById(R.id.tvPayAmount);
        //tvTest=(TextView)findViewById(R.id.tvTest);
        etListedPrice=(EditText)findViewById(R.id.etListedPrice);
        final TextView tvProgress=(TextView)findViewById(R.id.tvProgress);
		sbDiscount=(SeekBar)findViewById(R.id.sbDiscount);
		sbDiscount.setEnabled(false);
        rd10=(RadioButton)findViewById(R.id.rd10);
        rd25=(RadioButton)findViewById(R.id.rd25);
        rd50=(RadioButton)findViewById(R.id.rd50);
        rdCustom=(RadioButton)findViewById(R.id.rdCustom);
        rgDiscount=(RadioGroup)findViewById(R.id.rgDiscount);
        btnExit=(Button)findViewById(R.id.btnExit);
        
        rd10.setChecked(true);
        
        etListedPrice.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
			
				if((etListedPrice.getText().length()==0)||(etListedPrice.getText().toString().equals(".")))
				{
					etListedPrice.setError("Please enter a valid value");
					tvSaveAmount.setText("$0.00");
			    	tvPayAmount.setText("$0.00");
				}
				else
				{
				if (rd10.isChecked()== true)
            	{
            		iDiscount=10;
            		setAmount(iDiscount);
            		
            	}
            	
            	if (rd25.isChecked()== true)
            	{
            		iDiscount=25;
            		setAmount(iDiscount);
            		
            	}
            	if (rd50.isChecked()== true)
            	{
            		iDiscount=50;
            		setAmount(iDiscount);
            		
            	}
            	if (rdCustom.isChecked()== true)
            	{
            		iDiscount=sbDiscount.getProgress();
            		setAmount(iDiscount);
            		
            	}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        
        rgDiscount.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				
					
				    switch(checkedId)
				    {
				    case R.id.rd10:
				    	sbDiscount.setProgress(25);
				    	sbDiscount.setEnabled(false);
						iDiscount=10;
						
						if((etListedPrice.getText().length()==0)||(etListedPrice.getText().toString().equals(".")))
						{
							etListedPrice.setError("Please enter a valid value");
							
						}
						else
						{
							
						setAmount(iDiscount);
						Toast.makeText(getApplicationContext(), "Applying a discount of 10%", Toast.LENGTH_SHORT).show();
						}
						//tvTest.setText(iDiscount+"");			
					   break;
					   
				    case R.id.rd25:
				    	
				    	sbDiscount.setProgress(25);
				    	sbDiscount.setEnabled(false);
						iDiscount=25;
												if((etListedPrice.getText().length()==0)||(etListedPrice.getText().toString().equals(".")))
						{
							etListedPrice.setError("Please enter a valid value");
						}
						else
						{
						setAmount(iDiscount);
						Toast.makeText(getApplicationContext(), "Applying a discount of 25%", Toast.LENGTH_SHORT).show();
						}
						//tvTest.setText(iDiscount+"");
						break;
						
				    case R.id.rd50:
				    	
				    	sbDiscount.setProgress(25);
				    	sbDiscount.setEnabled(false);
						iDiscount=50;
						if((etListedPrice.getText().length()==0)||(etListedPrice.getText().toString().equals(".")))
						{
							etListedPrice.setError("Please enter a valid value");
							
						}
						else
						{
						setAmount(iDiscount);
						Toast.makeText(getApplicationContext(), "Applying a discount of 50%", Toast.LENGTH_SHORT).show();
						//tvTest.setText(iDiscount+"");
						}
						break;
						
				    case R.id.rdCustom:
				    	
				    	if((etListedPrice.getText().length()==0)||(etListedPrice.getText().toString().equals(".")))
						{
							etListedPrice.setError("Please enter a valid value");
							//sbDiscount.setEnabled(false);
						}
						else
						{
							
				    	//tvTest.setText("");
						sbDiscount.setEnabled(true);
						iDiscount=sbDiscount.getProgress();
						setAmount(iDiscount);
						Toast.makeText(getApplicationContext(), "Please select the discount to be applied", Toast.LENGTH_SHORT).show();
						sbDiscount.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
						{
							@Override
							public void onStopTrackingTouch(SeekBar seekBar) 
							{
							// TODO Auto-generated method stub
							
							}
						
							@Override
							public void onStartTrackingTouch(SeekBar seekBar) 
							{
							// TODO Auto-generated method stub
							
							}
							@Override
							public void onProgressChanged(SeekBar seekBar, int progress,
								boolean fromUser) 
							{
							// TODO Auto-generated method stub
							//tvProgress.setText(sbDiscount.getProgress().toString());
								iDiscount=sbDiscount.getProgress();
								tvProgress.setText(progress+"%");
								setAmount(iDiscount);
								//sbDiscount.setEnabled(true);
								//tvTest.setText(iDiscount+"");
							}
						});
						}
						break;
				    }
		        
			}		
			
			
		});
        
        
        btnExit.setOnClickListener(new OnClickListener() {
        	
			
			@Override
			public void onClick(View v) {
				finish();
				// TODO Auto-generated method stub
				
			}
		});
        
        
    }
    public void setAmount(int iDiscount_val)
    {
    	if(etListedPrice.getText().toString()!=""){
    			
    	double dSave,dPay,dListedPrice;
    	dListedPrice=Double.valueOf(etListedPrice.getText().toString()).doubleValue();
    	dSave= ((double)iDiscount_val/100)*dListedPrice;
    	dPay=dListedPrice-dSave;
    	tvSaveAmount.setText("$"+dSave+"");
    	tvPayAmount.setText("$"+dPay+"");
    	}
    	else
    		etListedPrice.setError("Please enter a valid value");
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
	
		
}
	
	
	
	

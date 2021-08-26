package com.swiftoffice.msaknowledgebank;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    private Button btnMSA, btnExit;
    private Handler handler = new Handler();
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        btnMSA = (Button) findViewById(R.id.btnMSA);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnMSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayLoadingDialog();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayExitConfirmation();
            }
        });
    }

    public void displayLoadingDialog() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading MSA Contents");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < 100) {
                    progress += 1;
                    try {
                        Thread.sleep(20); //increase progress(integer) to 100 through certain rate of time
                    } catch (Exception e) {

                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setProgress(progress);
                            SpannableString ss =  new SpannableString(progress + " % loading");
                            StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
                            ss.setSpan(boldSpan, 0, ss.length(), 0);
                            ss.setSpan(new RelativeSizeSpan(1.5f), 0, ss.length(), 0);
                            progressDialog.setMessage(ss);
                        }
                    });
                }
                progressDialog.dismiss(); //once finished
                goToMSAContents();
            }
        }).start(); //start the progress
    }

    public void goToMSAContents() {
        Intent MSAIntent = new Intent(MainPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    public void displayExitConfirmation() {
        final AlertDialog.Builder exitAlertBuilder = new AlertDialog.Builder(this);
        exitAlertBuilder.setIcon(R.drawable.caution);
        exitAlertBuilder.setTitle("Confirm Exit");
        SpannableString ss =  new SpannableString("Are you sure?");
        ss.setSpan(new RelativeSizeSpan(1.3f), 0, ss.length(), 0);
        exitAlertBuilder.setMessage(ss);
        exitAlertBuilder.setCancelable(false);
        exitAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        exitAlertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        exitAlertBuilder.show();
    }

    public void onBackPressed() {
        displayExitConfirmation();
    }
}

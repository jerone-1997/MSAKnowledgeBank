package com.swiftoffice.msaknowledgebank;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class GeneralSoldering3_1_5_5thPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtPrevious, txtNext, txtHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_soldering_3_1_5_5th_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        seekMovePages = (SeekBar) findViewById(R.id.seekMovePages);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        txtNext = (TextView) findViewById(R.id.txtNext);
        txtPrevious = (TextView) findViewById(R.id.txtPrevious);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackToContentPageConfirmation();
            }
        });
        seekMovePages.setProgress(5);
        seekMovePages.setMax(11);
        seekMovePages.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                page = i;
                if (page <= 1) {
                    seekMovePages.setProgress(1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (page == 1) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 2) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_2ndPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_3rdPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 4) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_4thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 6) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_6thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 7) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_7thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 8) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_8thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 9) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_9thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 10) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_10thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 11) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_11thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>General Soldering Procedures (Part 1)</u></p>"));
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_6thPage.class);
                startActivity(nextIntent);
                finish();
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent previousIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, GeneralSoldering3_1_5_4thPage.class);
                startActivity(previousIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            displayBackToMainPageConfirmation();
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayBackToMainPageConfirmation() {
        final AlertDialog.Builder exitAlertBuilder = new AlertDialog.Builder(this);
        exitAlertBuilder.setIcon(R.drawable.caution);
        exitAlertBuilder.setTitle("Return to Main Page");
        SpannableString ss =  new SpannableString("Are you sure?");
        ss.setSpan(new RelativeSizeSpan(1.3f), 0, ss.length(), 0);
        exitAlertBuilder.setMessage(ss);
        exitAlertBuilder.setCancelable(false);
        exitAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goToMainPage();
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

    public void goToMainPage() {
        Intent MainIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }

    public void onBackPressed() {
        displayBackToContentPageConfirmation();
    }

    public void displayBackToContentPageConfirmation() {
        final AlertDialog.Builder backAlertBuilder = new AlertDialog.Builder(this);
        backAlertBuilder.setIcon(R.drawable.caution);
        backAlertBuilder.setTitle("Return to Contents");
        SpannableString ss =  new SpannableString("Are you sure?");
        ss.setSpan(new RelativeSizeSpan(1.3f), 0, ss.length(), 0);
        backAlertBuilder.setMessage(ss);
        backAlertBuilder.setCancelable(false);
        backAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goToMSAContents();
            }
        });
        backAlertBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        backAlertBuilder.show();
    }

    public void goToMSAContents() {
        Intent MSAIntent = new Intent(GeneralSoldering3_1_5_5thPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }
}

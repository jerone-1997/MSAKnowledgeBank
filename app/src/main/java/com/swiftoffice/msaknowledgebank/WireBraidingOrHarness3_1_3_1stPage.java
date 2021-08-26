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

public class WireBraidingOrHarness3_1_3_1stPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtNext, txtHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wire_braiding_harness_3_1_3_1st_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        seekMovePages = (SeekBar) findViewById(R.id.seekMovePages);
        txtNext = (TextView) findViewById(R.id.txtNext);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackToContentPageConfirmation();
            }
        });
        seekMovePages.setProgress(1);
        seekMovePages.setMax(3);
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
                if (page == 2) {
                    Intent nextIntent = new Intent(WireBraidingOrHarness3_1_3_1stPage.this, WireBraidingOrHarness3_1_3_2ndPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent nextIntent = new Intent(WireBraidingOrHarness3_1_3_1stPage.this, WireBraidingOrHarness3_1_3_3rdPage.class);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>Wire Braiding/Harness Repair (Part 1)</u></p>"));
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(WireBraidingOrHarness3_1_3_1stPage.this, WireBraidingOrHarness3_1_3_2ndPage.class);
                startActivity(nextIntent);
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
        Intent MainIntent = new Intent(WireBraidingOrHarness3_1_3_1stPage.this, MainPage.class);
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
        Intent MSAIntent = new Intent(WireBraidingOrHarness3_1_3_1stPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }
}

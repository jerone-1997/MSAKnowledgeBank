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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContentsPage extends AppCompatActivity {

    private ExpendableMSAAdapter expendableMSAAdapter;
    private ExpandableListView MSAList;
    private HashMap<String, List<String>> MSAData;
    private Handler handler = new Handler();
    private int progress;
    private List<String> MSAChapters;
    private Toast comingSoonToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        MSAList = (ExpandableListView) findViewById(R.id.msa_list);
        MSAData = new HashMap<String, List<String>>();
        MSAChapters = new ArrayList<String>();
        MSAChapters = Arrays.asList(getResources().getStringArray(R.array.MSA_Elements));//pump in all the sub-elements for Element 1 and so on
        MSAData.put(MSAChapters.get(0), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_1_1)));
        MSAData.put(MSAChapters.get(1), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_1_2)));
        MSAData.put(MSAChapters.get(2), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_1_3)));
        MSAData.put(MSAChapters.get(3), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_1_4)));
        MSAData.put(MSAChapters.get(4), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_2_1)));
        MSAData.put(MSAChapters.get(5), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_2_2)));
        MSAData.put(MSAChapters.get(6), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_2_3)));
        MSAData.put(MSAChapters.get(7), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_2_4)));
        MSAData.put(MSAChapters.get(8), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_2_5)));
        MSAData.put(MSAChapters.get(9), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_3_1)));
        MSAData.put(MSAChapters.get(10), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_3_2)));
        MSAData.put(MSAChapters.get(11), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_3_3)));
        MSAData.put(MSAChapters.get(12), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_3_4)));
        MSAData.put(MSAChapters.get(13), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_4_1)));
        MSAData.put(MSAChapters.get(14), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_4_2)));
        MSAData.put(MSAChapters.get(15), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_4_3)));
        MSAData.put(MSAChapters.get(16), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_5_1)));
        MSAData.put(MSAChapters.get(17), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_5_2)));
        MSAData.put(MSAChapters.get(18), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_5_3)));
        MSAData.put(MSAChapters.get(19), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_6_1)));
        MSAData.put(MSAChapters.get(20), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_6_2)));
        MSAData.put(MSAChapters.get(21), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_6_3)));
        MSAData.put(MSAChapters.get(22), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_6_4)));
        MSAData.put(MSAChapters.get(23), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_6_5)));
        MSAData.put(MSAChapters.get(24), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_7_1)));
        MSAData.put(MSAChapters.get(25), Arrays.asList
                (getResources().getStringArray(R.array.MSA_Element_7_2)));
        expendableMSAAdapter = new ExpendableMSAAdapter(this, MSAChapters, MSAData);
        MSAList.setAdapter(expendableMSAAdapter);
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.list_header, MSAList,false);
        MSAList.addHeaderView(headerView);
        MSAList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                displayClickedItem(groupPosition, childPosition);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            displayBackConfirmation();
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayClickedItem(int getElementPosition, int getSubElementPosition) {
        if (getElementPosition == 0) { //Element 1.1 Locking/Fastening Devices
            if (getSubElementPosition == 0) { //go to 1.1.1 Wire Locking Page
                showLoadingElementDialog("1.1.1 Safety Wire-Lock", Wirelock1_1_1.class);
            } else if (getSubElementPosition == 1) { //go to 1.1.2 Cotter Pins
                showLoadingElementDialog("1.1.2 Cotter Pins", Cotter1_1_2_1stPage.class);
            } else if (getSubElementPosition == 2) { //go to 1.1.3 Nuts
                showLoadingElementDialog("1.1.3 Securing Nuts", Nuts1_1_3_1stPage.class);
            } else if (getSubElementPosition == 3) { //go to 1.1.4 Bolts
                showLoadingElementDialog("1.1.4 Bolts", Bolts1_1_4.class);
            } else if (getSubElementPosition == 4) { //go to 1.1.5 Screws
                showLoadingElementDialog("1.1.5 Screws", Screws1_1_5.class);
            } else if (getSubElementPosition == 5) { //go to 1.1.6 Washers
                showLoadingElementDialog("1.1.6 Washers", Washers1_1_6_1stPage.class);
            } else if (getSubElementPosition == 6) { //go to 1.1.7 Torque Loading
                showLoadingElementDialog("1.1.7 Torque Loading", Torque1_1_7_1stPage.class);
            }
        } else if (getElementPosition == 1) { //Element 1.2 Leak Control
            if (getSubElementPosition == 2) { //go to 1.2.3 Sealant
                showLoadingElementDialog("1.2.3 Sealant", Sealant1_2_3_1stPage.class);
            }
            else {
                displayComingSoon();
            }
        } else if (getElementPosition == 3) { //Element 1.4 Aircraft/Component Protection
            if (getSubElementPosition == 0) { //go to 1.4.1 General Bonding and Grounding
                showLoadingElementDialog("1.4.1 General Bonding and Grounding", BondingGrounding1_4_1_1stPage.class);
            }
            else {
                displayComingSoon();
            }
        } else if (getElementPosition == 9) { //Element 3.1. Wire Repair
            if (getSubElementPosition == 0) { //go to 3.1.1 Wire Stripping Page
                showLoadingElementDialog("3.1.1 Wire Stripping", WireStripping3_1_1_1stPage.class);
            } else if (getSubElementPosition == 1) { //go to 3.1.2 Wire Crimping Page
                showLoadingElementDialog("3.1.2 Wire Crimping", WireCrimping3_1_2.class);
            } else if (getSubElementPosition == 2) { //go to 3.1.3 Wire Braiding/Harness Repair Page
                showLoadingElementDialog("3.1.3 Wire Braiding/Harness Repair", WireBraidingOrHarness3_1_3_1stPage.class);
            } else if (getSubElementPosition == 3) { //go to 3.1.4 Wire Insulation Page
                showLoadingElementDialog("3.1.4 Wire Insulation Repair", WireInsulationRepair3_1_4_1stPage.class);
            } else if (getSubElementPosition == 4) { //go to 3.1.5 General Soldering Page
                showLoadingElementDialog("3.1.5 General Soldering", GeneralSoldering3_1_5_1stPage.class);
            }
        } else if (getElementPosition == 10) { //Element 3.2. Wire Security/Mounting
            if (getSubElementPosition == 1) { //go to 3.2.2 Chaffing Protection
                showLoadingElementDialog("3.2.2 Chafing Protection", Chafing3_2_2_1stPage.class);
            }
            else if (getSubElementPosition == 2) { //go to 3.2.3 Cable Clamping
                showLoadingElementDialog("3.2.3 Cable Clamping", Clamping3_2_3_1stPage.class);
            }
            else {
                displayComingSoon();
            }
        } else if (getElementPosition == 11) { //Element 3.3 Connectors
            if (getSubElementPosition == 4) { //go to 3.3.5 Blanking of Connectors
                showLoadingElementDialog("3.3.5 Blanking of Connectors", Blanking3_3_5.class);
            }
            else {
                displayComingSoon();
            }
        }
        else {
            displayComingSoon();
        }
    }

    public void showLoadingElementDialog(String getSubChapterTitle, final Class getNextClass) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading " + getSubChapterTitle);
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
                        Thread.sleep(15); //increase progress(integer) to 100 through certain rate of time
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
                goToSubElement(getNextClass);
            }
        }).start(); //start the progress
    }

    public void goToSubElement(Class getNextClass) {
        Intent subElementIntent = new Intent(ContentsPage.this, getNextClass);
        startActivity(subElementIntent);
        finish();
    }

    public void onBackPressed() {
        displayBackConfirmation();
    }

    public void displayComingSoon() {
        if (comingSoonToast != null) {
            comingSoonToast.cancel();
        }
        comingSoonToast = Toast.makeText(this, R.string.coming_soon, Toast.LENGTH_SHORT);
        comingSoonToast.show();
    }

    public void displayBackConfirmation() {
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
        Intent MainIntent = new Intent(ContentsPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }
}
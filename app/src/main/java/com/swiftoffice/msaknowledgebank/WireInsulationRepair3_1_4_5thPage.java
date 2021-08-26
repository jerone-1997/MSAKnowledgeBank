package com.swiftoffice.msaknowledgebank;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class WireInsulationRepair3_1_4_5thPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private ImageView imgWireRepair;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtTitle, txtPrevious, txtHeading, txtImageIndex, txtHyperLink1, txtHyperLink2;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wire_insulation_repair_3_1_4_5th_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        seekMovePages = (SeekBar) findViewById(R.id.seekMovePages);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        txtHyperLink1 = (TextView) findViewById(R.id.txtHyperLink1);
        txtHyperLink2 = (TextView) findViewById(R.id.txtHyperLink2);
        txtPrevious = (TextView) findViewById(R.id.txtPrevious);
        SpannableString ss1 = new SpannableString("Perfect examples of Wire Insulation Repair and Wire Damage");
        ss1.setSpan(new UnderlineSpan(), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString("Wire Insulation Repair T.O. WP 013 00 to 014 00");
        ss2.setSpan(new UnderlineSpan(), 0, ss2.length(), 0);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackToContentPageConfirmation();
            }
        });
        seekMovePages.setProgress(5);
        seekMovePages.setMax(5);
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
                    Intent previousIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, WireInsulationRepair3_1_4_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 2) {
                    Intent previousIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, WireInsulationRepair3_1_4_2ndPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent previousIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, WireInsulationRepair3_1_4_3rdPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 4) {
                    Intent previousIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, WireInsulationRepair3_1_4_4thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>Wire Insulation Repair (Part 5)</u></p>"));
        txtHyperLink1.setText(ss1);
        txtHyperLink2.setText(ss2);
        txtHyperLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink1.setTextColor(Color.parseColor("#FF69B4"));
                displayWireRepairPopup();
            }
        });
        txtHyperLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink2.setTextColor(Color.parseColor("#FF69B4"));
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://drive.google.com/file/d/1YzJ7JnD8Gukhzz8frG2JcQDuVJK5_D-T/view?usp=sharing"));
                startActivity(i);
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, WireInsulationRepair3_1_4_4thPage.class);
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
        Intent MainIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }

    public void displayWireRepairPopup() {
        android.app.AlertDialog.Builder imageDialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.layout_root));
        viewPager = (ViewPager) layout.findViewById(R.id.img);
        txtImageIndex = (TextView) layout.findViewById(R.id.txtImageIndex);
        txtTitle = (TextView) layout.findViewById(R.id.txtTitle);
        txtImageIndex.setText("Current Image: 1/5");
        txtTitle.setText("CAUTION");
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        imageDialog.setTitle("Perfect examples of Wire Insulation Repair and Wire Damage");
        imageDialog.setView(layout);
        imageDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        imageDialog.create();
        imageDialog.show();
        imageDialog.setCancelable(false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txtImageIndex.setText("Current Image: " + String.valueOf(position + 1) + "/" + "5");
                if (position == 0) {
                    txtTitle.setText("CAUTION");
                }
                if (position == 1) {
                    txtTitle.setText("End & Inline Splices");
                }
                else if (position == 2) {
                    txtTitle.setText("Steps on how to crimp the wire with splice");
                }
                else if (position == 3) {
                    txtTitle.setText("Wire Damaged at Single Point & Along its Length");
                }
                else if (position == 4) {
                    txtTitle.setText("Exmaple of a Multi-Conductor Wire");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onBackPressed() {
        displayBackToContentPageConfirmation();
    }

    public void  displayBackToContentPageConfirmation() {
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
        Intent MSAIntent = new Intent(WireInsulationRepair3_1_4_5thPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    private class ImagePagerAdapter extends PagerAdapter { //swipe image
        private int[] mImages = new int[] {
                R.drawable.wire_insulation_caution,
                R.drawable.end_inline_splices,
                R.drawable.splice_installation,
                R.drawable.wire_damage,
                R.drawable.wire_multi,
        };

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = WireInsulationRepair3_1_4_5thPage.this;
            imgWireRepair = new ImageView(context);
            imgWireRepair.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imgWireRepair.setImageResource(mImages[position]);
            PhotoViewAttacher zoomImage = new PhotoViewAttacher(imgWireRepair);
            zoomImage.update();
            ((ViewPager) container).addView(imgWireRepair, 0);
            return imgWireRepair;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}

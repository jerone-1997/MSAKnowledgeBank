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

public class GeneralSoldering3_1_5_4thPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private ImageView imgSoldering;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtTitle, txtPrevious, txtNext, txtHeading, txtImageIndex, txtHyperLink1, txtHyperLink2;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_soldering_3_1_5_4th_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        seekMovePages = (SeekBar) findViewById(R.id.seekMovePages);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        txtHyperLink1 = (TextView) findViewById(R.id.txtHyperLink1);
        txtHyperLink2 = (TextView) findViewById(R.id.txtHyperLink2);
        txtNext = (TextView) findViewById(R.id.txtNext);
        txtPrevious = (TextView) findViewById(R.id.txtPrevious);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackToContentPageConfirmation();
            }
        });
        seekMovePages.setProgress(4);
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
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 2) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_2ndPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_3rdPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 5) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_5thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 6) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_6thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 7) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_7thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 8) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_8thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 9) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_9thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 10) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_10thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 11) {
                    Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_11thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>Soldering Iron Preparation And Maintenance</u></p>"));
        SpannableString ss1 = new SpannableString("Perfect Example of Preparing and Maintaining Soldering Iron");
        ss1.setSpan(new UnderlineSpan(), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString("Soldering Iron Preparation T.O.");
        ss2.setSpan(new UnderlineSpan(), 0, ss2.length(), 0);
        txtHyperLink1.setText(ss1);
        txtHyperLink2.setText(ss2);
        txtHyperLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink1.setTextColor(Color.parseColor("#FF69B4"));
                displayWireStrippingImagePopup();
            }
        });
        txtHyperLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink2.setTextColor(Color.parseColor("#FF69B4"));
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://drive.google.com/file/d/1vLyeWYyjeoqzH-JRZ-vVlxfgA5Gbk2NE/view?usp=sharing"));
                startActivity(i);
            }
        });
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_5thPage.class);
                startActivity(nextIntent);
                finish();
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent previousIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, GeneralSoldering3_1_5_3rdPage.class);
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
        Intent MainIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }

    public void displayWireStrippingImagePopup() {
        android.app.AlertDialog.Builder imageDialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.layout_root));
        viewPager = (ViewPager) layout.findViewById(R.id.img);
        txtTitle = (TextView) layout.findViewById(R.id.txtTitle);
        txtImageIndex = (TextView) layout.findViewById(R.id.txtImageIndex);
        txtTitle.setText("WARNING");
        txtImageIndex.setText("Current Image: 1/7");
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        imageDialog.setTitle("Perfect Example of Preparing and Maintaining Soldering Iron");
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
                txtImageIndex.setText("Current Image: " + String.valueOf(position + 1) + "/" + "7");
                if (position == 0) {
                    txtTitle.setText("WARNING");
                }
                else if (position == 1) {
                    txtTitle.setText("Oxidation occuring on soldering iron tip");
                }
                else if (position == 2) {
                    txtTitle.setText("Example of a cored solder");
                }
                else if (position == 3) {
                    txtTitle.setText("Procedures on tinning soldering iron tip");
                }
                else if (position == 4) {
                    txtTitle.setText("Example of a sponge used");
                }
                else if (position == 5) {
                    txtTitle.setText("Different types of soldering iron");
                }
                else if (position == 6) {
                    txtTitle.setText("Different sizes of soldering iron tip");
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
        Intent MSAIntent = new Intent(GeneralSoldering3_1_5_4thPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    private class ImagePagerAdapter extends PagerAdapter { //swipe image
        private int[] mImages = new int[] {
                R.drawable.soldering_warning_3,
                R.drawable.soldering_iron_oxidation,
                R.drawable.cored_solder,
                R.drawable.solder_tinning,
                R.drawable.soldering_iron_sponge,
                R.drawable.diff_soldering_iron,
                R.drawable.soldering_iron_tips,
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
            Context context = GeneralSoldering3_1_5_4thPage.this;
            imgSoldering = new ImageView(context);
            imgSoldering.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imgSoldering.setImageResource(mImages[position]);
            PhotoViewAttacher zoomImage = new PhotoViewAttacher(imgSoldering);
            zoomImage.update();
            ((ViewPager) container).addView(imgSoldering, 0);
            return imgSoldering;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}

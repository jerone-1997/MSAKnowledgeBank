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

public class GeneralSoldering3_1_5_11thPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private int page;
    private SeekBar seekMovePages;
    private ImageView imgSoldering;
    private TextView txtTitle, txtPrevious, txtHeading, txtImageIndex, txtHyperLink1, txtHyperLink2;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_soldering_3_1_5_11th_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        seekMovePages = (SeekBar) findViewById(R.id.seekMovePages);
        txtHeading = (TextView) findViewById(R.id.txtHeading);
        txtHyperLink1 = (TextView) findViewById(R.id.txtHyperLink1);
        txtHyperLink2 = (TextView) findViewById(R.id.txtHyperLink2);
        txtPrevious = (TextView) findViewById(R.id.txtPrevious);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBackToContentPageConfirmation();
            }
        });
        seekMovePages.setProgress(11);
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
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 2) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_2ndPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_3rdPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 4) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_4thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 5) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_6thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 6) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_6thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 7) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_7thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 8) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_8thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 9) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_9thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 10) {
                    Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_10thPage.class);
                    startActivity(previousIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>General Soldering Procedures (Part 7)</u></p>"));
        SpannableString ss1 = new SpannableString("General Soldering Procedures");
        ss1.setSpan(new UnderlineSpan(), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString("General Soldering Procedures T.O.");
        ss2.setSpan(new UnderlineSpan(), 0, ss2.length(), 0);
        txtHyperLink1.setText(ss1);
        txtHyperLink2.setText(ss2);
        txtHyperLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink1.setTextColor(Color.parseColor("#FF69B4"));
                displaySolderingPopup();
            }
        });
        txtHyperLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink2.setTextColor(Color.parseColor("#FF69B4"));
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://drive.google.com/file/d/1r6O2Ky36_RhCisfWR1-6it1zCV6WY48H/view?usp=sharing"));
                startActivity(i);
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent previousIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, GeneralSoldering3_1_5_10thPage.class);
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
        Intent MainIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }

    public void displaySolderingPopup() {
        android.app.AlertDialog.Builder imageDialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.layout_root));
        viewPager = (ViewPager) layout.findViewById(R.id.img);
        txtTitle = (TextView) layout.findViewById(R.id.txtTitle);
        txtImageIndex = (TextView) layout.findViewById(R.id.txtImageIndex);
        txtTitle.setText("WARNING");
        txtImageIndex.setText("Current Image: 1/13");
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        imageDialog.setTitle("General Soldering Procedures");
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
                txtImageIndex.setText("Current Image: " + String.valueOf(position + 1) + "/" + "13");
                if (position == 0 || position == 1 || position == 4) {
                    txtTitle.setText("WARNING");
                }
                else if (position == 2) {
                    txtTitle.setText("Use isopropyl alcohol to clean contaminated parts");
                }
                else if (position == 3) {
                    txtTitle.setText("Example of a clean (right) & dirty (left) soldering iron");
                }
                else if (position == 5) {
                    txtTitle.setText("Procedures on tinning soldering iron tip");
                }
                else if (position == 6) {
                    txtTitle.setText("Different sizes of soldering iron tip");
                }
                else if (position == 7) {
                    txtTitle.setText("Example of a burned soldering iron tip");
                }
                else if (position == 8) {
                    txtTitle.setText("Procedures on how to make a solder joint");
                }
                else if (position == 9 || position == 10) {
                    txtTitle.setText("Good & Bad Examples of a solder joint");
                }
                else if (position == 11) {
                    txtTitle.setText("Desoldering using mechanical vacuum");
                }
                else if (position == 12) {
                    txtTitle.setText("Desoldering using wicking method");
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
        Intent MSAIntent = new Intent(GeneralSoldering3_1_5_11thPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    private class ImagePagerAdapter extends PagerAdapter { //swipe image
        private int[] mImages = new int[]{
                R.drawable.soldering_warning_4,
                R.drawable.soldering_warning_2,
                R.drawable.isopropyl,
                R.drawable.soldering_iron_dirty_clean,
                R.drawable.soldering_warning_3,
                R.drawable.solder_tinning,
                R.drawable.soldering_iron_tips,
                R.drawable.burned_soldering_iron,
                R.drawable.solder_steps,
                R.drawable.good_bad_solder,
                R.drawable.bad_soldering,
                R.drawable.desolder_vacuum,
                R.drawable.desolder_wick,
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
            Context context = GeneralSoldering3_1_5_11thPage.this;
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

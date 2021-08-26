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

public class Clamping3_2_3_2ndPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private ImageView imgClamping;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtTitle, txtNext, txtPrevious, txtHeading, txtImageIndex, txtHyperLink1, txtHyperLink2;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clamping_3_2_3_2nd_page);
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
        seekMovePages.setProgress(2);
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
                if (page == 1) {
                    Intent previousIntent = new Intent(Clamping3_2_3_2ndPage.this, Clamping3_2_3_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                if (page == 3) {
                    Intent nextIntent = new Intent(Clamping3_2_3_2ndPage.this, Clamping3_2_3_3rdPage.class);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>Different Types of Cable Clamps</u></p>"));
        SpannableString ss1 = new SpannableString("Examples of Cable Clamps used in aircraft");
        ss1.setSpan(new UnderlineSpan(), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString("Cable Clamping T.O. 1-1A-14 WP 010 00");
        ss2.setSpan(new UnderlineSpan(), 0, ss2.length(), 0);
        txtHyperLink1.setText(ss1);
        txtHyperLink2.setText(ss2);
        txtHyperLink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink1.setTextColor(Color.parseColor("#FF69B4"));
                displayClampingImagePopup();
            }
        });
        txtHyperLink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHyperLink2.setTextColor(Color.parseColor("#FF69B4"));
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://drive.google.com/file/d/1VXvQOl0FK2dPhpqjBnvhNOg-WBed01qj/view?usp=sharing"));
                startActivity(i);
            }
        });
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(Clamping3_2_3_2ndPage.this, Clamping3_2_3_3rdPage.class);
                startActivity(nextIntent);
                finish();
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousIntent = new Intent(Clamping3_2_3_2ndPage.this, Clamping3_2_3_1stPage.class);
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
        Intent MainIntent = new Intent(Clamping3_2_3_2ndPage.this, MainPage.class);
        startActivity(MainIntent);
        finish();
    }

    public void displayClampingImagePopup() {
        android.app.AlertDialog.Builder imageDialog = new android.app.AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.layout_root));
        viewPager = (ViewPager) layout.findViewById(R.id.img);
        txtImageIndex = (TextView) layout.findViewById(R.id.txtImageIndex);
        txtTitle = (TextView) layout.findViewById(R.id.txtTitle);
        txtTitle.setText("Cable Clamping WARNING, CAUTION & NOTE");
        txtImageIndex.setText("Current Image: 1/5");
        Clamping3_2_3_2ndPage.ImagePagerAdapter adapter = new Clamping3_2_3_2ndPage.ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        imageDialog.setTitle("Examples of Cable Clamps used in aircraft");
        imageDialog.setView(layout);
        imageDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
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
                    txtTitle.setText("Cable Clamping WARNING, CAUTION & NOTE");
                }
                else if (position == 1) {
                    txtTitle.setText("Correct & Wrong Sizes of clamping");
                }
                else if (position == 2) {
                    txtTitle.setText("Danegrous & Safe clamping angles");
                }
                else if (position == 3) {
                    txtTitle.setText("Installing cable clamp to structurwe");
                }
                else if (position == 4) {
                    txtTitle.setText("Clamping at a bulkhead hole");
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
        final AlertDialog.Builder exitAlertBuilder = new AlertDialog.Builder(this);
        exitAlertBuilder.setIcon(R.drawable.caution);
        exitAlertBuilder.setTitle("Return to Contents");
        SpannableString ss = new SpannableString("Are you sure?");
        ss.setSpan(new RelativeSizeSpan(1.3f), 0, ss.length(), 0);
        exitAlertBuilder.setMessage(ss);
        exitAlertBuilder.setCancelable(false);
        exitAlertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goToMSAContents();
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

    public void goToMSAContents() {
        Intent MSAIntent = new Intent(Clamping3_2_3_2ndPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    private class ImagePagerAdapter extends PagerAdapter { //swipe image
        private int[] mImages = new int[]{
                R.drawable.clamp_installation_warning_caution_note,
                R.drawable.clamping_size,
                R.drawable.clamp_angle,
                R.drawable.clamp_structure,
                R.drawable.clamp_bulkhead,
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
            Context context = Clamping3_2_3_2ndPage.this;
            imgClamping = new ImageView(context);
            imgClamping.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imgClamping.setImageResource(mImages[position]);
            PhotoViewAttacher zoomImage = new PhotoViewAttacher(imgClamping);
            zoomImage.update();
            ((ViewPager) container).addView(imgClamping, 0);
            return imgClamping;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}

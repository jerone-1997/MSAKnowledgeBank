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

public class Chafing3_2_2_2ndPage extends AppCompatActivity {
    private FloatingActionButton btnBack;
    private ImageView imgChafing;
    private int page;
    private SeekBar seekMovePages;
    private TextView txtTitle, txtNext, txtPrevious, txtHeading, txtImageIndex, txtHyperLink1, txtHyperLink2;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chafing_3_2_2_2nd_page);
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
        seekMovePages.setMax(6);
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
                    Intent previousIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_1stPage.class);
                    startActivity(previousIntent);
                    finish();
                }
                else if (page == 3) {
                    Intent nextIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_3rdPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 4) {
                    Intent nextIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_4thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 5) {
                    Intent nextIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_5thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
                else if (page == 6) {
                    Intent nextIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_6thPage.class);
                    startActivity(nextIntent);
                    finish();
                }
            }
        });
        txtHeading.setText(Html.fromHtml("<p><u>Chafing Protection Procedures</u></p>"));
        SpannableString ss1 = new SpannableString("Different types of Chafing Protection");
        ss1.setSpan(new UnderlineSpan(), 0, ss1.length(), 0);
        SpannableString ss2 = new SpannableString("Chafing T.O. 1-1A-14 WP 010 00");
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
            public void onClick(View view) {
                Intent nextIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_3rdPage.class);
                startActivity(nextIntent);
                finish();
            }
        });
        txtPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousIntent = new Intent(Chafing3_2_2_2ndPage.this, Chafing3_2_2_1stPage.class);
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
        Intent MainIntent = new Intent(Chafing3_2_2_2ndPage.this, MainPage.class);
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
        txtTitle.setText("Chafing procedures CAUTION");
        txtImageIndex.setText("Current Image: 1/8");
        Chafing3_2_2_2ndPage.ImagePagerAdapter adapter = new Chafing3_2_2_2ndPage.ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        imageDialog.setTitle("Different types of Chafing Protection");
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
                txtImageIndex.setText("Current Image: " + String.valueOf(position + 1) + "/" + "8");
                if (position == 0) {
                    txtTitle.setText("Chafing procedures CAUTION");
                }
                else if (position == 1) {
                    txtTitle.setText("Spiral Chafe Wrap CAUTION");
                }
                else if (position == 2) {
                    txtTitle.setText("Example of spiral wrap installation");
                }
                else if (position == 3) {
                    txtTitle.setText("Example of a teflon sheet");
                }
                else if (position == 4) {
                    txtTitle.setText("Example of a teflon shield installation");
                }
                else if (position == 5) {
                    txtTitle.setText("Example of expendable sleeve shield installation");
                }
                else if (position == 6) {
                    txtTitle.setText("Example of expendable sleeve shield termination");
                }
                else if (position == 7) {
                    txtTitle.setText("Different sizes of expendable sleeving");
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
        Intent MSAIntent = new Intent(Chafing3_2_2_2ndPage.this, ContentsPage.class);
        startActivity(MSAIntent);
        finish();
    }

    private class ImagePagerAdapter extends PagerAdapter { //swipe image
        private int[] mImages = new int[]{
                R.drawable.chafing_protection_procedures_caution,
                R.drawable.spiral_chafe_caution,
                R.drawable.spiral_wrap_installation,
                R.drawable.teflon_sheet,
                R.drawable.teflon_shield_installation,
                R.drawable.expendable_sleeve_installation,
                R.drawable.expendable_sleeve_termination,
                R.drawable.expendale_sleeve_sizes,
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
            Context context = Chafing3_2_2_2ndPage.this;
            imgChafing = new ImageView(context);
            imgChafing.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imgChafing.setImageResource(mImages[position]);
            PhotoViewAttacher zoomImage = new PhotoViewAttacher(imgChafing);
            zoomImage.update();
            ((ViewPager) container).addView(imgChafing, 0);
            return imgChafing;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}
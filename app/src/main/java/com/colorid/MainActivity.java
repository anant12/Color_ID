package com.colorid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button xButton;
    Button helpButton;
    int REQUEST_CODE = 1;
    ImageView imageView;
    TextView colorText;
    boolean pictureTaken;
    Bitmap bitMap;
    int colorThing;
    HashMap<int[], String> colorConstants;
    String[] whites;
    boolean pictureMode;
    AlertDialog helpMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        xButton = (Button) findViewById(R.id.x_button);
        helpButton = (Button) findViewById(R.id.help_button);
        imageView = (ImageView) findViewById(R.id.imageView);
        colorText = (TextView) findViewById(R.id.colorText);
        pictureTaken = false;
        pictureMode = false;
        colorConstants = new HashMap<>();

        whites = new String[] {"#FFFFFF", "#FFFAFA", "#F0FFF0", "#F5FFFA", "#F0FFFF", "#F0F8FF", "#F8F8FF", "#F5F5F5", "#FFF5EE", "#F5F5DC", "#FDF5E6", "#FFFAF0", "#FFFFF0"};
        for (String color:whites)
            colorConstants.put(asColorVector(Color.parseColor(color)), "White");

        colorConstants.put(asColorVector(Color.BLACK), "Black");
        colorConstants.put(asColorVector(Color.DKGRAY), "Gray");
        colorConstants.put(asColorVector(Color.LTGRAY), "Gray");
        colorConstants.put(asColorVector(Color.GRAY), "Gray");

//        colorConstants.put(Color.LTGRAY, "Light Gray");
        colorConstants.put(asColorVector(Color.WHITE), "White");
        colorConstants.put(asColorVector(Color.parseColor("#d3d3d3")), "White");
        colorConstants.put(asColorVector(Color.parseColor("#dcdcdc")), "White");


        colorConstants.put(asColorVector(Color.YELLOW), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#fffacd")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#fafad2")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#ffe4b5")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#ffdab9")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#eee8aa")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#f0e68c")), "Yellow");
        colorConstants.put(asColorVector(Color.parseColor("#ffd700")), "Yellow");

//        colorConstants.put(asColorVector(Color.parseColor("#a52a2a")), "Brown");
//        colorConstants.put(asColorVector(Color.parseColor("#a0522d")), "Brown");
        colorConstants.put(asColorVector(Color.parseColor("#8b4513")), "Brown");
////        colorConstants.put(asColorVector(Color.parseColor("#d2691e")), "Brown");
//        colorConstants.put(asColorVector(Color.parseColor("#cd853f")), "Brown");
//        colorConstants.put(asColorVector(Color.parseColor("#b8860b")), "Brown");
////        colorConstants.put(asColorVector(Color.parseColor("#daa520")), "Brown");
////        colorConstants.put(asColorVector(Color.parseColor("#f4a460")), "Brown");
//        colorConstants.put(asColorVector(Color.parseColor("#deb887")), "Brown");


        colorConstants.put(asColorVector(Color.parseColor("#ff9900")), "Orange");
        colorConstants.put(asColorVector(Color.parseColor("#ffa500")), "Orange");
        colorConstants.put(asColorVector(Color.parseColor("#ff8c00")), "Orange");
        colorConstants.put(asColorVector(Color.parseColor("#ff7f50")), "Orange");
        colorConstants.put(asColorVector(Color.parseColor("#ffa07a")), "Orange");

        colorConstants.put(asColorVector(Color.RED), "Red");
        colorConstants.put(asColorVector(Color.parseColor("#fa8072")), "Salmon");
        colorConstants.put(asColorVector(Color.parseColor("#f08080")), "Salmon");
        colorConstants.put(asColorVector(Color.parseColor("#dc143c")), "Red");
        colorConstants.put(asColorVector(Color.parseColor("#b22222")), "Red");
        colorConstants.put(asColorVector(Color.parseColor("#8b0000")), "Red");

        colorConstants.put(asColorVector(Color.parseColor("#008000")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#32cd32")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#7cfc00")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#adff2f")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#00ff7f")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#228b22")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#006400")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#98fb98")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#90ee90")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#66cdaa")), "Green");
        colorConstants.put(asColorVector(Color.parseColor("#9acd32")), "Green");
        colorConstants.put(asColorVector(Color.GREEN), "Lime Green");

        colorConstants.put(asColorVector(Color.parseColor("#ffc0cb")), "Pink");
        colorConstants.put(asColorVector(Color.parseColor("#ffb6c1")), "Pink");
        colorConstants.put(asColorVector(Color.parseColor("#ff69b4")), "Pink");
        colorConstants.put(asColorVector(Color.parseColor("#ff1493")), "Pink");
        colorConstants.put(asColorVector(Color.parseColor("#db7093")), "Pink");
        colorConstants.put(asColorVector(Color.parseColor("#c71585")), "Pink");

        colorConstants.put(asColorVector(Color.CYAN), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#e0ffff")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#afeeee")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#7fffd4")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#40e0d0")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#48d1cc")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#00ced1")), "Cyan");
        colorConstants.put(asColorVector(Color.parseColor("#20b2aa")), "Cyan");

        colorConstants.put(asColorVector(Color.BLUE), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#000080")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#0000cd")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#4169e1")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#4682b4")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#6495ed")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#1e90ff")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#00bfff")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#87cefa")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#add8e6")), "Blue");
        colorConstants.put(asColorVector(Color.parseColor("#b0e0e6")), "Blue");

        colorConstants.put(asColorVector(Color.MAGENTA), "Magenta");
        colorConstants.put(asColorVector(Color.parseColor("#d8bfd8")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#dda0dd")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#ee82ee")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#da70d6")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#ba55d3")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#9370db")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#8a2be2")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#9400d3")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#9932cc")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#800080")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#4b0082")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#663399")), "Purple");
        colorConstants.put(asColorVector(Color.parseColor("#6a5acd")), "Purple");

        colorConstants.put(asColorVector(Color.WHITE), "White");
        colorConstants.put(asColorVector(Color.parseColor("#fffafa")), "White");
        colorConstants.put(asColorVector(Color.parseColor("#f8f8ff")), "White");
        colorConstants.put(asColorVector(Color.parseColor("#fffff0")), "White");

        DialogInterface.OnClickListener okay = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        final AlertDialog.Builder help = new AlertDialog.Builder(this);
        help.setMessage("Tap on any part of the photo to identify that color! At the bottom of the screen are the three most likely colors, from left to right. Enjoy!");
        help.setPositiveButton("GOT IT!", okay);
        help.setTitle("Help");
        helpMessage = help.create();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE);
        }

        xButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureTaken = false;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_CODE);
                }
                colorText.setText("");
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpMessage.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                bitMap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitMap);
                pictureTaken = true;
            }
        }

    }

    //takes in an int value which represents a color and returns a String corresponding to the color name.
    public String getColorName(int colorVal){
        String name1 = "";
        String name2 = "";
        String name3 = "";
        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;
        int diff3 = Integer.MAX_VALUE;
        for(int[] num:colorConstants.keySet()){
            int tempDiff = vectorDifference(num, asColorVector(colorVal));
            if (name1.equals("")){
                name1 = colorConstants.get(num);
                diff1 = tempDiff;
            }
            else if (name2.equals("")){
                name2 = colorConstants.get(num);
                diff2 = tempDiff;
            }
            else if (name3.equals("")){
                name3 = colorConstants.get(num);
                diff3 = tempDiff;
            }
            else{
                if(tempDiff < diff1){
                    diff3 = diff2;
                    diff2 = diff1;
                    diff1 = tempDiff;

                    name3 = name2;
                    name2 = name1;
                    name1 = colorConstants.get(num);
                }
                else if (tempDiff < diff2){
                    diff3 = diff2;
                    diff2 = tempDiff;

                    name3 = name2;
                    name2 = colorConstants.get(num);
                }
                else if (tempDiff < diff3) {
                    diff3 = tempDiff;

                    name3 = colorConstants.get(num);
                }
            }
        }
        return name1 + ", " + name2 + ", " + name3;
    }

    public int[] asColorVector(int color){
        int[] colorVector = new int[3];

        colorVector[0] = Color.red(color);
        colorVector[1] = Color.green(color);
        colorVector[2] = Color.blue(color);

        return colorVector;
    }

    public int vectorDifference(int[] vector1, int[] vector2){
        int rDiff = vector2[0] - vector1[0];
        int gDiff = vector2[1] - vector1[1];
        int bDiff = vector2[2] - vector1[2];

        return ((rDiff*rDiff) + (gDiff*gDiff) + (bDiff*bDiff));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){

        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                colorText.setText("");
                break;
            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                if(pictureTaken) {
                    colorText.setVisibility(View.VISIBLE);
                    colorThing = bitMap.getPixel((int) (eventX*bitMap.getWidth()/imageView.getWidth()), (int) (eventY*bitMap.getHeight()/imageView.getHeight()));
//                    colorText.setText(Color.red(colorThing) + ", " + Color.green(colorThing) + ", " + Color.blue(colorThing));
                    System.out.println("R: " + Color.red(colorThing) + ", G: " + Color.green(colorThing) + ", B: " + Color.blue(colorThing));
                    Log.i("RGB VALUES: ", "R: " + Color.red(colorThing) + ", G: " + Color.green(colorThing) + ", B: " + Color.blue(colorThing));
                    colorText.setText(getColorName(colorThing));
//                    colorText.setTextColor(Color.WHITE);
//                    colorText.set
                    colorText.setGravity(Gravity.CENTER);
                }
                else{
                    colorText.setVisibility(View.INVISIBLE);
                }


                break;

            default:
                return false;
        }
        //Makes our view repaint and call onDraw
        return true;
    }
}
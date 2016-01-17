///*package com.colorid;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.HashMap;
//
///**
// * Created by Richard Zhang on 1/16/2016.
// */
//public class DisplayPictureActivity extends Activity {
//    //ImageView imageView;
//    TextView colorText;
//    int colorThing;
//    HashMap<int[], String> colorConstants;
////    Bitmap bitmap;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        MainActivity.imageView = (ImageView) findViewById(R.id.imageView);
//        setContentView(R.layout.activity_main);
//
//        super.onCreate(savedInstanceState);
//        Intent intent = getIntent();
//        System.out.println(MainActivity.bitMap.getWidth() + "BITMAP");
//        MainActivity.imageView.setImageBitmap(MainActivity.bitMap);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//
//        float eventX = event.getX();
//        float eventY = event.getY();
//
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                colorText.setText("");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                break;
//
//            case MotionEvent.ACTION_UP:
//                //if(pictureTaken) {
//                    colorText.setVisibility(View.VISIBLE);
//                    colorThing = MainActivity.bitMap.getPixel((int) (eventX*MainActivity.bitMap.getWidth()/MainActivity.imageView.getWidth()), (int) (eventY*MainActivity.bitMap.getHeight()/MainActivity.imageView.getHeight()));
////                    colorText.setText(Color.red(colorThing) + ", " + Color.green(colorThing) + ", " + Color.blue(colorThing));
//                    System.out.println("R: " + Color.red(colorThing) + ", G: " + Color.green(colorThing) + ", B: " + Color.blue(colorThing));
//                    Log.i("RGB VALUES: ", "R: " + Color.red(colorThing) + ", G: " + Color.green(colorThing) + ", B: " + Color.blue(colorThing));
//                    colorText.setText(getColorName(colorThing));
////                    colorText.setTextColor(Color.WHITE);
////                    colorText.set
//                    colorText.setGravity(Gravity.CENTER);
//                //}
//
//
//                break;
//
//            default:
//                return false;
//        }
//        //Makes our view repaint and call onDraw
//        return true;
//    }
//
//    //takes in an int value which represents a color and returns a String corresponding to the color name.
//    public String getColorName(int colorVal){
//        String name1 = "";
//        String name2 = "";
//        String name3 = "";
//        int diff1 = Integer.MAX_VALUE;
//        int diff2 = Integer.MAX_VALUE;
//        int diff3 = Integer.MAX_VALUE;
//        for(int[] num:colorConstants.keySet()){
//            int tempDiff = vectorDifference(num, asColorVector(colorVal));
//            if (name1.equals("")){
//                name1 = colorConstants.get(num);
//                diff1 = tempDiff;
//            }
//            else if (name2.equals("")){
//                name2 = colorConstants.get(num);
//                diff2 = tempDiff;
//            }
//            else if (name3.equals("")){
//                name3 = colorConstants.get(num);
//                diff3 = tempDiff;
//            }
//            else{
//                if(tempDiff < diff1){
//                    diff3 = diff2;
//                    diff2 = diff1;
//                    diff1 = tempDiff;
//
//                    name3 = name2;
//                    name2 = name1;
//                    name1 = colorConstants.get(num);
//                }
//                else if (tempDiff < diff2){
//                    diff3 = diff2;
//                    diff2 = tempDiff;
//
//                    name3 = name2;
//                    name2 = colorConstants.get(num);
//                }
//                else if (tempDiff < diff3) {
//                    diff3 = tempDiff;
//
//                    name3 = colorConstants.get(num);
//                }
//            }
//        }
//        return name1 + ", " + name2 + ", " + name3;
//    }
//
//    public int[] asColorVector(int color){
//        int[] colorVector = new int[3];
//
//        colorVector[0] = Color.red(color);
//        colorVector[1] = Color.green(color);
//        colorVector[2] = Color.blue(color);
//
//        return colorVector;
//    }
//
//    public int vectorDifference(int[] vector1, int[] vector2){
//        int rDiff = vector2[0] - vector1[0];
//        int gDiff = vector2[1] - vector1[1];
//        int bDiff = vector2[2] - vector1[2];
//
//        return ((rDiff*rDiff) + (gDiff*gDiff) + (bDiff*bDiff));
//    }
//}

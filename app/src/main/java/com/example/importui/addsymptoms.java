package com.example.importui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class addsymptoms extends AppCompatActivity {
    TextView tvsymp;
    Button btnchoice,btnnext;
    String [] listitems;
    boolean [] checkeditmes;
    ArrayList<Integer> mUseritem = new ArrayList <>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsymptoms);
        try{
            btnchoice = (Button) findViewById(R.id.btnsymp);
            tvsymp = (TextView) findViewById(R.id.tv1);
            listitems = getResources().getStringArray(R.array.Symptoms);
            checkeditmes = new boolean[listitems.length];
            btnnext = (Button) findViewById(R.id.btnnext);

        /*    btnnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(addsymptoms.this, );
                    startActivity(in);
                }
            });*/
            btnchoice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder mBuilder = new AlertDialog.Builder(addsymptoms.this);
                    mBuilder.setTitle(R.string.dialog_title);

                    mBuilder.setMultiChoiceItems(listitems, checkeditmes, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int pos, boolean ischeck) {
                            if (ischeck) {
                                if (! mUseritem.contains(pos)) {
                                    mUseritem.add(pos);
                                }
                            }
                            else if (mUseritem.contains(pos)) {
                                mUseritem.remove(pos);
                            }
                        }
                    });
                    mBuilder.setCancelable(false);
                    mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        //Display The Item In Textview
                        public void onClick(DialogInterface dialog, int which) {
                            String item = "  Selected Symptoms\n-> ";
                            for (int i = 0; i < mUseritem.size(); i++) {
                                item = item + listitems[mUseritem.get(i)];
                                //Selected item in  new line
                                if (i != mUseritem.size() - 1) {
                                    item = item + "\n-> ";
                                }
                            }
                            tvsymp.setText(item);
                        }
                    });
                    //Button Dismiss
                    mBuilder.setNegativeButton(R.string.dismiss_lable, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    //Button ClearAll
                    mBuilder.setNeutralButton(R.string.clear_all, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for (int i = 0; i < checkeditmes.length; i++) {
                                checkeditmes[i] = false;
                                mUseritem.clear();
                                tvsymp.setText("");
                            }
                        }
                    });
                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();
                }

            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

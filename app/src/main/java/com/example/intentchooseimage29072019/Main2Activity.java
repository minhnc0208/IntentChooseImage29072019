package com.example.intentchooseimage29072019;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> mangAlbum;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tableLayout = findViewById(R.id.tableLayout);
        mangAlbum = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.array_Animals)));
//        int valueHinhChon = getResources().getIdentifier(mangAlbum.get(index), "drawable", R.array.array_Animals);


        // cot  = 3 => ImageView
        // dong = 6 => tableRow
        int dong = 6;
        int cot = 3;
        for (int i = 0; i < dong; i++) {
            TableRow tableRow = new TableRow(this);

            for (int y = 0; y < cot; y++) {
                ImageView imageView = new ImageView(this);
                final int index = cot * i + y;
                if (index >= mangAlbum.size()) {
                    break;

//                    imageView.setImageResource(0);
                } else {
                    final int valueHinhchon = getResources().getIdentifier(mangAlbum.get(index), "drawable", getPackageName());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
                    layoutParams.setMargins(10, 0, 0, 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageResource(valueHinhchon);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            Toast.makeText(Main2Activity.this, mangAlbum.get(index), Toast.LENGTH_SHORT).show();
//
                            Intent intent = new Intent();
                            intent.putExtra("valueHinh", valueHinhchon);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    });
                }


//                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }
    }
}

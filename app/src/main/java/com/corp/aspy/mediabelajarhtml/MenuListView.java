package com.corp.aspy.mediabelajarhtml;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MenuListView extends AppCompatActivity {
    ListView listview;
    String[] mTitle = {"Introduction", "Style", "Formatting", "Colors", "Images Syntax", "Comment", "Evaluasi"};
    int image[] ={R.drawable.htmlico,R.drawable.htmlico,R.drawable.htmlico,R.drawable.htmlico,R.drawable.htmlico,R.drawable.htmlico,R.drawable.htmlico};
    private long backPressed;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list_view);
        listview = (ListView) findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this, mTitle, image);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 1){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 2){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 3){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 4){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 5){
                    Intent intent = new Intent(MenuListView.this, MateriView.class);
                    intent.putExtra("command", position+1);
                    startActivity(intent);
                    finish();
                }
                if (position == 6){
                    Intent intent = new Intent(MenuListView.this, Quiz.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        int rImg[];
        MyAdapter (Context c, String title[], int imgs[]){
            super (c, R.layout.row, R.id.judul, title);
            this.context = c;
            this.rTitle = title;
            this.rImg = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent,false);
            ImageView images = row.findViewById(R.id.imageHtml);
            TextView title = row.findViewById(R.id.judul);
            images.setImageResource(rImg[position]);
            title.setText(rTitle[position]);
            return row;
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            System.exit(0);
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "press again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressed = System.currentTimeMillis();
    }
}

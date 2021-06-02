package sg.edu.rp.c346.id20012912.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB ;
    String wordClicked = " ";

    boolean dbs = false;
    boolean ocbc = false;
    boolean uob = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.DBS);
        registerForContextMenu(DBS);

        OCBC = findViewById(R.id.OCBC);
        registerForContextMenu(OCBC);

        UOB = findViewById(R.id.UOB);
        registerForContextMenu(UOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() ==R.id.EnglishSelection)
        {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
        }

        else if(item.getItemId()== R.id.ChineseSelection)
        {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2, "Toggle favourite");

        if (v == DBS)
        {
            wordClicked = "DBS";
        }

        else if (v == OCBC )
        {
            wordClicked = "OCBC";
        }

        else if(v == UOB)
        {
            wordClicked = "UOB";
        }


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == 0)
        {

            if (wordClicked.equalsIgnoreCase("DBS"))
            {
                DBS.setText("DBS");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }

            if (wordClicked.equalsIgnoreCase("OCBC"))
            {
                OCBC.setText("OCBC");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }

            if (wordClicked.equalsIgnoreCase("UOB"))
            {
                UOB.setText("UOB");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }


        }

        if(item.getItemId() == 1)
        {
            if (wordClicked.equalsIgnoreCase("DBS"))
            {
                DBS.setText("DBS");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 111 1111"));
                startActivity(intent);
            }

            if (wordClicked.equalsIgnoreCase("OCBC"))
            {
                OCBC.setText("OCBC");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:11800 363 3333"));
                startActivity(intent);
            }

            if (wordClicked.equalsIgnoreCase("UOB"))
            {
                UOB.setText("UOB");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 222 2121"));
                startActivity(intent);
            }
        }

        if(item.getItemId() ==2)
        {
            if(wordClicked.equals("DBS"))
            {
                if(dbs == false)
                {
                    dbs = true;
                    DBS.setTextColor(Color.RED);
                }
                else
                {
                    DBS.setTextColor(Color.BLACK);
                }
            }

            if(wordClicked.equals("OCBC"))
            {
                if(ocbc == false)
                {
                    ocbc = true;
                    OCBC.setTextColor(Color.RED);
                }
                else
                {
                    OCBC.setTextColor(Color.BLACK);
                }
            }

            if(wordClicked.equals("UOB"))
            {
                if(uob == false)
                {
                    uob = true;
                    UOB.setTextColor(Color.RED);
                }
                else
                {
                    UOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }



}
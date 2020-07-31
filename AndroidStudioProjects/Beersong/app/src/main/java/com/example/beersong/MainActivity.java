package com.example.beersong;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protectedvoidonCreate(BundlesavedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbartoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButtonfab=findViewById(R.id.fab);
        fab.setOnClickListener(newView.OnClickListener(){
            @Override
                    publicvoidonClick(Viewview){
                Snackbar.make(view,"Replacewithyourownaction",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            }
        });
    }

    @Override
    publicbooleanonCreateOptionsMenu(Menumenu){
//Inflatethemenu;thisaddsitemstotheactionbarifitispresent.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        returntrue;
    }

    @Override
    publicbooleanonOptionsItemSelected(MenuItemitem){
//Handleactionbaritemclickshere.Theactionbarwill
//automaticallyhandleclicksontheHome/Upbutton,solong
//asyouspecifyaparentactivityinAndroidManifest.xml.
        intid=item.getItemId();

//noinspectionSimplifiableIfStatement
        if(id==R.id.action_settings){
            returntrue;
        }

        returnsuper.onOptionsItemSelected(item);
    }
}

    

}
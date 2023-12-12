package com.example.slidingnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sNavigationDrawer=findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems=new ArrayList<>();

        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("News",R.mipmap.ic_launcher));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Files",R.mipmap.ic_launcher));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Glucose",R.mipmap.ic_launcher));
        menuItems.add(new com.shrikanthravi.customnavigationdrawer2.data.MenuItem("Music",R.mipmap.ic_launcher));

        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass = NewsFragment.class;
        fragmentClass=FilesFragment.class;
        fragmentClass=GlucoseFragment.class;
        fragmentClass=MusicFragment.class;

        try {
            fragment=(Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

     if(fragment!=null)
     {
         FragmentManager fragmentManager=getSupportFragmentManager();
         fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();

     }



     sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
         @Override
         public void onDrawerOpening() {

         }

         @Override
         public void onDrawerClosing() {
             try {
                 fragment=(Fragment)fragmentClass.newInstance();
             } catch (IllegalAccessException e) {
                 throw new RuntimeException(e);
             } catch (InstantiationException e) {
                 throw new RuntimeException(e);
             }

             if(fragment!=null)
             {
                 FragmentManager fragmentManager=getSupportFragmentManager();
                 fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();

             }
         }

         @Override
         public void onDrawerOpened() {

         }

         @Override
         public void onDrawerClosed() {

         }

         @Override
         public void onDrawerStateChanged(int newState) {

         }
     });
    }
}
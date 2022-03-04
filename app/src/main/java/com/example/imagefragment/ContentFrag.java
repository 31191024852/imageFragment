package com.example.imagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ContentFrag extends Fragment {
    GridView gridView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.getRootView().findViewById(R.id.gridview);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            String s =adapterView.getItemAtPosition(i).toString();
            Intent intent = new Intent(view.getContext(), FullImage.class);
            intent.putExtra("url", s);
            startActivity(intent);
        });
        return view;
    }

    String[] fruit = {
            "https://cdn.pixabay.com/photo/2016/10/27/22/52/apples-1776744__480.jpg",
            "https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192__340.jpg",
            "https://cdn.pixabay.com/photo/2021/07/30/04/17/orange-6508617__340.jpg",
            "https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__340.jpg"
        };
    String[] animal = {
            "https://cdn.pixabay.com/photo/2012/06/19/10/32/owl-50267__480.jpg",
            "https://cdn.pixabay.com/photo/2018/08/12/16/59/parrot-3601194__340.jpg",
            "https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492__340.jpg",
            "https://cdn.pixabay.com/photo/2017/01/14/12/59/iceland-1979445__340.jpg",
        };
    String[] food = {
            "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg",
            "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062__340.jpg",
            "https://cdn.pixabay.com/photo/2017/01/26/02/06/platter-2009590__480.jpg",
            "https://cdn.pixabay.com/photo/2017/11/08/22/18/spaghetti-2931846__480.jpg",
        };


    public void updateContent(int position){
        switch (position){
            case 0:
                gridView.setAdapter(new ImageAdapter(getContext(),fruit));
                break;
            case 1:
                gridView.setAdapter(new ImageAdapter(getContext(),animal));
                break;
            case 2:
                gridView.setAdapter(new ImageAdapter(getContext(),food));
                break;
        }
    }
    
//    public void reUpdate(String url){
//        if(checkUrl(url,fruit)){
//            gridView.setAdapter(new ImageAdapter(getContext(),fruit));
//        }else if (checkUrl(url, animal)){
//            gridView.setAdapter(new ImageAdapter(getContext(),animal));
//        }else if (checkUrl(url,food)){
//            gridView.setAdapter(new ImageAdapter(getContext(),food));
//        }else{
//            Toast.makeText(getActivity(),"Lỗi Tải Ảnh", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    public boolean checkUrl(String url, String[] urls){
//        for (String s : urls) {
//            if (url.equals(s)) {
//                return true;
//            }
//        }
//        return false;
//    }




}

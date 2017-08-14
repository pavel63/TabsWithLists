package com.pavelwinter.tabs; /**
 * Created by newuser on 16.01.2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.pavelwinter.tabs.R.id.tvPage;

public class PageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backColor;


    RecyclerView recyclerView;
    LinearLayoutManager mLinearLayoutManager;
    List<MockItemovDo> listMm;



    int itemov;



    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();

        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));



       //just for example,shows number of page
        itemov=(pageNumber+1)*10;

        //here we populate current list
        listMm=new ArrayList<>();
        for (int i=0;i<itemov;i++){

            Random random=new Random();
            int r=random.nextInt(3);

            listMm.add(new MockItemovDo("Name"+i,"Description "+i,r));

        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);



        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);



      recyclerView.setAdapter(new ListsAdapter(listMm));





        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        //TextView tvPage2 = (TextView) view.findViewById(R.id.tvPage2);
        tvPage.setText("Page " + pageNumber);
       // tvPage2.setText("Page2 " + pageNumber);
        tvPage.setBackgroundColor(backColor);

        return view;
    }
}
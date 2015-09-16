package goreach.me.staggeredlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    private ArrayList<String> myDataset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_staggered_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new StaggeredListAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        addDataToDataSet();
    }

    private void addDataToDataSet() {
        myDataset.clear();

        for (int i = 0; i < 10; i++) {
            myDataset.add("Item " + Integer.toString(i));
        }

        mAdapter.notifyDataSetChanged();
    }
}

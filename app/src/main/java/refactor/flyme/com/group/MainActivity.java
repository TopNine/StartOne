package refactor.flyme.com.group;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import entry.HomePage;
import iface.IOnItemClickListener;
import widge.BaseDialogFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "UI.MainActivity";
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private List<HomePage> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void loadData() {
        mItems.add(new HomePage.Builder().setIcon(R.drawable.ic_launcher).setText("test dialog").build());
        mAdapter.setItems(mItems);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new MainAdapter(mItems);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnClickListener(new IOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        showDialogFragment();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void showDialogFragment() {
        BaseDialogFragment dialogFragment = new BaseDialogFragment();
        dialogFragment.setDialogCallback(new BaseDialogFragment.DialogCallback() {
            @Override
            public void onOk() {
                Toast.makeText(MainActivity.this, "test dialog", Toast.LENGTH_LONG).show();
            }
        });
        Log.i(TAG, "dialogFragment: " + dialogFragment.toString());
        dialogFragment.show(getSupportFragmentManager(), "base dialog show");
    }
}

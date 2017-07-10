package widge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import refactor.flyme.com.group.R;

/**
 * Created by msi on 2017/6/7.
 */

public  class BaseDialogFragment extends DialogFragment {
    private static final String TAG = "BaseDialogFragment";

//    public abstract void onOk();

    public interface DialogCallback {
        void onOk();
    }

    private DialogCallback callback;

    public BaseDialogFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_dialog_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onOk();
//                onOk();
            }
        });
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e) {
            Log.e(TAG, "show: exception" + e);
        }
    }

    public void setDialogCallback(DialogCallback callback) {
        this.callback = callback;
    }
}

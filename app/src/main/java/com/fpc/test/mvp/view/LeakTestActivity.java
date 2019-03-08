package com.fpc.test.mvp.view;

import android.os.Bundle;

import com.fpc.test.R;
import com.fpc.test.databinding.ActivityMvpLeakBinding;
import com.fpc.test.mvp.bean.OneSentence;
import com.fpc.test.mvp.presenter.TestPresenter;
import com.fzy.libs.utils.FLog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


public class LeakTestActivity extends AppCompatActivity implements ITestView {

    ActivityMvpLeakBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvp_leak);
        binding.btnGet.setOnClickListener(v -> {
            new TestPresenter(this).getOneSentence();
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FLog.w("LeakTestActivity.onDestroy()");
    }

    @Override
    public String getDate() {
        return /*et_date.getText().toString()*/"";
    }

    @Override
    public void clearResult() {
//        tv_result.setText("");
    }

    @Override
    public void clearDate() {
//        tv_result.setText("");
    }

    @Override
    public void showData(OneSentence data) {
//        tv_result.setTextColor(Color.WHITE);
//        tv_result.setText(data.toString());
    }

    @Override
    public void showError(String msg) {
//        tv_result.setTextColor(Color.RED);
//        tv_result.setText(msg);
    }
}

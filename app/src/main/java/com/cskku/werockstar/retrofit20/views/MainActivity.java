package com.cskku.werockstar.retrofit20.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.cskku.werockstar.retrofit20.R;
import com.cskku.werockstar.retrofit20.adapters.GithubAdapter;
import com.cskku.werockstar.retrofit20.models.Github;
import com.cskku.werockstar.retrofit20.services.GithubService;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private EditText mUsername;
    private Button mSearch;
    private RelativeLayout rootLayout;
    private ProgressDialog dialog;

    private String BASE_URL = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialViews();
        setupViews();

    }

    private void loadService(final String user) {

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        Call<Github> call = service.getUserInfo(user);
        call.enqueue(new Callback<Github>() {
            @Override
            public void onResponse(Response<Github> response, Retrofit retrofit) {
                if (response.body() != null) {
                    dialog.cancel();

                    List<Github> list = new ArrayList<Github>();
                    list.add(response.body());
                    GithubAdapter adapter = new GithubAdapter(list);
                    mList.setAdapter(adapter);
                } else {
                    dialog.cancel();
                    Snackbar.make(rootLayout, "Service null", Snackbar.LENGTH_LONG)
                            .setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    loadService(user);
                                }
                            }).setActionTextColor(Color.GRAY)
                            .show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.cancel();
                Log.e("ERROR", t.getMessage());
                Snackbar.make(rootLayout, "Not connect", Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                loadService(user);
                            }
                        }).setActionTextColor(Color.WHITE)
                        .show();
            }
        });

    }

    public void initialViews() {
        mList = (RecyclerView) findViewById(R.id.list);
        mSearch = (Button) findViewById(R.id.btnSearch);
        mUsername = (EditText) findViewById(R.id.edtUser);
        rootLayout = (RelativeLayout) findViewById(R.id.root);
    }

    public void setupViews() {
        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mUsername.getText().toString();
                loadService(user);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

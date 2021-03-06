package net.cattaka.android.proteanlayoutexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import net.cattaka.android.proteanlayoutexample.core.IShowDetail;
import net.cattaka.android.proteanlayoutexample.data.CatEntry;
import net.cattaka.android.proteanlayoutexample.fragment.TopPagerFragment;

public class TopActivity extends AppCompatActivity implements IShowDetail {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getSupportFragmentManager().findFragmentById(R.id.frame_primary) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_primary, new TopPagerFragment(), null)
                    .commit();
        }
    }

    @Override
    public void showDetail(@NonNull CatEntry entry) {
        startActivity(CatDetailActivity.createIntent(this, entry));
    }
}

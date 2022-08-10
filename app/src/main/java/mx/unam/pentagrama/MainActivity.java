package mx.unam.pentagrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfMyRefreshIndicator;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFav();

        sfMyRefreshIndicator = findViewById(R.id.sfMyRefreshIndicator);
        myList = findViewById(R.id.lstMyListView);

        String[] planets = getResources().getStringArray(R.array.planets);
        myList.setAdapter(new ArrayAdapter<>(this, R.layout.simple_list_item_1, planets));
        sfMyRefreshIndicator.setOnRefreshListener(this::refreshingContent);
    }

    public void refreshingContent(){
        String[] planets = getResources().getStringArray(R.array.planets);
        myList.setAdapter(new ArrayAdapter<>(this, R.layout.simple_list_item_1, planets));
        sfMyRefreshIndicator.setRefreshing(false);
    }

    public void addFav() {
        FloatingActionButton myFav = findViewById(R.id.favMyFav);
        myFav.setOnClickListener(view -> Snackbar.make(view,
            getResources().getString(R.string.message), Snackbar.LENGTH_SHORT)
                .setAction(getResources().getString(R.string.action_text),
                    view1 -> Log.i("SnackBar", "Click en SnackBar"))
                .show());
    }
}
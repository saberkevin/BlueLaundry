package binuslabproject.bluelaundry;

import android.text.Layout;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ClothingFragment extends Fragment {

    private String names[] = {"Jerry","Tom","Nibbles","Jerry","Tom","Nibbles","Jerry","Tom","Nibbles"};
    private String prices[] = {"Jerry the Khintil","Tom the Ferguso","Nibbles the Nibba",
            "Jerry the Khintil","Tom the Ferguso","Nibbles the Nibba",
            "Jerry the Khintil","Tom the Ferguso","Nibbles the Nibba"};
    private ListView listView;

    public ClothingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clothing, container, false);
        listView = view.findViewById(R.id.myListView);
        Myadapter myadapter = new Myadapter();
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ClothingFragment.super.getContext(), names[position], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public class Myadapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.item_list, null);
            TextView nameText = view.findViewById(R.id.item_name);
            TextView priceText = view.findViewById(R.id.item_price);

            nameText.setText(names[position]);
            priceText.setText(prices[position]);

            return view;
        }
    }

}

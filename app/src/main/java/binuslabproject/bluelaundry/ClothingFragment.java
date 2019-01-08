package binuslabproject.bluelaundry;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class ClothingFragment extends Fragment {
    private String[] names = {"Kaos","Kemeja","Celana Panjang","Celana Pendek","Jaket","Hoodie"};
    private String[] prices = {"10000","20000","30000","40000","50000","60000"};
    private String[] desc = {"Kaos","Kemeja","Celana Panjang","Celana Pendek","Jaket","Hoodie"};
    private ListView listView;

    public ClothingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothing, container, false);
        listView = view.findViewById(R.id.myListView);
        Myadapter myadapter = new Myadapter();
        listView.setAdapter(myadapter);

        //OnClick event listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Throwing item data through intent param
                Intent intent = new Intent(ClothingFragment.this.getActivity(), DetailItemActivity.class);
                intent.putExtra("itemName",names[position]);
                intent.putExtra("itemPrice",prices[position]);
                intent.putExtra("itemDesc",desc[position]);
                startActivity(intent);
                Toast.makeText(ClothingFragment.super.getContext(), names[position], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public class Myadapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return names.length;
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

            String price = "Rp. "+prices[position];
            priceText.setText(price);

            return view;
        }
    }

}

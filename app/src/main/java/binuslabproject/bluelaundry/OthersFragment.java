package binuslabproject.bluelaundry;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OthersFragment extends Fragment {

    private String[] names = {"Bed Cover","Bantal","Selimut","Karpet","Taplak Meja","Tirai"};
    private String[] prices = {"12000","23000","34000","45000","56000","67000"};
    private ListView listView;

    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothing, container, false);
        listView = view.findViewById(R.id.myListView);
        OthersFragment.Myadapter myadapter = new OthersFragment.Myadapter();
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Throwing item data through intent param
                Intent intent = new Intent(OthersFragment.this.getActivity(), DetailItemActivity.class);
                intent.putExtra("itemName",names[position]);
                intent.putExtra("itemPrice",prices[position]);
                startActivity(intent);
                Toast.makeText(OthersFragment.super.getContext(), names[position], Toast.LENGTH_SHORT).show();
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
            priceText.setText(prices[position]);

            return view;
        }
    }

}

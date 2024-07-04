package naimul.islam.n01586149lab7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class PersonFragment extends Fragment {
    ListView listView;
    String[] provinces;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        listView = view.findViewById(R.id.listViewProvinces);
        provinces = getResources().getStringArray(R.array.provinces);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_activated_1, provinces);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("PROVINCE", provinces[position]);
            bundle.putInt("INDEX", position + 1);
            getParentFragmentManager().setFragmentResult("provinceSelection", bundle);
        });

        return view;
    }
}

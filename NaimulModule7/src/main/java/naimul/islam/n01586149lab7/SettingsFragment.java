package naimul.islam.n01586149lab7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class SettingsFragment extends Fragment {
    TextView textViewProvince, textViewIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        textViewProvince = view.findViewById(R.id.NaiProvinceTextView);
        textViewIndex = view.findViewById(R.id.NaiIndexTextView);

        TextClock textClock = view.findViewById(R.id.NaiTextClock);
        textClock.setFormat12Hour(null);
        textClock.setFormat24Hour("dd-MM-yyyy \n HH:mm:ss");

        textViewProvince.setText("province");
        textViewIndex.setText("INDEX");


        getParentFragmentManager().setFragmentResultListener("provinceSelection", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(String requestKey, Bundle result) {
                String province = result.getString("PROVINCE");
                int index = result.getInt("INDEX");
                textViewProvince.setText(province);
                textViewIndex.setText(String.valueOf(index));
                textViewIndex.setTextColor(getColorByProvince(province));
            }
        });

        return view;
    }

    private int getColorByProvince(String province) {
        switch (province) {
            case "Ontario":
                return Color.RED;
            case "Quebec":
                return Color.GREEN;
            default:
                return Color.BLUE; // Default color if not specified
        }
    }
}

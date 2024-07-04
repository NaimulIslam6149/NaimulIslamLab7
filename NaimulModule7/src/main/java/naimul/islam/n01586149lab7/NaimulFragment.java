package naimul.islam.n01586149lab7;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;

public class NaimulFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_naimul, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = view.findViewById(checkedId);
                showDialog(radioButton.getText().toString());
            }
        });

        return view;
    }

    private void showDialog(String radioButtonLabel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.football)  // Ensure you have a drawable
                .setTitle("Naimul Islam")
                .setMessage(radioButtonLabel)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setCancelable(false)
                .show();
    }
}

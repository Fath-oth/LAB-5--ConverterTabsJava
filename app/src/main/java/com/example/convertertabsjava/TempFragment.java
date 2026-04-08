package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TempFragment extends Fragment {

    RadioGroup rgTemp;
    RadioButton rbCtoF, rbFtoC;
    EditText etTempInput;
    Button btnConvertTemp;
    TextView tvTempResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        rgTemp = view.findViewById(R.id.rgTemp);
        rbCtoF = view.findViewById(R.id.rbCtoF);
        rbFtoC = view.findViewById(R.id.rbFtoC);
        etTempInput = view.findViewById(R.id.etTempInput);
        btnConvertTemp = view.findViewById(R.id.btnConvertTemp);
        tvTempResult = view.findViewById(R.id.tvTempResult);

        btnConvertTemp.setOnClickListener(v -> {
            String input = etTempInput.getText().toString();
            if (TextUtils.isEmpty(input)) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double val = Double.parseDouble(input);
            double result;

            if (rbCtoF.isChecked())
                result = (1.8 * val) + 32;
            else
                result = (val - 32) / 1.8;

            tvTempResult.setText("Résultat : " + String.format("%.2f", result));
        });

        return view;
    }
}
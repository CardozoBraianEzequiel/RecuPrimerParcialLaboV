package com.utn.recuperatoriopp;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoView {
    EditarAutoActivity editarAutoActivity;
    Auto auto;
    String[] years = new String[]{"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
    public AutoView(EditarAutoActivity editarAutoActivity, Auto auto) {
        this.editarAutoActivity = editarAutoActivity;
        this.auto = auto;
    }

    public void cargarPantalla() {
        //Recuperar elementos
        EditText edMake = this.editarAutoActivity.findViewById(R.id.edMarca);
        EditText edModel = this.editarAutoActivity.findViewById(R.id.edModelo);
        Spinner spYear = this.editarAutoActivity.findViewById(R.id.spAnio);
        Button btnEditar = this.editarAutoActivity.findViewById(R.id.btnEditar);
        EditarClick editarClick = new EditarClick(this.editarAutoActivity);
        btnEditar.setOnClickListener(editarClick);

        edMake.setText(this.auto.getMake());
        edModel.setText(this.auto.getModel().toString());
        final List<String> yearsList = new ArrayList<>(Arrays.asList(years));
        spYear.setAdapter(new ArrayAdapter<String>(editarAutoActivity,
                R.layout.support_simple_spinner_dropdown_item,
                yearsList));

        spYear.setSelection(yearsList.indexOf(this.auto.getYear().toString()));
    }

}

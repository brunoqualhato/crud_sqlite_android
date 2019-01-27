package qualhato.crud_sqlite.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import qualhato.crud_sqlite.R;
import qualhato.crud_sqlite.adapters.PessoaAdapter;
import qualhato.crud_sqlite.controller.PessoaDAO;


public class Listar extends Fragment implements PessoaAdapter.ItemClickListener {
    PessoaAdapter pessoaAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar, container, false);
        PessoaDAO oPessoaDAO = new PessoaDAO(view.getContext());

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recicler_pessoa);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        pessoaAdapter = new PessoaAdapter(view.getContext(),oPessoaDAO.retornarPessoas());
        pessoaAdapter.setClickListener(this);
        recyclerView.setAdapter(pessoaAdapter);

        return view;
    }


    @Override
    public void onItemClick(View view, int position) {
        Snackbar.make(view,"Click na posição: "+position,Snackbar.LENGTH_LONG).show();
    }
}

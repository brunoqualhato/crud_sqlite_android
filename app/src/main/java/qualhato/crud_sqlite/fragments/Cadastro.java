package qualhato.crud_sqlite.fragments;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.pedant.SweetAlert.SweetAlertDialog;
import qualhato.crud_sqlite.R;
import qualhato.crud_sqlite.controller.PessoaDAO;
import qualhato.crud_sqlite.model.Pessoa;

public class Cadastro extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        final PessoaDAO oPessoaDAO = new PessoaDAO(view.getContext());
        final String[] sexoSelecionado = {""};

        view.findViewById(R.id.btnSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextInputEditText nome = view.findViewById(R.id.txtNome);
                TextInputEditText idade = view.findViewById(R.id.txtIdade);
                TextInputEditText endereco = view.findViewById(R.id.txtEndereco);
                RadioGroup sexo = view.findViewById(R.id.rgSexo);


                // get selected radio button from radioGroup
                int selectedId = sexo.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                RadioButton sexoSelecionado = view.findViewById(selectedId);


                boolean verifica = oPessoaDAO.salvar(new Pessoa(
                        nome.getText().toString(),
                        Integer.parseInt(idade.getText().toString()),
                        sexoSelecionado.getText().toString(),
                        endereco.getText().toString()
                ));

                if (verifica) {
                new SweetAlertDialog(view.getContext(),SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Atenção")
                        .setContentText("falha no erro")
                        .setOnDismissListener(new BottomSheetDialogFragment());
                }else{
                    new SweetAlertDialog(view.getContext(),SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Atenção")
                            .setContentText("falha no erro")
                            .setOnDismissListener(new BottomSheetDialogFragment());
                }

            }
        });


        return view;
    }

}

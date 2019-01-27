package qualhato.crud_sqlite.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import qualhato.crud_sqlite.R;
import qualhato.crud_sqlite.model.Pessoa;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.ViewHolder> {

    private List<Pessoa> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    public PessoaAdapter(Context context, List<Pessoa> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lista_adapter, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pessoa oPessoa = mData.get(position);
        holder.nome.setText(oPessoa.getNome());
        holder.idade.setText(String.valueOf(oPessoa.getIdade()));
        holder.sexo.setText(oPessoa.getSexo());
        holder.endereco.setText(oPessoa.getEndereco());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    Pessoa getItem(int id) {
        return mData.get(id);
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

     public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nome,idade,sexo,endereco;

        ViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.edtNome);
            idade = itemView.findViewById(R.id.edtIdade);
            sexo= itemView.findViewById(R.id.edtSexo);
            endereco = itemView.findViewById(R.id.edtEndereco);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
package qualhato.crud_sqlite.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import qualhato.crud_sqlite.banco.DbGateway;
import qualhato.crud_sqlite.model.Pessoa;

public class PessoaDAO {
    private DbGateway gw;

    public PessoaDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(Pessoa mPessoa) {

        String sql = "INSERT INTO Pessoa (Nome,Idade,Sexo,Endereco)VALUES(?,?,?,?)";

        SQLiteStatement statement = gw.getDatabase().compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, mPessoa.getNome());
        statement.bindLong(2, mPessoa.getIdade());
        statement.bindString(3, mPessoa.getSexo());
        statement.bindString(4, mPessoa.getEndereco());

        return statement.executeInsert() > 0;
    }

    public List<Pessoa> retornarPessoas(){
        List<Pessoa> clientes = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Pessoa", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            int idade = cursor.getInt(cursor.getColumnIndex("Idade"));
            String sexo = cursor.getString(cursor.getColumnIndex("Sexo"));
            String endereco = cursor.getString(cursor.getColumnIndex("Endereco"));
            clientes.add(new Pessoa(id, nome, idade, sexo, endereco));
        }
        cursor.close();
        return clientes;
    }
}

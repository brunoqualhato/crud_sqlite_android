package qualhato.crud_sqlite.model;

public class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    private String endereco;
    private int id;

    public Pessoa(String nome, int idade,String sexo,String endereco){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public Pessoa(int id,String nome, int idade,String sexo,String endereco){
        this.setId(id);
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

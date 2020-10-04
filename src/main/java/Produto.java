public class Produto {

    // Declarações de campo de instância
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private boolean ativo;

    // Construtor para inicializar os valores
    public Produto() {
    }

    public Produto(Long id, String nome, Double preco, Integer quantidade, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = ativo;
    }

    public Double getInventoryValue() {
        return this.quantidade * this.preco;
    }

    public void addToInventory(Integer quantidade) {
        if(this.ativo) this.quantidade += quantidade;
    }

    public void deductFromInventory(Integer quantidade) {
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return "Número do Item       : " + this.id + "\n" +
                "Nome                 : " + this.nome + "\n" +
                "Quantidade em estoque: " + this.quantidade + "\n" +
                "Preço                : " + this.preco + "\n" +
                "Valor do Estoque     : " + this.getInventoryValue() + "\n" +
                "Status do Produto    : " + (this.ativo ? "Verdadeiro" : "Falso");
    }

    // Métodos para acessar/modificar os atributos da classe.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

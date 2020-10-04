public class DVD extends Produto {

    private Integer duracao;
    private Integer classEtaria;
    private String estudio;

    public DVD(Long id, String nome, Double preco, Integer quantidade, boolean ativo, Integer duracao, Integer classEtaria, String estudo){
        super(id, nome, preco, quantidade, ativo);
        this.duracao = duracao;
        this.classEtaria = classEtaria;
        this.estudio = estudo;
    }

    @Override
    public Double getInventoryValue() {
        return super.getInventoryValue() * 0.05;
    }

    @Override
    public String toString() {
        return  "Número do Item         : " + this.getId() + "\n" +
                "Nome                   : " + this.getNome() + "\n" +
                "Duração do Filme       : " + this.getDuracao() + "\n" +
                "Classificação Etária   : " + this.getClassEtaria() + "\n" +
                "Estúdio Cinematográfico: " + this.getEstudio() + "\n" +
                "Quantidade em estoque  : " + this.getQuantidade() + "\n" +
                "Preço                  : " + this.getPreco() + "\n" +
                "Valor do Estoque       : " + this.getInventoryValue() + "\n" +
                "Status do Produto      : " + (this.isAtivo() ? "Ativo" : "Desativado");
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getClassEtaria() {
        return classEtaria;
    }

    public void setClassEtaria(Integer classEtaria) {
        this.classEtaria = classEtaria;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}

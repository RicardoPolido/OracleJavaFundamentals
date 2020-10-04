public class CD extends Produto {

    private String artista;
    private Integer numeroMusicas;
    private String selo;

    public CD(Long id, String nome, Double preco, Integer quantidade, boolean ativo, String artista, Integer numeroMusicas, String selo) {
        super(id, nome, preco, quantidade, ativo);
        this.artista = artista;
        this.numeroMusicas = numeroMusicas;
        this.selo = selo;
    }

    @Override
    public String toString() {
        return  "Número do Item         : " + this.getId() + "\n" +
                "Nome                   : " + this.getNome() + "\n" +
                "Artista                : " + this.getArtista() + "\n" +
                "Músicas do Album       : " + this.getNumeroMusicas() + "\n" +
                "Selo de gravação       : " + this.getSelo() + "\n" +
                "Quantidade em estoque  : " + this.getQuantidade() + "\n" +
                "Preço                  : " + this.getPreco() + "\n" +
                "Valor do Estoque       : " + this.getInventoryValue() + "\n" +
                "Status do Produto      : " + (this.isAtivo() ? "Ativo" : "Desativado");
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getNumeroMusicas() {
        return numeroMusicas;
    }

    public void setNumeroMusicas(Integer numeroMusicas) {
        this.numeroMusicas = numeroMusicas;
    }

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }
}

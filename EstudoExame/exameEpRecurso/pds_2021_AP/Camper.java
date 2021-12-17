
class Camper implements ICamper{
    String descricao;
    int lugares;
    Estado estado;

    public Camper(int lugares, String descricao){
        this.lugares = lugares;
        this.descricao = descricao;
    }

    @Override
    public void setEstado(Estado e) {
        this.estado = e;        
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lug) {
        this.lugares = lug;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String des) {
        this.descricao = des;
    }

    public String toString() {
        return this.descricao;
    }
}

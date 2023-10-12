public class PessoaJuridica extends Pessoa {
    public String cnpj;
    public String razaoSocial;

    public float CalcularImpostoJuridica(float rendimento){
        if (rendimento <= 3000) {
            float resultado = (rendimento / 100) * 3f;
            return resultado;
        } else if (rendimento > 3000 && rendimento <= 6000) {
            float resultado = (rendimento / 100) * 5f;
            return resultado;
        } else if (rendimento > 6000 && rendimento <= 10000) {
            float resultado = (rendimento / 100) * 7f;
            return resultado;
        } else {
            float resultado = (rendimento / 100) * 9f;
            return resultado;
        }
    }
}

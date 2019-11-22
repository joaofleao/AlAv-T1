import java.util.ArrayList;

public class Pecas{
    private double valor =0;
    private double peso = 0;
    private double valor_kilo = 0;
    public Pecas(double valor, double peso, double valor_kilo){
        this.peso = peso;
        this.valor = valor;
        this.valor_kilo = valor_kilo;
    }

    public double getPeso(){
        return peso;
    }

    public double getValor(){
        return valor;
    }

    public double getValor_kilo(){
        return valor_kilo;
    }

    public void setValor_kilo(double v){
        this.valor_kilo = v;
    }
}
package Entidades;

import java.sql.Date;
import java.util.Calendar;

public class Ticket {

    private int id;
    private Date dataHoraentrada;
    private double valor;    

    // getters e setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDataHoraentrada(Date dataHoraentrada) {
        this.dataHoraentrada = dataHoraentrada;
    }

    public Date getDataHoraentrada() {
        return this.dataHoraentrada;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }


}

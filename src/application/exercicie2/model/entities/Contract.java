package application.exercicie2.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    private int number;
    private Date date;
    private Double totalValue;

    private List<Installment> installments = new ArrayList<>();

    public Contract(int number, Date date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        installments.remove(installment);
    }

    public List<Installment> getInstallments() {
        return this.installments;
    }
}

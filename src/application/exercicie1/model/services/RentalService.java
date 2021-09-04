package application.exercicie1.model.services;

import application.exercicie1.model.entities.CarRental;
import application.exercicie1.model.entities.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;

    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long start = carRental.getStart().getTime();
        long finish = carRental.getFinish().getTime();

        double hours = (double) (finish - start) / 1000 / 60 / 60;

        double basicPayment = 0;
        if (hours <= 24.0) {
            basicPayment = Math.ceil(hours) * this.pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * this.pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}

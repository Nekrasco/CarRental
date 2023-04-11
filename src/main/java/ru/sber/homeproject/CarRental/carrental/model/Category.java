package ru.sber.homeproject.CarRental.carrental.model;

public enum Category {
    A("Мотоциклы"),
    B("Легковые автомобили"),
    C("Грузовые автомобили"),
    D("Автобусы"),
    BE("Легковые автомобили с прицепом"),
    CE("Грузовые автомобили с прицепом"),
    DE("Автобусы с прицепом");

    private String categoryDisplayValue;

    Category(String text) {
        this.categoryDisplayValue = text;
    }

    public String getCategoryDisplayValue() {
        return categoryDisplayValue;
    }
}
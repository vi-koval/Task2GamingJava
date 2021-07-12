package Controller;

import View.View;
import Model.Model;
import jdk.nashorn.internal.runtime.GlobalConstants;


import java.util.Scanner;

public class Controller { //лежат ссылки на Model и View
    private Model model;
    private View view;

    public Controller (Model model, View view){ //конструктор (при создании контроллера получаем ссылку на Model и View
        this.model = model;
        this.view = view;
    }

    //The Work Method
    public void processUser() {
        Scanner sc = new Scanner(System.in);


        model.setPrimaryBarrier (GlobalConstants.PRIMARY_MIN_BARRIER,
                                    GlobalConstants.PRIMARY_MAX_BARRIER); //пересылаем в модель устанавливаем мин и макс

        model.setSecretValue();
        System.out.println(model.getSecretValue());

        while (model.checkValue(inputIntValueWithScanner(sc)));

        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(View.YOUR_WAY + String.valueOf(model.getYourWay()));
    }

    private int inputIntValueWithScanner (Scanner sc) {
    int res = 0;
    view.printMessage(getInputIntMessage());

    while (true) {
        //check int value
        while (!sc.hasNextInt()){
            view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
            sc.next();
        }
        //check value into diapason
        if ((res = sc.nextInt()) <= model.getMinBarrier() ||
        res >= model.getMaxBarrier()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + getInputIntMessage());
            continue;
        }
        break;
    }
    return res;
    }

    private String getInputIntMessage() {
        return view.concatenationString(
                View.INPUT_INT_DATA, View.OPENS_SQUARE_BRACKET,
                String.valueOf(model.getMinBarrier()), View.SPACE_SING,
                String.valueOf(model.getMaxBarrier()),
                View.CLOSING_SQUARE_BRACKET, View.SPACE_SING,
                View.EQUAL_SING, View.SPACE_SING);
    }
}

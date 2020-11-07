package com.example.demo;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import org.vaadin.miki.superfields.numbers.SuperBigDecimalField;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    public MainView() {
        addClassName("centered-content");

        Binder<Model> dcdBinder = new Binder<>(Model.class);
        SuperBigDecimalField superBigDecimalField = new SuperBigDecimalField(new Locale("RU", "ru"), Integer.MAX_VALUE);
        dcdBinder.forField(superBigDecimalField)
                .withValidator(it -> false, "Wrong value")
                .bind(Model::getValue, Model::setValue);
        add(superBigDecimalField);
    }

    public static class Model {
        BigDecimal value;

        private void setValue(final BigDecimal value) {
            this.value = value;
        }

        private BigDecimal getValue() {
            return value;
        }
    }
}

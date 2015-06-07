package nl.hanze.funda.admin.ui;

import java.awt.*;
import java.util.List;

public interface InputElement {
    List<Component> getElements();

    String getValue();

    void setValue(String value);

}

package vk.dev.trials.periodictable;

import lombok.Value;

/**
 * ChemicalElement.
 *
 * @author vladimir_kuragin
 */
@Value
public class ChemicalElement {

    private int number;
    private String symbol;
    private String name;
    private String description;
    private int group;
    private int period;
    private double mass;

}

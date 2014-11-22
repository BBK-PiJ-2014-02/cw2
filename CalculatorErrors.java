/**
 *  Enum Errors with a human friendly description.
 */
public enum CalculatorErrors {
    OPERATOR_OVERRIDE       ("ERROR: Trying to override an already stored operator."),
    NO_OPERATOR_DEFINED     ("ERROR: Trying to execute an operation without an operator."),
    INVALID_OPERATION       ("ERROR: Invalid operation supplied."),
    INVALID_FRACTION        ("ERROR: Invalid fraction supplied."),
    UNKNOWN_OPERATOR        ("ERROR: Unknown operator.");

    /**
     *  Enum error descrition
     */
    private final String description;

    /**
     *  Enum constructor
     */
    private CalculatorErrors(String description) {
        this.description = description;
    }

    /**
     *  Public method to access description for a particular enum ERROR
     */
    public String toString() {
        return this.description;
    }
}
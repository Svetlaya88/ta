package task2.utilities;

public enum AvailableXmlNodes {
    NAME("name"),
    WEIGHT_IN_GRAM("weightInGram"),
    MANUFACTURER("manufacturer"),
    FILLING("filling"),
    TASTE("taste"),
    WITH_STICK("withStick"),
    TYPE("type");

    private final String name;

    AvailableXmlNodes(String name) {
        this.name = name;
    }

    public String getNodeName() {
        return name;
    }
}

package lib.enums;

public enum UnbxdEnum {


    CATEGORY_PAGE("Category Pages"),
    SEARCH("Search"),

    QUERY_RULE("Query Rule"),
    FIELD_RULE("Field Rule"),
    SITE_RULE("Site Rule"),

    CONFIGURE_SITE("Configure Site"),
    CONFIGURE_SEARCH("Configure Search"),

    LIBRARIES("Libraries"),

    FACET_DISPLAY_NAME("Display Name"),
    FACET_ATTRIBUTE_NAME("Select Attribute"),
    FACET_TYPE("Facet Type"),
    FACET_LENGTH("Facet Length"),
    FACET_SORT_ORDER("Sort Order"),
    FACET_RANGE_START("Range Start"),
    FACET_RAGNE_END("Range End"),
    FACEET_RANGE_GAP("Range Gap"),

    BOOST("Boost"),
    SORT("Sort"),

    SLOT("Slot"),
    PIN("Pin"),
    FILTER("Filter"),


    COMMERCE_SEARCH("Commerce Search"),
    TYPE_AHEAD("Typeahead"),

    PROMOTED_SUGGESTION("Promoted Suggestion"),
    STOP_WORDS("Blacklisted Suggestions"),

    SEGMENT_LOCATION("location"),

    BROWSE("Browse"),
    ABTEST("AbTest"),
    SEGMENTS("Segmentation"),
    ACCOUNT_SETTING("Account Settings"),
    RECOMMENDATION("Recommendation");



    public String label;

    UnbxdEnum(String s) {
        this.label=s;
    }

    public String getLabel()
    {
        return this.label;
    }
}

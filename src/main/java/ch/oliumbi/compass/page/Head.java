package ch.oliumbi.compass.page;

public record Head(
    String language,
    String charset,
    String title,
    String description,
    String iconHref,
    String themeColor
) {

}

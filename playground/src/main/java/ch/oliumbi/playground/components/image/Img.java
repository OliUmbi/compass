package ch.oliumbi.playground.components.image;

import ch.oliumbi.compass.ui.attribute.Attribute;
import ch.oliumbi.compass.ui.component.Component;
import java.util.List;

public class Img extends Component {

  private final String url;
  private final String description;
  private final Integer width;
  private final Integer height;

  public Img(String url, String description, Integer width, Integer height) {
    this.url = url;
    this.description = description;
    this.width = width;
    this.height = height;
  }

  @Override
  protected String tag() {
    return "img";
  }

  @Override
  protected List<Attribute> attributes() {
    return List.of(
        new Attribute("src", url),
        new Attribute("alt", description),
        new Attribute("width", width.toString()),
        new Attribute("height", height.toString())
    );
  }
}

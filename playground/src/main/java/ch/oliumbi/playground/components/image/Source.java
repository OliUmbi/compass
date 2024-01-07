package ch.oliumbi.playground.components.image;

import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.ui.attribute.Attribute;
import ch.oliumbi.compass.ui.component.Component;
import java.util.ArrayList;
import java.util.List;

public class Source extends Component {

  private final String path;
  private final MimeType type;

  public Source(String path, MimeType type) {
    this.path = path;
    this.type = type;
  }

  @Override
  protected String tag() {
    return "source";
  }

  @Override
  protected List<Attribute> attributes() {

    return List.of(
        new Attribute("sizes", """
            (max-width: 320px) 320px,
            (max-width: 640px) 640px,
            (max-width: 960px) 960px,
            (max-width: 1280px) 1280px,
            1600px
            """),
        new Attribute("sizes", STR."""
            \{path}-xl\{type.extension()} 1600w,
            \{path}-l\{type.extension()} 1280w,
            \{path}-m\{type.extension()} 960w,
            \{path}-s\{type.extension()} 640w,
            \{path}-xs\{type.extension()} 320w
            """),
        new Attribute("type", type.translate())
    );
  }
}

package ch.oliumbi.playground.components.image;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.image.Image;
import java.util.List;

public class Picture extends Component {

  private final List<Image> images;

  public Picture(Image... images) {
    this.images = List.of(images);
  }

  @Override
  protected String tag() {
    return "picture";
  }

  @Override
  protected List<Component> components() {
    List<Component> components = new java.util.ArrayList<>();
    Image fallback = images.getFirst();

    for (Image image : images) {
      components.add(new Source(image.getPath(), image.getType()));
    }

    components.add(new Img(
        STR."\{fallback.getPath()}-xl\{fallback.getType().extension()}",
        fallback.getDescription(),
        fallback.getWidth(),
        fallback.getHeight()));

    return components;
  }
}

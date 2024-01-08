package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.UncleT;
import ch.oliumbi.playground.components.base.Button;
import ch.oliumbi.playground.components.section.Section;
import ch.oliumbi.playground.components.typography.H1;
import ch.oliumbi.playground.components.typography.H2;
import ch.oliumbi.playground.components.typography.H3;
import ch.oliumbi.playground.components.typography.H4;
import ch.oliumbi.playground.components.typography.P;
import ch.oliumbi.playground.components.typography.Small;
import java.util.List;

@Autoload
public class Home extends UncleT {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Section(
            new H1("Uncle-T")
        ),
        new Section(
            new Button("Hello, World!"),
            new H1("Lorem ipsum"),
            new H2("Lorem ipsum"),
            new H3("Lorem ipsum"),
            new H4("Lorem ipsum"),
            new P("Lorem ipsum"),
            new Small("Lorem ipsum")
        ),
        new Section(
            new H2("Lorem ipsum"),
            new H4("Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            new P("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean erat risus, vulputate vulputate lectus non, semper lobortis arcu. Aliquam nec risus leo. Sed eget molestie odio. Mauris imperdiet id nunc sit amet ornare. Nunc porttitor quam et diam cursus, nec hendrerit mi vulputate. Donec non ipsum eu lacus molestie pretium. Duis ligula dui, pulvinar sit amet eleifend eu, molestie et justo. Fusce in suscipit turpis, ut blandit tortor. Fusce blandit fringilla nibh et ornare. Vestibulum iaculis augue non blandit elementum. Sed feugiat vulputate arcu, ac consequat lacus feugiat non. Duis varius elementum rhoncus. Nam at magna eget dui hendrerit pulvinar quis lobortis turpis. Nullam finibus sed justo quis facilisis."),
            new P("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean erat risus, vulputate vulputate lectus non, semper lobortis arcu. Aliquam nec risus leo. Sed eget molestie odio. Mauris imperdiet id nunc sit amet ornare. Nunc porttitor quam et diam cursus, nec hendrerit mi vulputate. Donec non ipsum eu lacus molestie pretium. Duis ligula dui, pulvinar sit amet eleifend eu, molestie et justo. Fusce in suscipit turpis, ut blandit tortor. Fusce blandit fringilla nibh et ornare. Vestibulum iaculis augue non blandit elementum. Sed feugiat vulputate arcu, ac consequat lacus feugiat non. Duis varius elementum rhoncus. Nam at magna eget dui hendrerit pulvinar quis lobortis turpis. Nullam finibus sed justo quis facilisis."),
            new H3("Lorem ipsum"),
            new Small("Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            new P("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean erat risus, vulputate vulputate lectus non, semper lobortis arcu. Aliquam nec risus leo. Sed eget molestie odio. Mauris imperdiet id nunc sit amet ornare. Nunc porttitor quam et diam cursus, nec hendrerit mi vulputate. Donec non ipsum eu lacus molestie pretium. Duis ligula dui, pulvinar sit amet eleifend eu, molestie et justo. Fusce in suscipit turpis, ut blandit tortor. Fusce blandit fringilla nibh et ornare. Vestibulum iaculis augue non blandit elementum. Sed feugiat vulputate arcu, ac consequat lacus feugiat non. Duis varius elementum rhoncus. Nam at magna eget dui hendrerit pulvinar quis lobortis turpis. Nullam finibus sed justo quis facilisis.")
        )
    );
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  protected String title() {
    return "Uncle-T";
  }

  @Override
  protected String description() {
    return "Uncle-T Homepage";
  }
}

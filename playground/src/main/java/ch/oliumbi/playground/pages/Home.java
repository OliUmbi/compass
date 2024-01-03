package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.Playground;
import ch.oliumbi.playground.components.Button;
import ch.oliumbi.playground.components.Text;
import java.util.List;

@Autoload
public class Home extends Playground {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Button("World!"),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis."),
        new Text("p", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In justo ex, tincidunt viverra tortor eget, accumsan lacinia elit. Proin vitae leo efficitur, pharetra est in, dapibus tortor. Maecenas malesuada iaculis elementum. Vivamus sit amet purus ac nunc congue ultrices eu volutpat lacus. Aliquam erat volutpat. Donec interdum nisl metus, aliquet interdum magna tempus non. Cras non molestie turpis, id sodales eros. Nam in ipsum nisl. Suspendisse potenti. Curabitur auctor gravida odio, ut varius est venenatis nec. Suspendisse ut lorem vitae elit imperdiet scelerisque in ac nulla. Maecenas sagittis sollicitudin dolor at consequat. Mauris varius velit nisi, nec scelerisque est congue quis.")
    );
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  protected String title() {
    return "Plygrnd";
  }

  @Override
  protected String description() {
    return "Playground";
  }
}

//package ch.oliumbi.compass.server.ui.component;
//
//import ch.oliumbi.compass.server.ui.Renderable;
//
//public abstract class Component implements Renderable {
//
//  protected abstract String tag();
//
//  protected abstract String children();
//
//  protected abstract Style style();
//
//  @Override
//  public String render() {
//    return String.format("<%s style=\"%s\">%s</%s>", tag(), style().render(), children(), tag());
//  }
//}

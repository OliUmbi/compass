package ch.oliumbi.playground.components;

public class Test extends Component {

  public Object value() {
    return "Button 1";
  }

  public Js script() {
    return new Js()
        .onLoad("""
            element.error = true
            element.value = "ölkdsaj"
            """)
        .onClick("""
            """)
        .event("nav", """
            // js code here
            """);
  }

  public Css xl() {
    return new Css()
        .normal(
            new Style()
                .background()
                .border()
        )
        .error();
  }

  public Css l() {
    return new Css()
        .normal(
            new Style()
                .background()
                .border()
        );
  }

  public Css m() {
    return new Css()
        .normal(
            new Style()
                .background()
                .border()
        );
  }

  public Css s() {
    return new Css()
        .normal(
            new Style()
                .background()
                .border()
        );
  }

  public Css xs() {
    return new Css()
        .normal(
            new Style()
                .background()
                .border()
        );
  }
}

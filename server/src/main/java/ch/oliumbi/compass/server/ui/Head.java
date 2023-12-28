package ch.oliumbi.compass.server.ui;

public abstract class Head implements Renderable {



  @Override
  public String render() {

    return """
        <head>
          <meta charset="%s">
          <title>%s</title>
          <meta name="description" content="%s">
          <meta name="theme-color" content="%s">
          <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
          <meta http-equiv="X-UA-Compatible" content="ie=edge">
          
          <link rel="icon" href="%s" type="%s">
          <link rel="manifest" href="manifest.json" />
          <link rel="stylesheet" href="fonts.css" />
          
          <meta property="og:type" content="website" />
          <meta property="og:url" content="%s" />
          <meta property="og:title" content="%s" />
          <meta property="og:description" content="%s" />
          <meta property="og:image" content="%s" />

          <meta property="twitter:card" content="summary_large_image" />
          <meta property="twitter:url" content="%s" />
          <meta property="twitter:title" content="%s" />
          <meta property="twitter:description" content="%s" />
          <meta property="twitter:image" content="%s" />
          
          %s
          %s
        </head>
        """;
  }
}

package ch.oliumbi.compass.ui;

import ch.oliumbi.compass.core.enums.Language;
import ch.oliumbi.compass.ui.color.Color;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.component.Render;
import ch.oliumbi.compass.ui.font.Font;
import ch.oliumbi.compass.ui.image.Image;
import ch.oliumbi.compass.ui.manifest.Manifest;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Ui {

  protected abstract String title();

  protected abstract String description();

  protected abstract Language language();

  protected abstract String color();

  protected abstract Image icon();

  protected abstract Image image();

  protected abstract String url();

  protected abstract Manifest manifest();

  protected abstract List<Font> fonts();

  public String render(List<Component> components) {

    StringBuilder body = new StringBuilder();
    StringBuilder script = new StringBuilder();
    StringBuilder xl = new StringBuilder();
    StringBuilder l = new StringBuilder();
    StringBuilder m = new StringBuilder();
    StringBuilder s = new StringBuilder();
    StringBuilder xs = new StringBuilder();

    for (Component component : components) {
      Render render = component.render();

      body.append(render.getValue());
      script.append(render.getScript());
      xl.append(render.getXl());
      l.append(render.getL());
      m.append(render.getM());
      s.append(render.getS());
      xs.append(render.getXs());
    }

    return STR."""
        <!doctype html>
        <html lang="\{language().translate()}">
          <head>
            <meta charset="UTF-8">

            <title>\{title()}</title>
            <meta name="description" content="\{description()}">
            <meta name="theme-color" content="\{color()}">
            <link rel="icon" href="\{icon().getUrl()}" type="\{icon().getType()}">
            <link rel="manifest" href="\{manifest().url()}" />

            <meta property="og:type" content="website" />
            <meta property="og:url" content="\{url()}" />
            <meta property="og:title" content="\{title()}" />
            <meta property="og:description" content="\{description()}" />
            <meta property="og:image" content="\{image()}" />

            <meta property="twitter:card" content="summary_large_image" />
            <meta property="twitter:url" content="\{url()}" />
            <meta property="twitter:title" content="\{title()}" />
            <meta property="twitter:description" content="\{description()}" />
            <meta property="twitter:image" content="\{image()}" />

            <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=5.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">

            <style>
              \{normalize()}
              \{fonts().stream().map(Font::render).collect(Collectors.joining())}

              \{xl}
              @media only screen and (max-width: 1280px) {
                \{l}
              }
              @media only screen and (max-width: 960px) {
                \{m}
              }
              @media only screen and (max-width: 640px) {
                \{s}
              }
              @media only screen and (max-width: 320px) {
                \{xs}
              }
            </style>
          </head>
          <body>
            \{body}
            <script>
              \{setup()}
              \{script}
            </script>
          </body>
        </html
        """
        .replaceAll("\n", "")
        .replaceAll(" +", " ");
  }

  protected String normalize() {
    return """
        *, ::before, ::after {
          box-sizing: border-box;
        }
        
        html {
          font-family: system-ui, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji';
          line-height: 1.15;
          -webkit-text-size-adjust: 100%;
          -moz-tab-size: 4;
          tab-size: 4;
        }
        
        body {
          margin: 0;
        }
        
        hr {
          height: 0;
          color: inherit;
        }
        
        abbr[title] {
          text-decoration: underline dotted;
        }
        
        b, strong {
          font-weight: bolder;
        }
        
        code, kbd, samp, pre {
          font-family: ui-monospace, SFMono-Regular, Consolas, 'Liberation Mono', Menlo, monospace;
          font-size: 1em;
        }
        
        small {
          font-size: 80%;
        }
        
        sub, sup {
          font-size: 75%;
          line-height: 0;
          position: relative;
          vertical-align: baseline;
        }
        
        sub {
          bottom: -0.25em;
        }
        
        sup {
          top: -0.5em;
        }
        
        table {
          text-indent: 0;
          border-color: inherit;
        }
        
        button, input, optgroup, select, textarea {
          font-family: inherit;
          font-size: 100%;
          line-height: 1.15;
          margin: 0;
        }
        
        button, select {
          text-transform: none;
        }
        
        button, [type='button'], [type='reset'], [type='submit'] {
          -webkit-appearance: button;
        }
        
        ::-moz-focus-inner {
          border-style: none;
          padding: 0;
        }
        
        :-moz-focusring {
          outline: 1px dotted ButtonText;
        }
        
        :-moz-ui-invalid {
          box-shadow: none;
        }
        
        legend {
          padding: 0;
        }
        
        progress {
          vertical-align: baseline;
        }
        
        ::-webkit-inner-spin-button, ::-webkit-outer-spin-button {
          height: auto;
        }
        
        [type='search'] {
          -webkit-appearance: textfield;
          outline-offset: -2px;
        }
        
        ::-webkit-search-decoration {
          -webkit-appearance: none;
        }
        
        ::-webkit-file-upload-button {
          -webkit-appearance: button;
          font: inherit;
        }
        
        summary {
          display: list-item;
        }
        
        img {
          display: block;
          max-inline-size: 100%;
        }
        
        ol, ul {
          list-style: none;
          padding-inline: 0;
        }
        """;
  }

  protected String setup() {
    return """
        let listeners = []
              
        let event = (name) => {
          for (const listener of listeners) {
            if (listener.name === name) {
              listener.callback()
            }
          }
        }
        """;
  }
}

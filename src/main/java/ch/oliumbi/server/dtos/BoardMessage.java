package ch.oliumbi.server.dtos;

public record BoardMessage(
    String title,
    String description,
    String ip,
    String name
) {

  @Override
  public String toString() {
    return String.format("""
            <div class="board-message">
              <div class="board-message__head">
                <h6>%s</h6>
                <p>%s : %s</p>
              </div>
              <p>%s</p>
            </div>
            """,
        title,
        name,
        ip,
        description);
  }
}

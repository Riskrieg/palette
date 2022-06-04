package com.riskrieg.palette.legacy.v2;

import java.awt.Color;
import java.util.Objects;

public record LegacyColorV2(int id, String name, int r, int g, int b) implements Comparable<LegacyColorV2> {

  public LegacyColorV2 {
    Objects.requireNonNull(name);
    if (name.isBlank()) {
      throw new IllegalStateException("String 'name' cannot be blank");
    }
    if (r < 0 || r > 255) {
      throw new IllegalStateException("LegacyColor value for red must be between 0 and 255, inclusive on either end.");
    }
    if (g < 0 || g > 255) {
      throw new IllegalStateException("LegacyColor value for green must be between 0 and 255, inclusive on either end.");
    }
    if (b < 0 || b > 255) {
      throw new IllegalStateException("LegacyColor value for blue must be between 0 and 255, inclusive on either end.");
    }
  }

  public LegacyColorV2(int id, String name, String hex) {
    this(id, name, Color.decode(hex).getRed(), Color.decode(hex).getGreen(), Color.decode(hex).getBlue());
  }

  // TODO: toOrderedColor

  public Color toColor() {
    return new Color(r, g, b);
  }

  @Override
  public int compareTo(LegacyColorV2 o) {
    return Integer.compare(this.id(), o.id());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegacyColorV2 color = (LegacyColorV2) o;
    return id == color.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}

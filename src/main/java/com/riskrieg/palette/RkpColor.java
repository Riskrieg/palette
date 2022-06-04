package com.riskrieg.palette;

import edu.umd.cs.findbugs.annotations.NonNull;
import java.awt.Color;
import java.util.Objects;

public record RkpColor(int order, String name, int r, int g, int b) implements Comparable<RkpColor> { // Alpha not supported

  public RkpColor {
    Objects.requireNonNull(name);
    if (name.isBlank()) {
      throw new IllegalStateException("String 'name' cannot be blank");
    }
    if (r < 0 || r > 255) {
      throw new IllegalStateException("Value for red must be between 0 and 255, inclusive on either end. [value: " + r + "]");
    }
    if (g < 0 || g > 255) {
      throw new IllegalStateException("Value for green must be between 0 and 255, inclusive on either end. [value: " + g + "]");
    }
    if (b < 0 || b > 255) {
      throw new IllegalStateException("Value for blue must be between 0 and 255, inclusive on either end. [value: " + b + "]");
    }
  }

  public RkpColor(int r, int g, int b) {
    this(-1, "Unnamed", r, g, b); // We don't care about order or name if we use this constructor
  }

  public Color toAwtColor() {
    return new Color(r, g, b);
  }

  @Override
  public int compareTo(@NonNull RkpColor o) {
    return Integer.compare(this.order, o.order);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RkpColor rkpColor = (RkpColor) o;
    return order == rkpColor.order;
  }

  @Override
  public int hashCode() {
    return Objects.hash(order);
  }

}

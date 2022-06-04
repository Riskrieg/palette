package com.riskrieg.palette.legacy.v1;

import java.awt.Color;
import java.util.Objects;

public final class LegacyColorV1 implements Comparable<LegacyColorV1> {

  private final LegacyColorIdV1 id;
  private final String name;
  private final int r;
  private final int g;
  private final int b;


  public LegacyColorV1(LegacyColorIdV1 id, String name, int r, int g, int b) {
    this.id = id;
    this.name = name;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public Color toColor() {
    return new Color(r, g, b);
  }

  // TODO: toOrderedColor()

  @Override
  public int compareTo(LegacyColorV1 o) {
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
    LegacyColorV1 color = (LegacyColorV1) o;
    return id.value() == color.id.value();
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public int id() {
    return id.value();
  }

  public String name() {
    return name;
  }

  public int r() {
    return r;
  }

  public int g() {
    return g;
  }

  public int b() {
    return b;
  }

}


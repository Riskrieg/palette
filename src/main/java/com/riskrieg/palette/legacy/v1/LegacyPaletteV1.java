package com.riskrieg.palette.legacy.v1;

import java.awt.Color;
import java.util.Collections;
import java.util.Objects;
import java.util.SortedSet;

public final class LegacyPaletteV1 {

  private final SortedSet<LegacyColorV1> colorSet;

  public LegacyPaletteV1(SortedSet<LegacyColorV1> colorSet) {
    colorSet = Collections.unmodifiableSortedSet(colorSet);
    this.colorSet = colorSet;
  }

  // TODO: Convert to Palette

  public LegacyColorV1 valueOf(Color color) {
    Objects.requireNonNull(color);
    for (LegacyColorV1 legacyColor : colorSet) {
      if (legacyColor.toColor().equals(color)) {
        return legacyColor;
      }
    }
    return colorSet.last();
  }

  public int size() {
    return colorSet.size();
  }


}

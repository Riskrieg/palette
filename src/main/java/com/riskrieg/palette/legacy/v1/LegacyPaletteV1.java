package com.riskrieg.palette.legacy.v1;

import com.riskrieg.palette.RkpColor;
import com.riskrieg.palette.RkpPalette;
import java.awt.Color;
import java.util.Collections;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Only included for legacy support purposes. Do not use for any other purpose.
 *
 * @deprecated Use {@link com.riskrieg.palette.RkpPalette instead}
 */
@Deprecated
public final class LegacyPaletteV1 {

  private final SortedSet<LegacyColorV1> colorSet;

  public LegacyPaletteV1(SortedSet<LegacyColorV1> colorSet) {
    colorSet = Collections.unmodifiableSortedSet(colorSet);
    this.colorSet = colorSet;
  }

  public RkpPalette toRkpPalette() {
    SortedSet<RkpColor> orderedColors = new TreeSet<>();
    for (LegacyColorV1 legacyColorV1 : colorSet) {
      orderedColors.add(legacyColorV1.toRkpColor());
    }
    return new RkpPalette("Unnamed", orderedColors);
  }

  public LegacyColorV1 valueOf(Color color) {
    Objects.requireNonNull(color);
    for (LegacyColorV1 legacyColor : colorSet) {
      if (legacyColor.toAwtColor().equals(color)) {
        return legacyColor;
      }
    }
    return colorSet.last();
  }

  public int size() {
    return colorSet.size();
  }


}

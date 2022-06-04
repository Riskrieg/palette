package com.riskrieg.palette.legacy.v2;

import com.riskrieg.palette.RkpColor;
import com.riskrieg.palette.RkpPalette;
import java.awt.Color;
import java.util.Arrays;
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
public record LegacyPaletteV2(String name, SortedSet<LegacyColorV2> set) {

  public LegacyPaletteV2 {
    Objects.requireNonNull(name);
    Objects.requireNonNull(set);
    set = Collections.unmodifiableSortedSet(set);
  }

  public LegacyPaletteV2(String name, LegacyColorV2... colors) {
    this(name, new TreeSet<>(Arrays.asList(colors)));
  }

  public RkpPalette toRkpPalette() {
    SortedSet<RkpColor> orderedColors = new TreeSet<>();
    for (LegacyColorV2 legacyColorV2 : set) {
      orderedColors.add(legacyColorV2.toRkpColor());
    }
    return new RkpPalette(name, orderedColors);
  }

  public LegacyColorV2 first() {
    return set.first();
  }

  public LegacyColorV2 last() {
    return set.last();
  }

  public LegacyColorV2 get(int index) {
    if (index < 0) {
      return first();
    } else if (index >= set.size()) {
      return last();
    }
    return set.toArray(LegacyColorV2[]::new)[index];
  }

  public LegacyColorV2 valueOf(Color color) {
    Objects.requireNonNull(color);
    for (LegacyColorV2 legacyColor : set) {
      if (legacyColor.toAwtColor().equals(color)) {
        return legacyColor;
      }
    }
    return last();
  }

  public int size() {
    return set.size();
  }

  public static LegacyPaletteV2 standard() {
    return new LegacyPaletteV2("Default",
        new LegacyColorV2(0, "Salmon", 255, 140, 150), new LegacyColorV2(1, "Lavender", 155, 120, 190),
        new LegacyColorV2(2, "Thistle", 215, 190, 240), new LegacyColorV2(3, "Ice", 195, 230, 255),
        new LegacyColorV2(4, "Sky", 120, 165, 215), new LegacyColorV2(5, "Sea", 140, 225, 175),
        new LegacyColorV2(6, "Forest", 85, 155, 60), new LegacyColorV2(7, "Sod", 170, 190, 95),
        new LegacyColorV2(8, "Cream", 255, 254, 208), new LegacyColorV2(9, "Sun", 240, 225, 80),
        new LegacyColorV2(10, "Gold", 255, 195, 5), new LegacyColorV2(11, "Cadmium", 250, 105, 65),
        new LegacyColorV2(12, "Sanguine", 95, 10, 0), new LegacyColorV2(13, "Mocha", 75, 40, 0),
        new LegacyColorV2(14, "Matte", 30, 30, 30), new LegacyColorV2(15, "Cobalt", 0, 50, 120)
    );
  }

  public static LegacyPaletteV2 original() {
    return new LegacyPaletteV2("Original",
        new LegacyColorV2(0, "Cadmium", 240, 130, 50), new LegacyColorV2(1, "Sun", 241, 224, 82),
        new LegacyColorV2(2, "Sod", 171, 191, 94), new LegacyColorV2(3, "Sea", 140, 198, 183),
        new LegacyColorV2(4, "Sky", 122, 165, 217), new LegacyColorV2(5, "Burgundy", 111, 16, 56),
        new LegacyColorV2(6, "Sanguine", 104, 7, 2), new LegacyColorV2(7, "Bistre", 84, 35, 25),
        new LegacyColorV2(8, "Forest", 32, 64, 18), new LegacyColorV2(9, "Cobalt", 32, 42, 122),
        new LegacyColorV2(10, "Indigo", 39, 25, 79), new LegacyColorV2(11, "Amethyst", 82, 28, 124),
        new LegacyColorV2(12, "Gold", 227, 170, 49), new LegacyColorV2(13, "Tenné", 193, 146, 114),
        new LegacyColorV2(14, "Gunmetal", 170, 159, 140), new LegacyColorV2(15, "Aphotic", 64, 49, 51)
    );
  }

}


/*
 *     Riskrieg, an open-source conflict simulation game.
 *     Copyright (C) 2022 Aaron Yoder <aaronjyoder@gmail.com> and the Riskrieg contributors
 *
 *     This code is licensed under the MIT license.
 */

package com.riskrieg.palette.legacy;

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
public record LegacyPalette(String name, SortedSet<LegacyColor> set) {

  public LegacyPalette {
    Objects.requireNonNull(name);
    Objects.requireNonNull(set);
    set = Collections.unmodifiableSortedSet(set);
  }

  public LegacyPalette(String name, LegacyColor... colors) {
    this(name, new TreeSet<>(Arrays.asList(colors)));
  }

  public RkpPalette toRkpPalette() {
    SortedSet<RkpColor> orderedColors = new TreeSet<>();
    for (LegacyColor legacyColor : set) {
      orderedColors.add(legacyColor.toRkpColor());
    }
    return new RkpPalette(name, orderedColors);
  }

  public LegacyColor first() {
    return set.first();
  }

  public LegacyColor last() {
    return set.last();
  }

  public LegacyColor get(int index) {
    if (index < 0) {
      return first();
    } else if (index >= set.size()) {
      return last();
    }
    return set.toArray(LegacyColor[]::new)[index];
  }

  public LegacyColor valueOf(Color color) {
    Objects.requireNonNull(color);
    for (LegacyColor legacyColor : set) {
      if (legacyColor.toAwtColor().equals(color)) {
        return legacyColor;
      }
    }
    return last();
  }

  public int size() {
    return set.size();
  }

  public static LegacyPalette standard() {
    return new LegacyPalette("Default",
        new LegacyColor(0, "Salmon", 255, 140, 150), new LegacyColor(1, "Lavender", 155, 120, 190),
        new LegacyColor(2, "Thistle", 215, 190, 240), new LegacyColor(3, "Ice", 195, 230, 255),
        new LegacyColor(4, "Sky", 120, 165, 215), new LegacyColor(5, "Sea", 140, 225, 175),
        new LegacyColor(6, "Forest", 85, 155, 60), new LegacyColor(7, "Sod", 170, 190, 95),
        new LegacyColor(8, "Cream", 255, 254, 208), new LegacyColor(9, "Sun", 240, 225, 80),
        new LegacyColor(10, "Gold", 255, 195, 5), new LegacyColor(11, "Cadmium", 250, 105, 65),
        new LegacyColor(12, "Sanguine", 95, 10, 0), new LegacyColor(13, "Mocha", 75, 40, 0),
        new LegacyColor(14, "Matte", 30, 30, 30), new LegacyColor(15, "Cobalt", 0, 50, 120)
    );
  }

  public static LegacyPalette original() {
    return new LegacyPalette("Original",
        new LegacyColor(0, "Cadmium", 240, 130, 50), new LegacyColor(1, "Sun", 241, 224, 82),
        new LegacyColor(2, "Sod", 171, 191, 94), new LegacyColor(3, "Sea", 140, 198, 183),
        new LegacyColor(4, "Sky", 122, 165, 217), new LegacyColor(5, "Burgundy", 111, 16, 56),
        new LegacyColor(6, "Sanguine", 104, 7, 2), new LegacyColor(7, "Bistre", 84, 35, 25),
        new LegacyColor(8, "Forest", 32, 64, 18), new LegacyColor(9, "Cobalt", 32, 42, 122),
        new LegacyColor(10, "Indigo", 39, 25, 79), new LegacyColor(11, "Amethyst", 82, 28, 124),
        new LegacyColor(12, "Gold", 227, 170, 49), new LegacyColor(13, "Tenné", 193, 146, 114),
        new LegacyColor(14, "Gunmetal", 170, 159, 140), new LegacyColor(15, "Aphotic", 64, 49, 51)
    );
  }

}


/*
 *     Riskrieg, an open-source conflict simulation game.
 *     Copyright (C) 2022 Aaron Yoder <aaronjyoder@gmail.com> and the Riskrieg contributors
 *
 *     This code is licensed under the MIT license.
 */

package com.riskrieg.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public record RkpPalette(String name,
                         RkpColor textColor, RkpColor borderColor, RkpColor territoryColor,
                         RkpColor landColor, RkpColor waterColor, RkpColor connectionColor,
                         SortedSet<RkpColor> sortedColorSet) {

  public static final RkpColor DEFAULT_TEXT_COLOR = new RkpColor(116, 79, 40);
  public static final RkpColor DEFAULT_BORDER_COLOR = new RkpColor(116, 79, 40);
  public static final RkpColor DEFAULT_TERRITORY_COLOR = new RkpColor(224, 219, 227);
  public static final RkpColor DEFAULT_LAND_COLOR = new RkpColor(200, 183, 173);
  public static final RkpColor DEFAULT_WATER_COLOR = new RkpColor(192, 163, 146);
  public static final RkpColor DEFAULT_CONNECTION_COLOR = new RkpColor(148, 125, 111);

  public static final int MINIMUM_SIZE = 2;
  public static final int MAXIMUM_SIZE = 16;

  public RkpPalette {
    Objects.requireNonNull(name);
    Objects.requireNonNull(textColor);
    Objects.requireNonNull(borderColor);
    Objects.requireNonNull(territoryColor);
    Objects.requireNonNull(landColor);
    Objects.requireNonNull(waterColor);
    Objects.requireNonNull(connectionColor);
    Objects.requireNonNull(sortedColorSet);
    if (name.isBlank()) {
      throw new IllegalStateException("String 'name' cannot be blank");
    }
    if (sortedColorSet.size() < MINIMUM_SIZE) {
      throw new IllegalStateException("Your color set cannot have fewer than " + MINIMUM_SIZE + " colors defined. You have " + sortedColorSet.size() + " unique items in your set.");
    } else if (sortedColorSet.size() > MAXIMUM_SIZE) {
      throw new IllegalStateException("Your color set cannot have more than " + MAXIMUM_SIZE + " colors defined. You have " + sortedColorSet.size() + " unique items in your set.");
    }
    sortedColorSet = Collections.unmodifiableSortedSet(sortedColorSet);
  }

  public RkpPalette(String name, SortedSet<RkpColor> orderedColors) {
    this(name, DEFAULT_TEXT_COLOR, DEFAULT_BORDER_COLOR, DEFAULT_TERRITORY_COLOR, DEFAULT_LAND_COLOR, DEFAULT_WATER_COLOR, DEFAULT_CONNECTION_COLOR, orderedColors);
  }

  public RkpPalette(String name, RkpColor... colors) {
    this(name, new TreeSet<>(Arrays.asList(colors)));
  }

  public RkpColor first() {
    return sortedColorSet.first();
  }

  public RkpColor last() {
    return sortedColorSet.last();
  }

  public Optional<RkpColor> get(int index) {
    for (RkpColor rkpColor : sortedColorSet) {
      if (rkpColor.order() == index) {
        return Optional.of(rkpColor);
      }
    }
    return Optional.empty();
  }

  public Optional<RkpColor> valueOf(Color color) {
    Objects.requireNonNull(color);
    for (RkpColor rkpColor : sortedColorSet) {
      if (rkpColor.toAwtColor().equals(color)) {
        return Optional.of(rkpColor);
      }
    }
    return Optional.empty();
  }

  public boolean contains(RkpColor color) {
    return sortedColorSet.contains(color);
  }

  public int size() {
    return sortedColorSet.size();
  }

  public SortedSet<RkpColor> sortedColorSet() {
    return Collections.unmodifiableSortedSet(sortedColorSet);
  }

  /**
   * The default palette. Includes support for most types of color blindness.
   *
   * @return the default color palette
   */
  public static RkpPalette standard() {
    return new RkpPalette("Default",
        new RkpColor(0, "Salmon", 255, 140, 150), new RkpColor(1, "Lavender", 155, 120, 190),
        new RkpColor(2, "Thistle", 215, 190, 240), new RkpColor(3, "Ice", 195, 230, 255),
        new RkpColor(4, "Sky", 120, 165, 215), new RkpColor(5, "Sea", 140, 225, 175),
        new RkpColor(6, "Forest", 85, 155, 60), new RkpColor(7, "Sod", 170, 190, 95),
        new RkpColor(8, "Cream", 255, 254, 208), new RkpColor(9, "Sun", 240, 225, 80),
        new RkpColor(10, "Gold", 255, 195, 5), new RkpColor(11, "Cadmium", 250, 105, 65),
        new RkpColor(12, "Sanguine", 95, 10, 0), new RkpColor(13, "Mocha", 75, 40, 0),
        new RkpColor(14, "Matte", 30, 30, 30), new RkpColor(15, "Cobalt", 0, 50, 120)
    );
  }

  /**
   * The original palette.
   *
   * @return the original color palette
   */
  public static RkpPalette original() {
    return new RkpPalette("Original",
        new RkpColor(0, "Cadmium", 240, 130, 50), new RkpColor(1, "Sun", 241, 224, 82),
        new RkpColor(2, "Sod", 171, 191, 94), new RkpColor(3, "Sea", 140, 198, 183),
        new RkpColor(4, "Sky", 122, 165, 217), new RkpColor(5, "Burgundy", 111, 16, 56),
        new RkpColor(6, "Sanguine", 104, 7, 2), new RkpColor(7, "Bistre", 84, 35, 25),
        new RkpColor(8, "Forest", 32, 64, 18), new RkpColor(9, "Cobalt", 32, 42, 122),
        new RkpColor(10, "Indigo", 39, 25, 79), new RkpColor(11, "Amethyst", 82, 28, 124),
        new RkpColor(12, "Gold", 227, 170, 49), new RkpColor(13, "Tenné", 193, 146, 114),
        new RkpColor(14, "Gunmetal", 170, 159, 140), new RkpColor(15, "Aphotic", 64, 49, 51)
    );
  }

}

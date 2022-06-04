/*
 *     Riskrieg, an open-source conflict simulation game.
 *     Copyright (C) 2019-2022 Aaron Yoder <aaronjyoder@gmail.com> and the Riskrieg contributors
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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

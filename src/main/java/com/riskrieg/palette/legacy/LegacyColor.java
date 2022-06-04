/*
 *     Riskrieg, an open-source conflict simulation game.
 *     Copyright (C) 2022 Aaron Yoder <aaronjyoder@gmail.com> and the Riskrieg contributors
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

package com.riskrieg.palette.legacy;

import com.riskrieg.palette.RkpColor;
import java.awt.Color;
import java.util.Objects;

/**
 * Only included for legacy support purposes. Do not use for any other purpose.
 *
 * @deprecated Use {@link com.riskrieg.palette.RkpColor instead}
 */
@Deprecated
public record LegacyColor(int id, String name, int r, int g, int b) implements Comparable<LegacyColor> {

  public LegacyColor {
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

  public LegacyColor(int id, String name, String hex) {
    this(id, name, Color.decode(hex).getRed(), Color.decode(hex).getGreen(), Color.decode(hex).getBlue());
  }

  public RkpColor toRkpColor() {
    return new RkpColor(id, name, r, g, b);
  }

  public Color toAwtColor() {
    return new Color(r, g, b);
  }

  @Override
  public int compareTo(LegacyColor o) {
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
    LegacyColor color = (LegacyColor) o;
    return id == color.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}

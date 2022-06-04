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

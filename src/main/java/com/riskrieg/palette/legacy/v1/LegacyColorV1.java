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
import java.awt.Color;
import java.util.Objects;

/**
 * Only included for legacy support purposes. Do not use for any other purpose.
 *
 * @deprecated Use {@link com.riskrieg.palette.RkpColor} instead.
 */
@Deprecated
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

  public RkpColor toRkpColor() {
    return new RkpColor(id.value(), name, r, g, b);
  }

  public Color toAwtColor() {
    return new Color(r, g, b);
  }

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


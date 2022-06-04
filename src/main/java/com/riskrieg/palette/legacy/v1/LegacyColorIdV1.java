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

/**
 * Only included for legacy support purposes. Do not use for any other purpose.
 * @param value the integer value
 * @deprecated Originally was a wrapper for the ordering value in {@link LegacyColorV1}, but it no longer became necessary. No replacement.
 */
@Deprecated
public record LegacyColorIdV1(int value) {

}

/*
 * Copyright (C) 2012 René Jeschke <rene_jeschke@yahoo.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rjeschke.neetutils.collections;

import com.github.rjeschke.neetutils.Objects;

/**
 *
 * @author René Jeschke (rene_jeschke@yahoo.de)
 *
 * @param <A>
 * @param <B>
 */
public class Tuple<A, B>
{
    public final A a;
    public final B b;

    public Tuple(final A a, final B b)
    {
        this.a = a;
        this.b = b;
    }

    public final static <A, B> Tuple<A, B> of(final A a, final B b)
    {
        return new Tuple<>(a, b);
    }

    @Override
    public int hashCode()
    {
        return (this.a == null ? 0 : this.a.hashCode()) * 31 + (this.b == null ? 0 : this.b.hashCode());
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (obj == this) return true;

        if (!(obj instanceof Tuple)) return false;

        final Tuple<?, ?> p = (Tuple<?, ?>)obj;

        return Objects.equals(this.a, p.a) && Objects.equals(this.b, p.b);
    }

    @Override
    public String toString()
    {
        return "(" + this.a.toString() + ", " + this.b.toString() + ")";
    }
}

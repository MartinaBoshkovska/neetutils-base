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
package com.github.rjeschke.neetutils;

public class Once<T>
{
    private final T first;
    private final T next;
    private boolean isFirst = true;

    public Once(final T first, final T next)
    {
        this.first = first;
        this.next = next;
    }

    public static <T> Once<T> of(final T first, final T next)
    {
        return new Once<>(first, next);
    }

    public void reset()
    {
        this.isFirst = true;
    }

    public T get()
    {
        if (this.isFirst)
        {
            this.isFirst = false;
            return this.first;
        }

        return this.next;
    }
}

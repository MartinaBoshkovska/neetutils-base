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
package com.github.rjeschke.neetutils.iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.rjeschke.neetutils.fn.FnPredicate;

/**
 *
 * @author René Jeschke (rene_jeschke@yahoo.de)
 *
 * @param <A>
 */
class XIterableFilter<A> extends AbstractXIterable<A>
{
    private final Iterable<? extends A>  iterable;
    private final FnPredicate<? super A> predicate;

    public XIterableFilter(final Iterable<? extends A> iterable, final FnPredicate<? super A> predicate)
    {
        this.iterable = iterable;
        this.predicate = predicate;
    }

    @Override
    public Iterator<A> iterator()
    {
        return new XIterableFilter.XIterator<>(this.iterable.iterator(), this.predicate);
    }

    private final static class XIterator<A> implements Iterator<A>
    {
        private final Iterator<? extends A>  iterator;
        private final FnPredicate<? super A> predicate;
        private boolean                      hasElement = false;
        private A                            element    = null;

        public XIterator(final Iterator<? extends A> iterator, final FnPredicate<? super A> predicate)
        {
            this.iterator = iterator;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext()
        {
            if (this.hasElement)
            {
                return true;
            }

            while (this.iterator.hasNext())
            {
                final A a = this.iterator.next();
                if (this.predicate.applyPredicate(a))
                {
                    this.element = a;
                    this.hasElement = true;
                    break;
                }
            }

            return this.hasElement;
        }

        @Override
        public A next()
        {
            if (!this.hasElement)
            {
                throw new NoSuchElementException();
            }

            final A e = this.element;

            this.hasElement = false;

            return e;
        }

        @Override
        public void remove()
        {
            throw new IllegalStateException("XIterators are read-only.");
        }
    }
}

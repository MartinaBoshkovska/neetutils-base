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
package com.github.rjeschke.neetutils.vectors;

public class Vector2d
{
    public double x;
    public double y;

    public Vector2d()
    {
        // 0
    }
    
    public Vector2d(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Vector2d(double xy)
    {
        this.x = xy;
        this.y = xy;
    }
    
    public Vector2d scale(double f)
    {
        this.x *= f;
        this.y *= f;
        return this;
    }
    
    public Vector2d add(Vector2d v)
    {
        this.x += v.x;
        this.y += v.y;
        return this;
    }
    
    public Vector2d add(Vector2d v, double scale)
    {
        this.x += v.x * scale;
        this.y += v.y * scale;
        return this;
    }
    
    public Vector2d sub(Vector2d v)
    {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }
    
    public Vector2d sub(Vector2d v, double scale)
    {
        this.x -= v.x * scale;
        this.y -= v.y * scale;
        return this;
    }
    
    public Vector2d mul(Vector2d v)
    {
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }
    
    public Vector2d mul(Vector2d v, double scale)
    {
        this.x *= v.x * scale;
        this.y *= v.y * scale;
        return this;
    }
    
    public Vector2d lerp(Vector2d v, double f)
    {
        this.x += (v.x - this.x) * f;
        this.y += (v.y - this.y) * f;
        return this;
    }
    
    public double dot(Vector2d v)
    {
        return this.x * v.x + this.y * v.y;
    }
    
    public Vector2d normalize()
    {
        double len = this.x * this.x + this.y * this.y;
        if(len != 0)
        {
            len = 1.0 / Math.sqrt(len);
            this.x *= len;
            this.y *= len;
        }
        return this;
    }
    
    public Vector2d negate()
    {
        this.x = -this.x;
        this.y = -this.y;
        return this;
    }
    
    public double length()
    {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public void intoArray(double[] arr, int offset)
    {
        arr[offset] = this.x;
        arr[offset + 1] = this.y;
    }
    
    @Override
    public Vector2d clone()
    {
        return new Vector2d(this.x, this.y);
    }

    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}

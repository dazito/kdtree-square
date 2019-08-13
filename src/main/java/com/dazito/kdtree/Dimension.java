package com.dazito.kdtree;

public class Dimension {

    public static final Dimension EMPTY = new Dimension(0, 0, 0);

    public static Dimension decode(String size) {
        String[] dimensions = size.split("x");

        return newInstance(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2]));
    }

    public static String encode(Dimension dto) {
        return encode(dto.getWidth(), dto.getDepth(), dto.getHeight());
    }

    public static String encode(int width, int depth, int height) {
        return width + "x" + depth + "x" + height;
    }

    public static Dimension newInstance(int width, int depth, int height) {
        return new Dimension(width, depth, height);
    }

    protected int width; // x
    protected int depth; // y
    protected int height; // z
    protected long volume;

    protected final String name;

    public Dimension(String name) {
        this.name = name;
    }

    public Dimension() {
        this(null);
    }

    public Dimension(String name, int w, int d, int h) {
        this.name = name;

        this.depth = d;
        this.width = w;
        this.height = h;

        calculateVolume();
    }

    protected void calculateVolume() {
        this.volume = ((long)depth) * ((long)width) * ((long)height);
    }

    public Dimension(int w, int d, int h) {
        this(null, w, d, h);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Dimension [width=" + width + ", depth=" + depth + ", height=" + height + ", volume=" + volume + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + depth;
        result = prime * result + height;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (volume ^ (volume >>> 32));
        result = prime * result + width;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dimension other = (Dimension) obj;
        if (depth != other.depth)
            return false;
        if (height != other.height)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (volume != other.volume)
            return false;
        if (width != other.width)
            return false;
        return true;
    }

    public void setDepth(int depth) {
        this.depth = depth;

        calculateVolume();
    }

    public void setHeight(int height) {
        this.height = height;

        calculateVolume();
    }

    public void setWidth(int width) {
        this.width = width;

        calculateVolume();
    }
}


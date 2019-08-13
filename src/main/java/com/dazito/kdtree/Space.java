package com.dazito.kdtree;

public class Space extends Dimension {

    private Space parent;

    private int x; // width
    private int y; // depth
    private int z; // height

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(final int z) {
        this.z = z;
    }

    public Space(Space parent, String name, int w, int d, int h, int x, int y, int z) {
        super(name, w, d, h);

        this.parent = parent;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Space(String name, int w, int d, int h, int x, int y, int z) {
        this(null, name, w, d, h, x, y, z);
    }

    @Override
    public String toString() {
        return "Space [name=" + name + ", " + x + "x" + y + "x" + z + ", width=" + width + ", depth=" + depth + ", height="
                + height + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Space other = (Space) obj;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }

}


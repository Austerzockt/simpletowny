package at.austerzockt.simpletowny.classes.utils.town;

import org.bukkit.Chunk;

public class Vector2 {
    public int x;
    public int z;

    public Vector2(int x, int y) {
        this.x = x;
        this.z = y;
    }
    public Vector2 clone() {
        return new Vector2(x,z);
    }
    public static Vector2 fromChunk(Chunk chunk) {
         return new Vector2(chunk.getX(),chunk.getZ());
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", z=" + z +
                '}';
    }
}


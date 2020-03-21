package at.austerzockt.simpletowny.classes.townsystem;

import org.bukkit.Chunk;

public class Vector2 {
    public int x, z;

    public Vector2(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static Vector2 fromChunk(Chunk c) {
        return new Vector2(c.getX(), c.getZ());
    }

}

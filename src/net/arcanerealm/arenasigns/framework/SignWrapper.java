
package net.arcanerealm.arenasigns.framework;

import java.util.List;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Kenny
 */
public class SignWrapper implements Sign
{
    private final Sign sign;
    
    public SignWrapper(Sign sign)
    {
        this.sign = sign;
    }
    @Override
    public String[] getLines()
    {
        return sign.getLines();
    }

    @Override
    public String getLine(int i) throws IndexOutOfBoundsException
    {
        return sign.getLine(i);
    }

    @Override
    public void setLine(int i, String string) throws IndexOutOfBoundsException
    {
        sign.setLine(i, string);
    }

    @Override
    public Block getBlock()
    {
        return sign.getBlock();
    }

    @Override
    public MaterialData getData()
    {
        return sign.getData();
    }

    @Override
    public Material getType()
    {
        return sign.getType();
    }

    @Override
    public int getTypeId()
    {
        return sign.getTypeId();
    }

    @Override
    public byte getLightLevel()
    {
        return sign.getLightLevel();
    }

    @Override
    public World getWorld()
    {
        return sign.getWorld();
    }

    @Override
    public int getX()
    {
        return sign.getX();
    }

    @Override
    public int getY()
    {
        return sign.getY();
    }

    @Override
    public int getZ()
    {
        return sign.getZ();
    }

    @Override
    public Location getLocation()
    {
        return sign.getLocation();
    }

    @Override
    public Location getLocation(Location lctn)
    {
        return sign.getLocation(lctn);
    }

    @Override
    public Chunk getChunk()
    {
        return sign.getChunk();
    }

    @Override
    public void setData(MaterialData md)
    {
        sign.setData(md);
    }

    @Override
    public void setType(Material mtrl)
    {
        sign.setType(mtrl);
    }

    @Override
    public boolean setTypeId(int i)
    {
        return sign.setTypeId(i);
    }

    @Override
    public boolean update()
    {
        return sign.update();
    }

    @Override
    public boolean update(boolean bln)
    {
        return sign.update(bln);
    }

    @Override
    public boolean update(boolean bln, boolean bln1)
    {
        return sign.update(bln, bln1);
    }

    @Override
    public byte getRawData()
    {
        return sign.getRawData();
    }

    @Override
    public void setRawData(byte b)
    {
        sign.setRawData(b);
    }

    @Override
    public void setMetadata(String string, MetadataValue mv)
    {
        sign.setMetadata(string, mv);
    }

    @Override
    public List<MetadataValue> getMetadata(String string)
    {
        return sign.getMetadata(string);
    }

    @Override
    public boolean hasMetadata(String string)
    {
        return sign.hasMetadata(string);
    }

    @Override
    public void removeMetadata(String string, Plugin plugin)
    {
        sign.removeMetadata(string, plugin);
    }

}

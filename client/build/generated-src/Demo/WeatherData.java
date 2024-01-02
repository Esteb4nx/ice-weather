//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `Printer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Demo;

public class WeatherData implements java.lang.Cloneable,
                                    java.io.Serializable
{
    public String city;

    public String temperature;

    public String description;

    public WeatherData()
    {
        this.city = "";
        this.temperature = "";
        this.description = "";
    }

    public WeatherData(String city, String temperature, String description)
    {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        WeatherData r = null;
        if(rhs instanceof WeatherData)
        {
            r = (WeatherData)rhs;
        }

        if(r != null)
        {
            if(this.city != r.city)
            {
                if(this.city == null || r.city == null || !this.city.equals(r.city))
                {
                    return false;
                }
            }
            if(this.temperature != r.temperature)
            {
                if(this.temperature == null || r.temperature == null || !this.temperature.equals(r.temperature))
                {
                    return false;
                }
            }
            if(this.description != r.description)
            {
                if(this.description == null || r.description == null || !this.description.equals(r.description))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Demo::WeatherData");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, city);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temperature);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, description);
        return h_;
    }

    public WeatherData clone()
    {
        WeatherData c = null;
        try
        {
            c = (WeatherData)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.city);
        ostr.writeString(this.temperature);
        ostr.writeString(this.description);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.city = istr.readString();
        this.temperature = istr.readString();
        this.description = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, WeatherData v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public WeatherData ice_read(com.zeroc.Ice.InputStream istr)
    {
        WeatherData v = new WeatherData();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<WeatherData> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, WeatherData v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<WeatherData> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(WeatherData.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final WeatherData _nullMarshalValue = new WeatherData();

    /** @hidden */
    public static final long serialVersionUID = -7403857879938780022L;
}
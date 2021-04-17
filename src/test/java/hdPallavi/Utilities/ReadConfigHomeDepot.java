package hdPallavi.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigHomeDepot {
	
	Properties prop;
	
	public ReadConfigHomeDepot()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("URL");
		return url;
	}
	
	public String getChromePath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		String iepath=prop.getProperty("iepath");
		return iepath;
	}

    public String getEdgePath()
    {
        String edgepath = prop.getProperty("edgepath");
        return edgepath;
    }
	
}

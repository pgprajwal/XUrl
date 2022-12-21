package com.crio.shorturl;

import java.util.HashMap;

public final class XUrlImpl implements XUrl
{
    private static final String url = "http://short.url/";
    private HashMap<String, String> longUrlMap = new HashMap<>();
    private HashMap<String, String> shortUrlMap = new HashMap<>();
    private HashMap<String, Integer> longUrlHitCount = new HashMap<>();

    private String generateAlphaNumericString(int n)
    {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder s = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            // Generate a random index between 0 to (alphaNumericString.length() - 1)
            int index = (int)(Math.random() * alphaNumericString.length());

            s.append(alphaNumericString.charAt(index));
        }
        
        return s.toString();  
    } 

    @Override
    public String registerNewUrl(String longUrl)
    {
        StringBuilder s = new StringBuilder(url);

        if(longUrlMap.containsKey(longUrl))
            return longUrlMap.get(longUrl);
        
        String generatedString = generateAlphaNumericString(9);

        s.append(generatedString);
        String shortUrl = s.toString();

        longUrlMap.put(longUrl, shortUrl);
        shortUrlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) 
    {
        if(longUrlMap.containsValue(shortUrl))
            return null;

        longUrlMap.put(longUrl, shortUrl);
        shortUrlMap.put(shortUrl, longUrl);
        
        return shortUrl;
    }

    @Override
    public String getUrl(String shortUrl) 
    {
        String longUrl = shortUrlMap.get(shortUrl);

        if(longUrlHitCount.containsKey(longUrl))
        {
            Integer count = longUrlHitCount.get(longUrl);
            count++;
            longUrlHitCount.put(longUrl, count);
        }
        else
            longUrlHitCount.put(longUrl, 1);

        return longUrl;
    }

    @Override
    public Integer getHitCount(String longUrl) 
    {
        if(longUrlHitCount.containsKey(longUrl))
        {
            Integer hitCount = longUrlHitCount.get(longUrl);
            return hitCount;
        }
        
        return 0;
        
    }

    @Override
    public String delete(String longUrl) 
    {
        String shorturl = longUrlMap.get(longUrl);
        shortUrlMap.remove(shorturl);

        return longUrlMap.remove(longUrl);
    }
    
}
package com.example.demo.components;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Component;


public class RestWebServiceImpl implements RestWebService{

    protected HanyuPinyinOutputFormat getFormat()
    {
        HanyuPinyinOutputFormat result = new HanyuPinyinOutputFormat();
        result.setVCharType(HanyuPinyinVCharType.WITH_V);
        result.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        result.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        return result;
    }

    public String paraseCharToPinyin(char c)
    {
        String result = null;

        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);

        try
        {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, getFormat());
        } catch (BadHanyuPinyinOutputFormatCombination e)
        {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c);
        }

        result = (null == pinyinArray || pinyinArray.length == 0) ?
                Character.toString(c) : pinyinArray[0];

        return result;
    }


    @Override
    public String convert(String text) {
        if(null==text||text.trim().length()==0)
        {
            return text;
        }

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++)
        {
            result.append(paraseCharToPinyin(text.charAt(i)));
        }

        return "<application xmlns='http://wadl.dev.java.net/2009/02'> <response>"+result.toString()+"</response> </application>";
    }
}

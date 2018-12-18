package com.luchao;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class demo {
	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        // 设置声调格式
        /**
         *  HanyuPinyinToneType.WITH_TONE_NUMBER 用数字表示声调，例如：liu2
            HanyuPinyinToneType.WITHOUT_TONE 无声调表示，例如：liu
            HanyuPinyinToneType.WITH_TONE_MARK 用声调符号表示，例如：liú
         */
        outputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        // 设置特殊拼音的显示格式
        /**
         *  HanyuPinyinVCharType.WITH_U_AND_COLON 以U和一个冒号表示该拼音，例如：lu:
            HanyuPinyinVCharType.WITH_V 以V表示该字符，例如：lv
            HanyuPinyinVCharType.WITH_U_UNICODE 以ü表示
         */
        outputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        // 设置大小写
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        
        String[] strings = PinyinHelper.toHanyuPinyinStringArray('赵', outputFormat);
        for (int i=0;i<strings.length; i++){
            char[] charArray = strings[i].toCharArray();
            for (int j =0;j<charArray.length;j++){
                System.out.println(charArray[i]);
            }
            
        }
    }
}
